package com.board.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.board.beans.UserBean;
import com.board.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkuserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
		}
	}
	
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.modifyUserInfo(modifyUserBean);
	}
	
	public void getDeleteUserInfo(UserBean deleteUserBean) {
		
		UserBean tempDeleteUserBean = userDao.getDeleteUserInfo(loginUserBean.getUser_idx());
		
		deleteUserBean.setUser_id(tempDeleteUserBean.getUser_id());
		deleteUserBean.setUser_name(tempDeleteUserBean.getUser_name());
		deleteUserBean.setUser_num(tempDeleteUserBean.getUser_num());
		loginUserBean.setUser_pw(tempDeleteUserBean.getUser_pw());
		deleteUserBean.setUser_idx(loginUserBean.getUser_idx());
		
	}
	
	public void deleteUserInfo(String user_pw) {
		
		loginUserBean.setUserLogin(false);
		
		userDao.deleteUserInfo(user_pw);
	}

	public String findIdUserInfo(UserBean findIdUserBean) {
		return userDao.findIdUserInfo(findIdUserBean);
	}
	
	public String findPwUserInfo(UserBean findPwUserBean) {
		return userDao.findPwUserInfo(findPwUserBean);
	}
	
	public void updatePw(UserBean updatePwUserBean) {
		
		userDao.updatePw(updatePwUserBean);
	}
}











