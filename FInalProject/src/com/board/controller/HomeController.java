package com.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.beans.UserBean;

@Controller
public class HomeController {
	
//	@Resource(name= "loginUserBean")
//	@Lazy
//	private UserBean loginUserBean;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
//		System.out.println(loginUserBean);
		
		return "redirect:/main";
	}
}
