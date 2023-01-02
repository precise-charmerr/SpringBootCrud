package com.example.mysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookId;
	private String bookName;
	private String bookAuthor;
	
	
	public Book() {
	}
	
	public Book(long bookId, String bookName, String bookAuthor) {
		BookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}


	public long getBookId() {
		return BookId;
	}
	public void setBookId(long bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
	
	
}
