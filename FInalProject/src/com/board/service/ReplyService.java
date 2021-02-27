package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.beans.BoardReplyBean;

@Service
public interface ReplyService {
	
	public List<BoardReplyBean> readReply(int content_idx) throws Exception;
	
	public void writeReply(BoardReplyBean boardReplyBean) throws Exception;
	
	public void deleteReply(int rno) throws Exception;
}
