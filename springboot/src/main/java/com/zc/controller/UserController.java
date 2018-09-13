package com.zc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zc.MyWebMvcConfig;
import com.zc.pojo.User;
import com.zc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/loginCheck")
	public String login(String username, String password, HttpSession session){
		User user = userService.findUserByUsernameAndPassword(username, password);
		System.out.println("user:" + user);
		System.out.println(user == null);
		if(user == null || user.equals("")){
			System.out.println("1");
			return "redirect:/login.html";
		}else{
			System.out.println("2");
			session.setAttribute(MyWebMvcConfig.SESSION_KEY, username);
			return "index3";
		}
	}
	

}
