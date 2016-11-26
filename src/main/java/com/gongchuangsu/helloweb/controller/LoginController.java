package com.gongchuangsu.helloweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gongchuangsu.helloweb.model.User;
import com.gongchuangsu.helloweb.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 登陆界面
	 */
	@RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
	public void login(){
		
	}
	
	// 显示注册界面
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "register";
	}
	
	// 处理注册页面
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(){
		return "redirect:.";
	}
}
