package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.beans.BoardReplyBean;
import com.board.dao.ReplyDaoImpl;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDaoImpl replyDao; 
	
	public List<BoardReplyBean> readReply(int content_idx)throws Exception{
		return replyDao.readReply(content_idx);
	}	
	
	public void writeReply(BoardReplyBean boardReplyBean)throws Exception {
		replyDao.writeReply(boardReplyBean);
	}
	
	public void deleteReply(int rno) throws Exception {
		replyDao.deleteReply(rno);
	}
}
