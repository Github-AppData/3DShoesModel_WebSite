package com.example.rubypaper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TotalDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 게시판 목록 
	public List<Map<String, Object>> getBoardList() throws Exception {
		return sqlSession.selectList("com.example.rubypaper.mapper.BoardMapper.boardFindList");
	}
	
	
	public List<Map<String, Object>> randSelectShoesId() throws Exception {
		return sqlSession.selectList("com.example.rubypaper.mapper.ShoesMapper.randSelectShoesId");
	}
	
	
	public List<Map<String, Object>> getCartList() throws Exception {
		return sqlSession.selectList("com.example.rubypaper.mapper.CartMapper.cartFindList");
	}
	
	// 글 총 
	public int getBoardValue() throws Exception {
		return sqlSession.selectOne("com.example.rubypaper.mapper.BoardMapper.boardCount");
	}

	// 
	public String FindListIsDelete() throws Exception {
		return sqlSession.selectOne("com.example.rubypaper.mapper.BoardMapper.FindListIsDelete");
		
	}

	public List<Map<String, Object>> findIsLike() throws Exception{
		return sqlSession.selectList("com.example.rubypaper.mapper.ShoesMapper.findIsLike");
	}
	
	public List<Map<String, Object>> search() throws Exception{
		return sqlSession.selectList("com.example.rubypaper.mapper.SearchMapper.search");
	}


}
