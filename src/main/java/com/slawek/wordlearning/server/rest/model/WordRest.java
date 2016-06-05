package com.slawek.wordlearning.server.rest.model;

import java.util.ArrayList;
import java.util.List;

import static com.slawek.wordlearning.server.CollectionUtils.replaceCollection;

public class WordRest {
	private final List<SentenceRest> sentences = new ArrayList<>();
	private String word;
	private String definition;
	private String sentenceToFill;
	private String translation;
	private PictureRest picture;

	public List<SentenceRest> getSentences() {
		return sentences;
	}

	public void setSentences(List<SentenceRest> sentences) {
		replaceCollection(this.sentences, sentences);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getSentenceToFill() {
		return sentenceToFill;
	}

	public void setSentenceToFill(String sentenceToFill) {
		this.sentenceToFill = sentenceToFill;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public PictureRest getPicture() {
		return picture;
	}

	public void setPicture(PictureRest picture) {
		this.picture = picture;
	}

	@Override public String toString() {
		return "WordRest{" +
				"sentences=" + sentences +
				", word='" + word + '\'' +
				", definition='" + definition + '\'' +
				", sentenceToFill='" + sentenceToFill + '\'' +
				", translation='" + translation + '\'' +
				", picture=" + picture +
				'}';
	}
}
