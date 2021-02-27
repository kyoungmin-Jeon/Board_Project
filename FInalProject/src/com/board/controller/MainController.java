package com.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.beans.BoardInfoBean;
import com.board.beans.ContentBean;
import com.board.service.MainServiceImpl;
import com.board.service.TopMenuServiceImpl;

@Controller
public class MainController {
	@Autowired
	private MainServiceImpl mainService;

	@Autowired
	private TopMenuServiceImpl topMenuService;

	@GetMapping("/main")
	public String main(Model model) throws Exception {

		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();

		for (int i = 1; i <= 4; i++) {
			List<ContentBean> list1 = mainService.getMainList(i);
			list.add(list1);
		}

		model.addAttribute("list", list);

		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);

		return "main";
	}
}
