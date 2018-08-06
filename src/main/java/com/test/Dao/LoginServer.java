package com.test.Dao;

import java.sql.Types;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.Controller.User;
import com.test.Controller.UserMapper;
public class LoginServer {
	 private JdbcTemplate jdbcTemplateObject;
	 
	 
	   public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	   public boolean checkLogin(String username,String password)	{
		  boolean flage=false; 
	   if(username!=null||password!=null) {
		   String SQL = "Select count(*) from UserMessage where username = '"+username +"' and  password = '"+password+"'";
		   Integer count = jdbcTemplateObject.queryForObject(SQL,Integer.class);
		   
		   if(count<=0) {
			  flage = false; 
		   }else {
			   flage = true;
		   }
		   return flage;
		   
	   }else {
		   return flage;
	   }
	   }
	   public boolean AddUser(User user) {
		   String Sql = "Select count(*) from UserMessage where username = '"+user.getUsername() +"'";
		   Integer count = jdbcTemplateObject.queryForObject(Sql,Integer.class);	   
		   if(count == 0||user.getPassword()==user.getPasswordAgain()) {
			   String SQL = "insert into usermessage(username,password,phonenumber) values(?,?,?)";
			   return jdbcTemplateObject.update(SQL,
					    new Object[] { user.getUsername(),user.getPassword(),user.getPhonenumber() },
				    new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR }) == 1;		   
		   }else {		 			   	
			   return  false;
		   }   
	   }

	   public String DeltUser() {
		   return null;
	   }
	   
	   public boolean UpdateUser(User user) {
			   String Sql="update UserMessage set password=? where username = '"+user.getUsername()+"'";
			   Object UserObj[] = new Object[] {user.getPasswordAgain_new1()};
					  return jdbcTemplateObject.update(Sql, UserObj) == 1;
		   
		
	   }
	   public boolean Check_username(User user) {
		   String sql = "Select password from UserMessage where username = '"+user.getUsername()+"'";
		   String password_old =jdbcTemplateObject.queryForObject(sql,String.class);
		   if(password_old.equals(user.getPassword_old())) {
			   return true;
		   }else {
			  
			   return false;
		   }
		   
	   }
	   public List<User> listStudents(String name) {
//		   String name =(String) session.getAttribute("LoginUser");  
		   String sql = "select username,password,phonenumber from UserMessage where username like '%" + name + "%'";
		   List <User> user = jdbcTemplateObject.query(sql,new UserMapper());
		   return user;
				   
	   }
	   public User FindUser(String name) {
		   //String name =(String) session.getAttribute("LoginUser");
		   //System.out.println("Session value:"+name);
		   String sql = "select username,password,phonenumber from UserMessage where username = '" + name + "'";
		   User user = jdbcTemplateObject.queryForObject(sql, new UserMapper());
			 return user;
	   }
	   public String SessionShow(HttpSession session ) {
		   String name = (String) session.getAttribute("LoginUser");
		   
		   return name;
		   
	   }


	   
	  
}

