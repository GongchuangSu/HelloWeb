package com.gongchuangsu.helloweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	/**
	 * 登陆界面
	 */
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		// 获取表单提交的数据
		String userName = request.getParameter("userName");
		String userPsd = request.getParameter("userPsd");
		// 创建模型对象用来返回
		ModelAndView mv = new ModelAndView();
		if("admin".equals(userName) && "admin".equals(userPsd)){
			mv.addObject("userName", userName);
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
			@RequestParam(value = "name", required = false, defaultValue = "admin") String userName){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userName", userName);
		return mv;
	}
}
