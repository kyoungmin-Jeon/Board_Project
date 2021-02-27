package com.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.beans.UserBean;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id)throws Exception {
		return sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean)throws Exception {
		sqlSessionTemplate.insert("user.addUserInfo", joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean)throws Exception {
		return sqlSessionTemplate.selectOne("user.getLoginUserInfo", tempLoginUserBean);
	}
	
	public UserBean getModifyUserInfo(int user_idx)throws Exception {
		return sqlSessionTemplate.selectOne("user.getModifyUserInfo", user_idx);
	}
	
	public void modifyUserInfo(UserBean modifyUserBean)throws Exception {
		sqlSessionTemplate.update("user.modifyUserInfo", modifyUserBean);
	}
	
	public UserBean getDeleteUserInfo(int user_idx)throws Exception {
		return sqlSessionTemplate.selectOne("user.getDeleteUserInfo", user_idx);
	}
	
	public void deleteUserInfo(int user_idx)throws Exception {
		sqlSessionTemplate.delete("user.deleteUserInfo",user_idx);
	}
	
	public String findIdUserInfo(UserBean findIdUserBean)throws Exception {
		return sqlSessionTemplate.selectOne("user.findIdUserInfo",findIdUserBean);
	}

	public String findPwUserInfo(UserBean findPwUserBean)throws Exception {
		return sqlSessionTemplate.selectOne("user.findPwUserInfo",findPwUserBean);
	}
	
	public void updatePw(UserBean updatePwUserBean)throws Exception {
		
		sqlSessionTemplate.update("user.updatePw",updatePwUserBean);
	}
}






