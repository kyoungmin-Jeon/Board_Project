package com.board.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.beans.UserBean;
import com.board.service.UserServiceImpl;
import com.board.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail,
						Model model) throws Exception {
		
		model.addAttribute("fail", fail);
	
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, BindingResult result)throws Exception {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUserInfo(tempLoginUserBean);
		
		if(loginUserBean.isUserLogin() == true) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean)throws Exception {
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result)throws Exception {
		if(result.hasErrors()) {
			return "user/join";
		}
		
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success";
	}
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute("deleteUserBean")UserBean deleteUserBean,
						 Model model)throws Exception {
		
		userService.getDeleteUserInfo(deleteUserBean);
		
		int user_idx = deleteUserBean.getUser_idx();
		
		model.addAttribute("user_idx",user_idx);
		
		return"user/delete";
	}
	
	@PostMapping("/delete_pro")
	public String delete_pro(@Valid @ModelAttribute("deleteUserBean") UserBean deleteUserBean,BindingResult result,
							 @RequestParam("user_pw") String user_pw,
							 @RequestParam("user_idx") int user_idx,
							 Model model)throws Exception {

		System.out.println(loginUserBean.getUser_pw());
		System.out.println(deleteUserBean.getUser_pw());
		
		if(loginUserBean.getUser_pw().equals(deleteUserBean.getUser_pw()) && deleteUserBean.getUser_pw().equals(deleteUserBean.getUser_pw2())   ) {
			
			userService.deleteUserInfo(user_idx);
			
			return"user/delete_success";
		}
		else if(result.hasErrors()) {
			return"user/delete";
		}
		
		return"user/delete_fail";
		
		
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean)throws Exception {
		
		userService.getModifyUserInfo(modifyUserBean);
		
		return "user/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result)throws Exception {
		
		if(result.hasErrors()) {
			return "user/modify";
		}
		
		userService.modifyUserInfo(modifyUserBean);
		
		return "user/modify_success";
	}
	
	@GetMapping("/logout")
	public String logout()throws Exception {
		
		loginUserBean.setUserLogin(false);
		
		return "user/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() throws Exception{
		return "user/not_login";
	}
	
	@GetMapping("/findid")
	public String findid(@ModelAttribute("findIdUserBean")UserBean findIdUserBean,
						 Model model) throws Exception{
		
		return"user/findid";
	}

	@PostMapping("findid_pro")
	public String findid_pro(@ModelAttribute("findIdUserBean")UserBean findIdUserBean,
							 Model model )throws Exception {

		
		String result = userService.findIdUserInfo(findIdUserBean);
		
		if(result != null) {
			
			model.addAttribute("result",result);
			
			return"user/findid_success";
		}
			return"user/findid_fail";
	}
	
	@GetMapping("findpw")
	public String findpw(@ModelAttribute("findPwUserBean")UserBean findPwUserBean)throws Exception {
		
		return"user/findpw";
	}
	
	@PostMapping("findpw_pro")
	public String findpw_pro(@ModelAttribute("findPwUserBean") UserBean findPwUserBean, Model model)throws Exception {
		
		String result = userService.findPwUserInfo(findPwUserBean);
		
		if(result != null) {
						
			String user_name = result;
			
			model.addAttribute("user_name",user_name);
			
			return "redirect:/user/updatePw";
		} else {
			return "user/findpw_fail";
		}
	}
	
	@GetMapping("updatePw")
	public String updatePw(@ModelAttribute("updatePwUserBean")UserBean updatePwUserBean,
						   @RequestParam("user_name")String user_name,
						   	Model model)throws Exception {

		model.addAttribute("user_name",user_name);
		
		return"user/updatePw";
	}
	
	@PostMapping("updatePw_pro")
	public String updatePw_pro(@ModelAttribute("updatePwUserBean")UserBean updatePwUserBean,
							   @RequestParam("user_name") String user_name, Model model)throws Exception {
		
		if(updatePwUserBean.getUser_pw().equals(updatePwUserBean.getUser_pw2())) {
			userService.updatePw(updatePwUserBean);
				return"user/updatePw_success";
		}
		
		model.addAttribute("user_name",user_name);
		
		return"user/updatePw_fail";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)throws Exception {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
}








