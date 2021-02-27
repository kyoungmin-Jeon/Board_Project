package com.board.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.board.beans.UserBean;
import com.board.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkuserIdExist(String user_id)throws Exception {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addUserInfo(UserBean joinUserBean)throws Exception {
		userDao.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tempLoginUserBean)throws Exception {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
		}
	}
	
	public void getModifyUserInfo(UserBean modifyUserBean) throws Exception {
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
	
	public void modifyUserInfo(UserBean modifyUserBean)throws Exception {
		
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.modifyUserInfo(modifyUserBean);
	}
	
	public void getDeleteUserInfo(UserBean deleteUserBean)throws Exception {
		
		UserBean tempDeleteUserBean = userDao.getDeleteUserInfo(loginUserBean.getUser_idx());
		
		deleteUserBean.setUser_id(tempDeleteUserBean.getUser_id());
		deleteUserBean.setUser_name(tempDeleteUserBean.getUser_name());
		deleteUserBean.setUser_num(tempDeleteUserBean.getUser_num());
		loginUserBean.setUser_pw(tempDeleteUserBean.getUser_pw());
		deleteUserBean.setUser_idx(tempDeleteUserBean.getUser_idx());
		
	}
	
	public void deleteUserInfo(int user_idx)throws Exception {
		
		user_idx= loginUserBean.getUser_idx();
		
		loginUserBean.setUserLogin(false);
		
		userDao.deleteUserInfo(user_idx);
	}

	public String findIdUserInfo(UserBean findIdUserBean)throws Exception {
		return userDao.findIdUserInfo(findIdUserBean);
	}
	
	public String findPwUserInfo(UserBean findPwUserBean)throws Exception {
		return userDao.findPwUserInfo(findPwUserBean);
	}
	
	public void updatePw(UserBean updatePwUserBean)throws Exception {
		
		userDao.updatePw(updatePwUserBean);
	}
}











