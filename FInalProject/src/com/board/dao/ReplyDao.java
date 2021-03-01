package com.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.beans.BoardReplyBean;

@Repository
public interface ReplyDao {
	
	public List<BoardReplyBean> readReply(int content_idx)throws Exception;
	
	public void writeReply(BoardReplyBean boardReplyBean)throws Exception;


}
