package com.test.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		//user.setPasswordAgain(rs.getString("passwordAgain"));
		user.setPhonenumber(rs.getString("phonenumber"));
		//user.setPasswordAgain(rs.getString("passwordAgain_new1"));
		//user.setPasswordAgain(rs.getString("passwordAgain_new2"));
		//user.setPasswordAgain(rs.getString("password_old"));
		return user;
	}


}

