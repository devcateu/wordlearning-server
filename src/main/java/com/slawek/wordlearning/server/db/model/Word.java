package com.slawek.wordlearning.server.db.model;

import java.util.ArrayList;
import java.util.List;

import static com.slawek.wordlearning.server.CollectionUtils.replaceCollection;

public class Word {
	private final List<Sentence> sentences = new ArrayList<>();
	private String word;
	private String definition;
	private String sentenceToFill;
	private String translation;
	private Picture picture;

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
}
