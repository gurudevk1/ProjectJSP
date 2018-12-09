package com.guru.bean;

import java.util.Date;

public class Film {
	private Integer filmId;
	private String title;
	private String description;
	private Date releaseYear;
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		//new chnage 
		this.title = title;
	}
	public String getDescription() {
		//new branch
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

}
