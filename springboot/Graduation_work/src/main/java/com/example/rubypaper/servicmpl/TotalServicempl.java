package com.example.rubypaper.servicmpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Like_tb;
import com.example.rubypaper.dto.Order_List;
import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.dto.Review;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.mapper.TotalMapper;
import com.example.rubypaper.service.TotalService;

@Service
public class TotalServicempl implements TotalService{
	
	@Autowired
	private TotalMapper totalMapper;

	@Override
	public int numberOfCart() {
		return totalMapper.numberOfCart();
	}

	@Override
	public List<Map<String, Object>> boardIdxData(int idx) throws Exception {
		return totalMapper.boardIdxData(idx);
	}

	@Override
	public List<Map<String, Object>> myPageUserDataSet(String user_id) throws Exception {
		return totalMapper.myPageUserDataSet(user_id);
	}

	@Override
	public int cartDeleteShoesId() throws Exception {
		return totalMapper.cartDeleteShoesId();
	}

	@Override
	public List<Map<String, Object>> boardCheckIdFindList(String user_id) throws Exception {
		return totalMapper.boardCheckIdFindList(user_id);
	}

	@Override
	public List<Map<String, Object>> boardFindList(Paging paging) throws Exception {
		return totalMapper.boardFindList(paging);
	}
	
	@Override
	public int  boardCount() throws Exception{
		return totalMapper.boardCount();
	}
	
	@Override
	public int searchBoardCount(String boards_Name) throws Exception{
		return totalMapper.searchBoardCount(boards_Name);
	}
	
	@Override
	public int shoesCount(Paging paging) throws Exception{
		return totalMapper.shoesCount(paging);
	}
	
	@Override
	public int searchShoesCount(Paging paging) throws Exception{
		return totalMapper.searchShoesCount(paging);
	}
	
	@Override
	public int userCount() throws Exception{
		return totalMapper.userCount();
	}
	
	@Override
	public int searchUserCount(String name) throws Exception{
		return totalMapper.searchUserCount(name);
	}

	@Override
	public List<Map<String, Object>> cartFindList() throws Exception {
		return totalMapper.cartFindList();
	}

	@Override
	public List<Map<String, Object>> findIsLike() throws Exception {
		return totalMapper.findIsLike();
	}

	@Override
	public List<Map<String, Object>> randSelectShoesId(Paging paging) throws Exception {
		return totalMapper.randSelectShoesId(paging);
	}
	
	@Override
	public List<Map<String, Object>> searchsMain(Paging paging) throws Exception {
		return totalMapper.searchsMain(paging);
	}
	
	@Override
	public List<Map<String, Object>> searchAdminPageShoes(Paging paging) throws Exception {
		return totalMapper.searchAdminPageShoes(paging);
	}
	
	@Override
	public List<Map<String,Object>> searchAdminPageUser(Paging paging) throws Exception{
		return totalMapper.searchAdminPageUser(paging);
	}
	
	@Override
	public List<Map<String, Object>> searchBoards(Paging paging) throws Exception {
		return totalMapper.searchBoards(paging);
	}

	@Override
	public void FindListIsDelete() throws Exception {
		totalMapper.FindListIsDelete();
	}

	@Override
	public int getBoardValue() throws Exception {
		return totalMapper.getBoardValue();
	}

	@Override
	public int cartUpdateIsDelete(String shoes_id) throws Exception{
		return totalMapper.cartUpdateIsDelete(shoes_id);
	}

	@Override
	public String cartFindShoesId(String shoes_id) throws Exception {
		return totalMapper.cartFindShoesId(shoes_id);
	}


	@Override
	public int noticeBoardIdxResort() throws Exception {
		return totalMapper.noticeBoardIdxResort();
	}

	@Override
	public List<Map<String, Object>> adminPageSelectUserList(Paging paging) throws Exception {
		return totalMapper.adminPageSelectUserList(paging);
	}

	@Override
	public List<Map<String, Object>> adminPageSelectShoesList(Paging paging) throws Exception {
		return totalMapper.adminPageSelectShoesList(paging);
	}

	@Override
	public int adminPageUpdateShoesInfo(Shoes shoes) throws Exception {
		return totalMapper.adminPageUpdateShoesInfo(shoes);
	}

	@Override
	public void adminPageDeleteShoesInfo(String shoes_name) throws Exception {
		totalMapper.adminPageDeleteShoesInfo(shoes_name);
	}

	@Override
	public void adminPageShoesInsert(Shoes shoes) throws Exception {
		totalMapper.adminPageShoesInsert(shoes);
	}

	@Override
	public List<Map<String, Object>> adminPageSelectAdminAccount() throws Exception {
		return totalMapper.adminPageSelectAdminAccount();
	}

	@Override
	public void isLikeInfoInsert(Like_tb like_tb) throws Exception {
		totalMapper.isLikeInfoInsert(like_tb);
	}

	@Override
	public Shoes shoesIdCheckLike(String shoes_id) throws Exception {
		return totalMapper.shoesIdCheckLike(shoes_id);
		
	}

	@Override
	public int isLikeUpdate(String shoes_id) throws Exception {
		return totalMapper.isLikeUpdate(shoes_id);
		
	}

	@Override
	public List<Map<String, Object>> linkIdSelectLike() throws Exception {
		return totalMapper.linkIdSelectLike();
		
	}

	@Override
	public List<Map<String, Object>> isLikeSelect(Paging paging) throws Exception {
		return totalMapper.isLikeSelect(paging);
	}
	
	@Override
	public int isLikeCount() throws Exception{
		return totalMapper.isLikeCount();
	}

	@Override
	public int likeDeleteShoesId(String shoes_id) throws Exception {
		return totalMapper.likeDeleteShoesId(shoes_id);
	}

	@Override
	public int isDisableLikeUpdate(String shoes_id) throws Exception {
		return totalMapper.isDisableLikeUpdate(shoes_id);
	}

	@Override
	public void reviewInfoInsert(Review review) throws Exception {
		totalMapper.reviewInfoInsert(review);
	}

	@Override
	public int reviewRatingAvgSelect(String shoes_id) throws Exception {
		return totalMapper.reviewRatingAvgSelect(shoes_id);
	}

	@Override
	public void shoesRatingStarsUpdate(Shoes shoes) throws Exception {
		totalMapper.shoesRatingStarsUpdate(shoes);
	}

	@Override
	public List<Map<String, Object>> selectMain() throws Exception {
		return totalMapper.selectMain();
	}

	@Override
	public List<Map<String, Object>> myPageNoticeBoardSelect(String user_id) throws Exception {
		return totalMapper.myPageNoticeBoardSelect(user_id);
	}

	@Override
	public void requestPay2InfoInsert(Order_List order_List) throws Exception {
		totalMapper.requestPay2InfoInsert(order_List);
	}

	@Override
	public List<Map<String, Object>> myPageOrderListSelect(String user_id) throws Exception {
		return totalMapper.myPageOrderListSelect(user_id);
	}

	@Override
	public List<Map<String, Object>> myPageToSDetailsSetSelect(int order_id) throws Exception {
		return totalMapper.myPageToSDetailsSetSelect(order_id);
	}	

}
