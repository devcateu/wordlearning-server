package com.slawek.wordlearning.server.rest.model;

import java.util.ArrayList;
import java.util.List;

import static com.slawek.wordlearning.server.CollectionUtils.replaceCollection;

public class LessonRest {
	private final List<WordRest> words = new ArrayList<>();
	private Long version;
	private String textToSpeech;
	private String name;
	private PictureRest picture;
	private Long level;

	public List<WordRest> getWords() {
		return words;
	}

	public void setWords(List<WordRest> words) {
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

	public PictureRest getPicture() {
		return picture;
	}

	public void setPicture(PictureRest picture) {
		this.picture = picture;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	@Override public String toString() {
		return "LessonRest{" +
				"words=" + words +
				", version=" + version +
				", textToSpeech='" + textToSpeech + '\'' +
				", name='" + name + '\'' +
				", picture=" + picture +
				", level=" + level +
				'}';
	}
}
