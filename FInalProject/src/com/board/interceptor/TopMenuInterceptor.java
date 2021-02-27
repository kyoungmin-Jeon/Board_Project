package com.board.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.board.beans.BoardInfoBean;
import com.board.beans.UserBean;
import com.board.service.TopMenuServiceImpl;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	@Autowired
	private TopMenuServiceImpl topMenuService;

	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		
		request.setAttribute("topMenuList", topMenuList);
		
		request.setAttribute("loginUserBean",loginUserBean);
		
		return true;
	}
}
