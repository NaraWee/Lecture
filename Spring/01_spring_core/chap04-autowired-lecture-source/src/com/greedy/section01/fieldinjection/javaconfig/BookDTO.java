package com.greedy.section01.fieldinjection.javaconfig;

import java.util.Date;

public class BookDTO {

	private int sequence;
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private java.util.Date createDate;
	
	public BookDTO() {}

	public BookDTO(int sequence, int isbn, String title, String author, String publisher, Date createDate) {
		super();
		this.sequence = sequence;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.createDate = createDate;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BookDTO [sequence=" + sequence + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", publisher=" + publisher + ", createDate=" + createDate + "]";
	}	
	
}
