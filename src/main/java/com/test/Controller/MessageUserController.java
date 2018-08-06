package com.test.Controller;

import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;







@Controller

public class MessageUserController {
	@RequestMapping(value = "/Message_User")
	public ModelAndView Message ( HttpSession session) throws JSONException {		
		return new ModelAndView("Message_User");
	}
//	@RequestMapping(value = "/Message")
//	public String Message_Form(HttpSession session ) {
//		String loginuser= (String) session.getAttribute("LoginUser");
//		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//		LoginServer userJDBCTemplate =(LoginServer) context.getBean("LoginJDBCTemplate");
//	    List<User> users = userJDBCTemplate.listStudents(session);
//	      for (User record : users) {
//	         System.out.print("ID : " + record.getUsername());
//	         System.out.print(", Name : " + record.getPassword());
//	         System.out.println(", phone : " + record.getPhonenumber());
//	      }
//		User user = userJDBCTemplate.FindUser(session);
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getPhonenumber());
//
//		
//		return "Message_User";
//	}

}
