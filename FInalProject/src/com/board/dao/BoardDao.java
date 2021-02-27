package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.board.beans.ContentBean;

@Repository
public interface BoardDao {

	public void addContentInfo(ContentBean writeContentBean)throws Exception;
	
	public String getBoardInfoName(int board_info_idx)throws Exception; 
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds)throws Exception;
	
	public ContentBean getContentInfo(int content_idx)throws Exception;

	public void modifyContentInfo(ContentBean modifyContentBean)throws Exception;
	
	public void deleteContentInfo(int content_idx)throws Exception;
	
	public int getContentCnt(int content_board_idx)throws Exception; 
}
