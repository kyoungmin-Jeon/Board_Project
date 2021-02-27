package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.beans.BoardInfoBean;
import com.board.dao.TopMenuDaoImpl;

@Service
public class TopMenuServiceImpl {
	
	@Autowired
	private TopMenuDaoImpl topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList()throws Exception{
		List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
		return topMenuList;
	}
	
}
