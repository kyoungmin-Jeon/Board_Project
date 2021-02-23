package com.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.beans.BoardReplyBean;

@Repository
public class ReplyDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardReplyBean> readReply(int content_idx){
		return sqlSessionTemplate.selectList("reply.readReply",content_idx);
	}
	
	public void writeReply(BoardReplyBean boardReplyBean) {
		sqlSessionTemplate.insert("reply.writeReply",boardReplyBean);
	}
	
	public void deleteReply(int rno) {
		sqlSessionTemplate.delete("reply.deleteReply",rno);
	}
}
