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
	 * ��½����
	 */
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		// ��ȡ���ύ������
		String userName = request.getParameter("userName");
		String userPsd = request.getParameter("userPsd");
		// ����ģ�Ͷ�����������
		ModelAndView mv = new ModelAndView();
		if("admin".equals(userName) && "admin".equals(userPsd)){
			mv.addObject("userName", userName);
			mv.setViewName("redirect:/home");
		}else{
			mv.addObject("error", "��¼ʧ�ܣ��볢�����µ�½��");
			mv.setViewName("/login");
		}
		return mv;
	}
	
	/**
	 * ��ҳ
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(
			@RequestParam(value = "name", required = false, defaultValue = "admin") String userName){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userName", userName);
		return mv;
	}
}
