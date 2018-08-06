package com.test.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.test.Dao.SearchBookServlet;

@Controller
public class BookSearchController {
	@RequestMapping(value = "/Book_Show")
	public ModelAndView Book () {
		return new ModelAndView("Book_Show","command",new Book());
	}
	@RequestMapping(value="/BookSearch")
	public String SearchBook(HttpServletRequest request,HttpServletResponse response) throws IOException {
			ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
			SearchBookServlet userJDBCTemplate = (SearchBookServlet) context.getBean("SearchBookServerJDBCTemplate");
			String bookid = request.getParameter("bookid");
			System.out.println("传入后端所要查找书本的BOOKID为:"+bookid);
			List<Book> book = userJDBCTemplate.SearchBookMessages("400000003");
			System.out.println("2");
		     for (Book record : book) {
		    	 
		         System.out.print("bookid : " +record.getBookid());
		         
		         System.out.print(", bookname : " + record.getBookname());
		         System.out.println(",Author : " + record.getAuthoer());
		         System.out.println(", publisher : " + record.getPublisher());
		         System.out.print(",year : " + record.getDate());
		         System.out.print(", borrow_date : " + record.getBorrow_Date());
		         System.out.println(", return_date : " + record.getReturn_Date());
		         System.out.print(",Isbn : " + record.getIsbn());
		         System.out.print(", status : " + record.getStatus());       
		      }	
		     
		return "Book_Show";
	}
	
}
