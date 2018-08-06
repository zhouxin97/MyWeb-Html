package com.test.Controller;

import java.sql.Date;

public class Book {
	
	
	private Integer bookid;
	private String bookname;
	private String author;
	private String publisher;
	
	private String  year;
	private String isbn;
	private Date borrow_date;
	private Date return_date;
	
	private String status;
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublish(String publisher) {
		this.publisher =publisher;
		
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getAuthoer() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDate() {
		return year;
	}
	public void setDate(String year) {
		this.year =year;
	}
	public Date getBorrow_Date() {
		return borrow_date;
	}
	public void setBorrow_Date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getReturn_Date() {
		return return_date;
	}
	public void setReturn_Date(Date return_date) {
		this.return_date =return_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
