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
	 * ��½����
	 */
	@RequestMapping(value = "login", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		// ��ȡ���ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ����ģ�Ͷ�����������
		ModelAndView mv = new ModelAndView();
		if(userService.getUserByLogin(username, password)){
			mv.addObject("username", username);
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
			@RequestParam(value = "name", required = false, defaultValue = "admin") String username){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("username", username);
		return mv;
	}
}
