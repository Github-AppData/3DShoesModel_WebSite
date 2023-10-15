package com.example.rubypaper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TotalDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int cartUpdateIsDelete(String shoes_id) throws Exception {
	    int s = sqlSession.update("com.example.rubypaper.mapper.CartMapper.cartUpdateIsDelete", shoes_id);
	    sqlSession.commit();
	    return s;
	}
	
	public int cartDeleteShoesId(String shoes_id) throws Exception {
	    return sqlSession.delete("com.example.rubypaper.mapper.CartMapper.cartDeleteShoesId");
	}
	
	
	// 게시판 목록 
	public List<Map<String, Object>> getBoardList() throws Exception {
		return sqlSession.selectList("com.example.rubypaper.mapper.BoardMapper.boardFindList");
	}
	
	public List<Map<String, Object>> getboardCheckIdFindList(String user_id) throws Exception {
		return sqlSession.selectList("com.example.rubypaper.mapper.BoardMapper.boardCheckIdFindList", user_id);
	}
	
	
	public int numberOfCart() throws Exception{
		return sqlSession.selectOne("com.example.rubypaper.mapper.CartMapper.numberOfCart"); 
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


}
