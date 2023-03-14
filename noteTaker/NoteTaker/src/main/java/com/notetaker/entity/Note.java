package com.notetaker.entity;

import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Note {
	@Id
	@GeneratedValue()
	@Column
	private Integer ID;
	@Column
	private String Title;
	@Column
	private String Content;
	@Column
	private LocalDate addedDate;
	
	
//	LocalDate myObj = LocalDate.now();
		
	public Note() {
		super();
	}

	public Note(String title, String content) {
		super();
		Title = title;
		Content = content;
		addedDate = LocalDate.now();
	}

	
	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getID() {
		return ID;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
		

}
