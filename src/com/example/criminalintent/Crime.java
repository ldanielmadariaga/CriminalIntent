package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Crime {

	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_SOLVED = "solved";
	private static final String JSON_DATE = "date";
	private static final String JSON_PHOTO = "photo";
	private static final String JSON_SUSPECT = "suspect";

	private UUID id;
	private String title;
	private Date date;
	private boolean isSolved;
	private Photo photo;
	private String suspect;

	public Crime() {
		this.id = UUID.randomUUID();
		this.date = new Date();
	}

	public Crime(JSONObject jsonObject) throws JSONException {
		this.id = UUID.fromString(jsonObject.getString(JSON_ID));
		if (jsonObject.has(JSON_TITLE)) {
			this.title = jsonObject.getString(JSON_TITLE);
		}
		this.isSolved = jsonObject.getBoolean(JSON_SOLVED);
		// TODO Find a non-deprecated fix
		this.date = new Date(jsonObject.getLong(JSON_DATE));
		if (jsonObject.has(JSON_PHOTO)) {
			photo = new Photo(jsonObject.getJSONObject(JSON_PHOTO));
		}
		if (jsonObject.has(JSON_SUSPECT)) {
			suspect = jsonObject.getString(JSON_SUSPECT);
		}

	}

	public JSONObject toJSON() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(JSON_DATE, getDate().getTime());
		jsonObject.put(JSON_ID, getId());
		jsonObject.put(JSON_SOLVED, isSolved);
		jsonObject.put(JSON_TITLE, getTitle());
		if (photo != null) {
			jsonObject.put(JSON_PHOTO, photo.toJSON());
		}
		return jsonObject;
	}

	@Override
	public String toString() {
		return title;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getSuspect() {
		return suspect;
	}

	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}

}
