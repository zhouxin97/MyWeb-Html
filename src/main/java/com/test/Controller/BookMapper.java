package com.test.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	public BookMapper() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO 自动生成的方法存根
		Book book = new Book();
		book.setBookid(rs.getInt("bookid"));
		book.setBookname(rs.getString("bookname"));
		book.setAuthor(rs.getString("author"));
		book.setBorrow_Date(rs.getDate("Borrow_Date"));
		book.setReturn_Date(rs.getDate("return_date"));
		book.setDate(rs.getString("year"));
		book.setPublish(rs.getString("publisher"));
		book.setIsbn(rs.getString("isbn"));
		book.setStatus(rs.getString("status"));
		return book;
	}

}
