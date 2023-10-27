package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.mapper.TotalMapper;
import com.example.rubypaper.mapper.UserMapper;


public interface TotalService {
	
	
	public int numberOfCart();
	
	public  List<Map<String, Object>> boardIdxData(int idx) throws Exception;
	public  List<Map<String, Object>> myPageUserDataSet(@Param("user_id") String user_ids) throws Exception;
	public int cartDeleteShoesId() throws Exception;
	public int adminPageUpdateShoesInfo(Shoes shoes) throws Exception;
	public List<Map<String, Object>> boardCheckIdFindList(@Param("user_id") String user_id) throws Exception;
	public List<Map<String, Object>> boardFindList(Paging paging) throws Exception;
	public List<Map<String, Object>> searchBoards(Paging paging) throws Exception;
	public int boardCount() throws Exception;
	public int shoesCount() throws Exception;
	public int searchBoardCount(String boards_Name) throws Exception;
	public int searchShoesCount(String shoes_Name) throws Exception;
	public List<Map<String, Object>> cartFindList() throws Exception;
	public List<Map<String, Object>> findIsLike() throws Exception;
	public List<Map<String, Object>> randSelectShoesId() throws Exception;
	public List<Map<String, Object>> searchAdminPageShoes(Paging paging) throws Exception;
	public void FindListIsDelete() throws Exception;
	public int getBoardValue() throws Exception;
	public int noticeBoardIdxResort() throws Exception;
	public List<Map<String, Object>> adminPageSelectUserList() throws Exception;
	public int cartUpdateIsDelete(String sa) throws Exception;
	public String cartFindShoesId(String shoes_id) throws Exception;
	public List<Map<String, Object>> adminPageSelectShoesList(Paging paging) throws Exception;
	public void adminPageDeleteShoesInfo(@Param("shoes_name") String shoes_name) throws Exception;
	public void adminPageShoesInsert(Shoes shoes) throws Exception;

}
