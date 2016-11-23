package com.gongchuangsu.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/**
	 * µÇÂ½½çÃæ
	 */
	@RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
	public void login(){
	}
	
	/**
	 * Ê×Ò³
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(
			@RequestParam(value = "name", required = false, defaultValue = "admin") String username){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("username", username);
		return mv;
	}
}
