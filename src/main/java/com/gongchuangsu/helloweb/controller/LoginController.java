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
	 * ��½����
	 */
	@RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
	public void login(){
		
	}
	
	// ��ʾע�����
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "register";
	}
	
	// ����ע��ҳ��
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(){
		return "redirect:.";
	}
}
