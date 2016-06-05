package com.slawek.wordlearning.server.db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

import static com.slawek.wordlearning.server.CollectionUtils.replaceCollection;

@Document(collection = Lesson.COLLECTION_NAME)
public class Lesson {
	public static final String COLLECTION_NAME = "lesson";

	@Id
	private String id;
	private final List<Word> words = new ArrayList<>();
	private Long version;
	private String textToSpeech;
	private String name;
	private Picture picture;
	private Long level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		replaceCollection(this.words, words);
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getTextToSpeech() {
		return textToSpeech;
	}

	public void setTextToSpeech(String textToSpeech) {
		this.textToSpeech = textToSpeech;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
}
