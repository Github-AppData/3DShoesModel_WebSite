package com.example.rubypaper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.dto.Like_tb;

@Mapper
public interface TotalMapper {

	public int getBoardValue();
	public List<Map<String, Object>> randSelectShoesId(Paging paging);
	public List<Map<String, Object>> searchsMain(Paging paging);
	public List<Map<String, Object>> findIsLike();
	public List<Map<String, Object>> boardCheckIdFindList(@Param("user_id") String user_id);
	public int cartDeleteShoesId() throws Exception;
	
	public int adminPageUpdateShoesInfo(Shoes shoes) throws Exception;
	
	public List<Map<String, Object>> myPageUserDataSet(@Param("user_id") String user_id);
	public List<Map<String, Object>> boardIdxData(@Param("idx") int idx);
	public int numberOfCart();
	public List<Map<String, Object>> boardFindList(Paging paging);
	public List<Map<String, Object>> searchBoards(Paging paging);
	public List<Map<String, Object>> searchAdminPageShoes(Paging paging);
	public int boardCount() throws Exception;
	public int searchBoardCount(String boards_Name) throws Exception;
	public int shoesCount() throws Exception;
	public int searchShoesCount(String shoes_Name) throws Exception;
	public List<Map<String, Object>> cartFindList();
	public void FindListIsDelete() throws Exception;
	public int cartUpdateIsDelete(@Param("shoes_id") String shoes_id) throws Exception;
	public String cartFindShoesId(@Param("shoes_id") String shoes_id) throws Exception;
	public int noticeBoardIdxResort() throws Exception;
	public List<Map<String, Object>> adminPageSelectUserList() throws Exception;
	public List<Map<String, Object>> adminPageSelectShoesList(Paging paging) throws Exception;
	public void adminPageDeleteShoesInfo(String shoes_name);
	public void adminPageShoesInsert(Shoes shoes) throws Exception;
	public List<Map<String, Object>> adminPageSelectAdminAccount() throws Exception;
	public void isLikeInfoInsert(Like_tb like_tb) throws Exception;
	public Shoes shoesIdCheckLike(@Param("shoes_id") String shoes_id) throws Exception;
}
