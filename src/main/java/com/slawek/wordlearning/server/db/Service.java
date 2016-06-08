package com.slawek.wordlearning.server.db;

import com.slawek.wordlearning.server.db.model.Lesson;
import com.slawek.wordlearning.server.db.model.Picture;
import com.slawek.wordlearning.server.db.model.Sentence;
import com.slawek.wordlearning.server.db.model.Word;
import com.slawek.wordlearning.server.db.repositories.LessonRawDataRepository;
import com.slawek.wordlearning.server.db.repositories.LessonRepository;
import com.slawek.wordlearning.server.populator.Populator;
import com.slawek.wordlearning.server.rest.model.LessonRest;
import com.slawek.wordlearning.server.rest.model.PictureRest;
import com.slawek.wordlearning.server.rest.model.SentenceRest;
import com.slawek.wordlearning.server.rest.model.WordRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Component
public class Service {

	@Autowired
	private LessonRawDataRepository lessonRawDataRepository;
	@Autowired
	private LessonRepository repository;
	@Autowired
	private Populator populator;

	public String getLesson(String id) {
		return lessonRawDataRepository.query(id);
	}

	public List<String> getAllIds() {
		return lessonRawDataRepository.getAllLessonIds();
	}

	public void save(LessonRest lessonRest) {
		Lesson lesson = new Lesson();
		lesson.setName(lessonRest.getName());
		lesson.setLevel(lessonRest.getLevel());
		lesson.setVersion(lessonRest.getVersion());
		lesson.setTextToSpeech(lessonRest.getTextToSpeech());
		lesson.setPicture(mapPicture(lessonRest.getPicture()));

		lessonRest.getWords().forEach(wordRest -> lesson.getWords().add(mapWord(wordRest)));

		populator.populateToExternalServers(lessonRest);
		repository.save(lesson);
	}
	
	public void delete(String id) {
		repository.delete(id);
	}

	private Word mapWord(WordRest wordRest) {
		Word word = new Word();
		word.setPicture(mapPicture(wordRest.getPicture()));
		word.setDefinition(wordRest.getDefinition());
		word.setSentenceToFill(wordRest.getSentenceToFill());
		word.setTranslation(wordRest.getTranslation());
		word.setWord(wordRest.getWord());

		wordRest.getSentences().forEach(sentenceRest -> word.getSentences().add(mapSentence(sentenceRest)));

		return word;
	}

	private Sentence mapSentence(SentenceRest sentenceRest) {
		Sentence sentence = new Sentence();
		sentence.setTranslation(sentenceRest.getTranslation());
		sentence.setSentence(sentenceRest.getSentence());
		return sentence;
	}

	private Picture mapPicture(PictureRest pictureRest) {
		Picture picture = new Picture();
		if(pictureRest.getSerializedPicture() != null){
			picture.setSerializedPicture(pictureRest.getSerializedPicture());
		} else {
			String picturePath = pictureRest.getPicturePath();
			try {
				byte[] bytes = Files.readAllBytes(Paths.get(picturePath));
				String encoded = Base64.getEncoder().encodeToString(bytes);
				picture.setSerializedPicture(encoded);
				pictureRest.setSerializedPicture(encoded);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return picture;
	}
}
