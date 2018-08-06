package com.test.Controller;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.test.Dao.LoginServer;
import com.test.Json.JsonDemo;


@Controller
public class LoginController {
	@RequestMapping(value = "/index")
	public ModelAndView Login() {
		return new ModelAndView("index", "command", new User());
	}
	
	@RequestMapping(value = "/LoginCheck", method = RequestMethod.POST)
	public String CheckLogin(User user,HttpSession session) throws JSONException{
	ApplicationContext context = 
						new ClassPathXmlApplicationContext("bean.xml");
    LoginServer userJDBCTemplate =
    					(LoginServer) context.getBean("LoginJDBCTemplate");
	boolean check = userJDBCTemplate.checkLogin(user.getUsername(),user.getPassword());	
		if(check) {
			System.out.println("ÕýÈ·");
			session.setAttribute("LoginUser",user.getUsername());  
			JsonDemo jsonDemo =new JsonDemo();
			jsonDemo.Create(user);
			((AbstractApplicationContext) context).close();
			return "Mainweb";
		}else {
			System.out.println("Ê§°Ü");
			((AbstractApplicationContext) context).close();
			return "index";
		}		
	}
	@RequestMapping(value = "/ForgetPassword")
	public ModelAndView ForgetPassword () {
		return new ModelAndView("ForgetPassword");
	}
	

	

}
