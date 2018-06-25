package com.shivam.books;

import javax.persistence.*;

@Entity
public class Author {
	
	@Id
	private String aid;
	@Column(name="author_name")
	private String name;
	private int dob;
	
	@OneToOne
	private Book b;
	
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	
	
}
