package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Like_tb;
import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.Order_List;
import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.dto.Review;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.mapper.TotalMapper;
import com.example.rubypaper.mapper.UserMapper;


public interface TotalService {
	
	public int numberOfCart();
	public  List<Map<String, Object>> myPageNoticeBoardSelect (@Param("user_id") String user_id) throws Exception;
	public  List<Map<String, Object>> boardIdxData(int idx) throws Exception;
	public  List<Map<String, Object>> myPageUserDataSet(@Param("user_id") String user_ids) throws Exception;
	public int cartDeleteShoesId() throws Exception;
	public int adminPageUpdateShoesInfo(Shoes shoes) throws Exception;
	public List<Map<String, Object>> boardCheckIdFindList(@Param("user_id") String user_id) throws Exception;
	public List<Map<String, Object>> boardFindList(Paging paging) throws Exception;
	public List<Map<String, Object>> searchBoards(Paging paging) throws Exception;
	public int boardCount() throws Exception;
	public int shoesCount(Paging paging) throws Exception;
	public int userCount() throws Exception;
	public int searchBoardCount(String boards_Name) throws Exception;
	public int searchUserCount(String name) throws Exception;
	public int searchShoesCount(Paging paging) throws Exception;
	public List<Map<String, Object>> cartFindList() throws Exception;
	public List<Map<String, Object>> findIsLike() throws Exception;
	public List<Map<String, Object>> randSelectShoesId(Paging paging) throws Exception;
	public List<Map<String, Object>> searchsMain(Paging paging) throws Exception;
	public List<Map<String, Object>> searchAdminPageShoes(Paging paging) throws Exception;
	public List<Map<String, Object>> searchAdminPageUser(Paging paging) throws Exception;
	public void FindListIsDelete() throws Exception;
	public int getBoardValue() throws Exception;
	public int noticeBoardIdxResort() throws Exception;
	public List<Map<String, Object>> adminPageSelectUserList(Paging paging) throws Exception;
	public int cartUpdateIsDelete(@Param("shoes_id") String shoes_id) throws Exception;
	public String cartFindShoesId(String shoes_id) throws Exception;
	public List<Map<String, Object>> adminPageSelectShoesList(Paging paging) throws Exception;
	public void adminPageDeleteShoesInfo(@Param("shoes_name") String shoes_name) throws Exception;
	public void adminPageShoesInsert(Shoes shoes) throws Exception;
	public List<Map<String, Object>> adminPageSelectAdminAccount() throws Exception;
	public Shoes shoesIdCheckLike (@Param("shoes_id") String shoes_id) throws Exception;
	public int isLikeUpdate(@Param("shoes_id") String shoes_id) throws Exception;
	public void isLikeInfoInsert(Like_tb like_tb) throws Exception;
	public int isDisableLikeUpdate(@Param("shoes_id") String shoes_id) throws Exception;
	public List<Map<String, Object>> isLikeSelect(Paging paging) throws Exception;
	public int isLikeCount() throws Exception;
	public List<Map<String, Object>> linkIdSelectLike() throws Exception;	
	public int likeDeleteShoesId(@Param("shoes_id") String shoes_id) throws Exception;
	public List<Map<String, Object>> selectMain() throws Exception;
	public void reviewInfoInsert(Review review) throws Exception;
	
	public void shoesRatingStarsUpdate(Shoes shoes) throws Exception;
	public int reviewRatingAvgSelect(@Param("shoes_id") String shoes_id) throws Exception;
	
	
	public List<Map<String, Object>> myPageOrderListSelect(@Param("user_id") String user_id) throws Exception;
	public void requestPay2InfoInsert(Order_List order_List) throws Exception;
	
	public List<Map<String, Object>> myPageToSDetailsSetSelect(@Param("order_id") int order_id) throws Exception;
}
