package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.board.beans.ContentBean;
import com.board.beans.PageBean;

@Service
public interface BoardService {
	
	public String saveUploadFile(MultipartFile upload_file)throws Exception; 

	public void addContentInfo(ContentBean writeContentBean)throws Exception; 
	
	public String getBoardInfoName(int board_info_idx)throws Exception; 
	
	public List<ContentBean> getContentList(int board_info_idx, int page)throws Exception;
		
	public ContentBean getContentInfo(int content_idx)throws Exception; 
	
	public void modifyContentInfo(ContentBean modifyContentBean)throws Exception; 
	
	public void deleteContentInfo(int content_idx)throws Exception; 

	public PageBean getContentCnt(int content_board_idx, int currentPage)throws Exception; 
		
}
