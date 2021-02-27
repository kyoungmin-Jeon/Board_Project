package com.board.dao;

import org.springframework.stereotype.Repository;

import com.board.beans.UserBean;

@Repository
public interface UserDao {

	public String checkUserIdExist(String user_id) throws Exception;
	
	public void addUserInfo(UserBean joinUserBean) throws Exception;
	
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) throws Exception;
	
	public UserBean getModifyUserInfo(int user_idx) throws Exception;
	
	public void modifyUserInfo(UserBean modifyUserBean) throws Exception;
	
	public UserBean getDeleteUserInfo(int user_idx) throws Exception;
	
	public void deleteUserInfo(int user_idx) throws Exception;
	
	public String findIdUserInfo(UserBean findIdUserBean) throws Exception;

	public String findPwUserInfo(UserBean findPwUserBean) throws Exception;
	
	public void updatePw(UserBean updatePwUserBean) throws Exception;
}
