package com.test.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.Dao.LoginServer;

@Controller
public class ChangeController {

	@RequestMapping(value = "/Changes")
	public ModelAndView Changes () {
		return new ModelAndView("Changes","command",new User());
	}
	@RequestMapping(value="/changing" ,method=RequestMethod.POST)
	public String Changing(HttpSession session,User change_user,Model model) {
		String loginuser= (String) session.getAttribute("LoginUser");
	
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		LoginServer userJDBCTemplate =(LoginServer) context.getBean("LoginJDBCTemplate");
		if(loginuser.equals(change_user.getUsername())) {
			if(userJDBCTemplate.Check_username(change_user)) {
				if(change_user.getPasswordAgain_new1().equals(change_user.getPasswordAgain_new2())) {
					userJDBCTemplate.UpdateUser(change_user);
				}else {
					System.out.println("两次输入的新密码不相同！");
				}
				
			}else {
				 String warn_1 ="当前密码与原始密码不符！";
				 System.out.println(warn_1);
			}
		}else {
			String msg = "当前所登账号与填入账号不符！";
			System.out.println(msg);
			
		}
		model.addAttribute("name",change_user.getUsername());
		((AbstractApplicationContext) context).close();
		return "Mainweb";
		
	}
	
}
