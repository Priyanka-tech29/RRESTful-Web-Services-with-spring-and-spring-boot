package com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {

	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	public Books() {
		
	}
	public Books(int id, String name, String autor) {
		super();
		this.id = id;
		this.name = name;
		this.author = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String autor) {
		this.author = autor;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
}
