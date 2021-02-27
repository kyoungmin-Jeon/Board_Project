package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.beans.ContentBean;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addContentInfo(ContentBean writeContentBean)throws Exception {
		sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
	}
	public String getBoardInfoName(int board_info_idx)throws Exception {
		return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds)throws Exception{
		return sqlSessionTemplate.selectList("board.getContentList", board_info_idx, rowBounds);
	}
	
	public ContentBean getContentInfo(int content_idx)throws Exception {
		return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean)throws Exception {
		sqlSessionTemplate.selectOne("board.modifyContentInfo", modifyContentBean);
	}
	
	public void deleteContentInfo(int content_idx)throws Exception {
		sqlSessionTemplate.delete("board.deleteContentInfo", content_idx);
	}
	
	public int getContentCnt(int content_board_idx)throws Exception {
		return sqlSessionTemplate.selectOne("board.getContentCnt", content_board_idx);
	}
}










