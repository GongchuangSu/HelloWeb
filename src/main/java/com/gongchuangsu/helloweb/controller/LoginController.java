package com.gongchuangsu.helloweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gongchuangsu.helloweb.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	/**
	 * 登陆界面
	 */
	@RequestMapping(value = "login", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		// 获取表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 创建模型对象用来返回
		ModelAndView mv = new ModelAndView();
		if(userService.getUserByLogin(username, password)){
			mv.addObject("username", username);
			mv.setViewName("redirect:/home");
		}else{
			mv.addObject("error", "登录失败，请尝试重新登陆！");
			mv.setViewName("/login");
		}
		return mv;
	}
	
	/**
	 * 首页
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(
			@RequestParam(value = "name", required = false, defaultValue = "admin") String username){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("username", username);
		return mv;
	}
}
