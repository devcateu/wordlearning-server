package com.slawek.wordlearning.server.rest.model;

public class PictureRest {
	private String picturePath;
	private String serializedPicture;

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getSerializedPicture() {
		return serializedPicture;
	}

	public void setSerializedPicture(String serializedPicture) {
		this.serializedPicture = serializedPicture;
	}
	
	@Override public String toString() {
		return "PictureRest{" +
				"picturePath='" + picturePath + '\'' +
				'}';
	}
}
