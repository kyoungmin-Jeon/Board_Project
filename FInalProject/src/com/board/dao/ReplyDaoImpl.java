package com.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.beans.BoardReplyBean;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardReplyBean> readReply(int content_idx)throws Exception{
		return sqlSessionTemplate.selectList("reply.readReply",content_idx);
	}
	
	public void writeReply(BoardReplyBean boardReplyBean)throws Exception {
		sqlSessionTemplate.insert("reply.writeReply",boardReplyBean);
	}
	

}
