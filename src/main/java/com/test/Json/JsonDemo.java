package com.test.Json;

import org.json.JSONException;
import org.json.JSONObject;
import com.test.Controller.User;


public class JsonDemo {

	public JsonDemo() {
		// TODO 自动生成的构造函数存根
	}
	public void  Create(User user) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("username",user.getUsername());
		obj.put("password",user.getPassword());
		obj.put("phonenumber",user.getPhonenumber());
		System.out.println(obj);
		
	}

}
