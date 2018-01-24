package com.meetpaija.toDo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo_table")
public class toDo_model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="createdon")
	private String createdon;
	
	@Column(name="modifiedon")
	private String modifiedon;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getcreatedon() {
		return createdon;
	}

	public void setcreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getmodifiedon() {
		return modifiedon;
	}

	public void setmodifiedon(String modifiedon) {
		this.modifiedon = modifiedon;
	}

	
}
