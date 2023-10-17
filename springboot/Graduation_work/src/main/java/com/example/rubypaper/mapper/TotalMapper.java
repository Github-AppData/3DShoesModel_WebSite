package com.example.rubypaper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TotalMapper {

	public int getBoardValue();
	public List<Map<String, Object>> randSelectShoesId();
	public List<Map<String, Object>> findIsLike();
	public List<Map<String, Object>> boardCheckIdFindList(@Param("user_id") String user_id);
	public int cartDeleteShoesId();
	public List<Map<String, Object>> myPageUserDataSet(@Param("user_id") String user_id);
	public List<Map<String, Object>> boardIdxData(@Param("idx") int idx);
	public int numberOfCart();
	
	public List<Map<String, Object>> cartFindList();
	
	public List<Map<String, Object>> boardFindList();
	public void FindListIsDelete() throws Exception;
	
	public int cartUpdateIsDelete(@Param("shoes_id") String shoes_id) throws Exception;
	public String cartFindShoesId(@Param("shoes_id") String shoes_id) throws Exception;
}
