package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.beans.BoardReplyBean;
import com.board.dao.ReplyDao;

@Service
public class ReplyService {

	@Autowired
	private ReplyDao replyDao; 
	
	public List<BoardReplyBean> readReply(int content_idx){
		return replyDao.readReply(content_idx);
	}	
	
	public void writeReply(BoardReplyBean boardReplyBean) {
		replyDao.writeReply(boardReplyBean);
	}
	
	public void deleteReply(int rno) {
		replyDao.deleteReply(rno);
	}
}
