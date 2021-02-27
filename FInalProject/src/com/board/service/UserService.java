package com.board.service;

import org.springframework.stereotype.Service;

import com.board.beans.UserBean;

@Service
public interface UserService {
	
	public boolean checkuserIdExist(String user_id) throws Exception;
		
	public void addUserInfo(UserBean joinUserBean) throws Exception;
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) throws Exception;
	
	public void getModifyUserInfo(UserBean modifyUserBean) throws Exception;

	public void modifyUserInfo(UserBean modifyUserBean) throws Exception;
		
	public void getDeleteUserInfo(UserBean deleteUserBean) throws Exception;
		
	public void deleteUserInfo(int user_idx) throws Exception;
		
	public String findIdUserInfo(UserBean findIdUserBean) throws Exception;
	
	public String findPwUserInfo(UserBean findPwUserBean) throws Exception;
	
	public void updatePw(UserBean updatePwUserBean) throws Exception;
}
