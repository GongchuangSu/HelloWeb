package com.gongchuangsu.helloweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TablesController {
	
	@RequestMapping(value = "tables", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView home(HttpServletRequest request, 
			HttpServletResponse response){
		String username = request.getParameter("username");
		ModelAndView mv = new ModelAndView("tables");
		mv.addObject("username", username);
		return mv;
	}
}
