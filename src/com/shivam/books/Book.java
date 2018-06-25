package com.shivam.books;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="Book")
public class Book {
	
	@Id
	private String bid;
	@Column(name="book_name")
	private String name;
	private String genre;
	private String author;
	private float price;
	
	@ManyToOne
	private Author at;
	
	
	public Author getAt() {
		return at;
	}
	public void setAt(Author at) {
		this.at = at;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
