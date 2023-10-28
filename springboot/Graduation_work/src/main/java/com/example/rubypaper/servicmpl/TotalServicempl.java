package com.example.rubypaper.servicmpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Paging;
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
	public int shoesCount() throws Exception{
		return totalMapper.shoesCount();
	}
	
	@Override
	public int searchShoesCount(String shoes_Name) throws Exception{
		return totalMapper.searchShoesCount(shoes_Name);
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
	public List<Map<String, Object>> randSelectShoesId() throws Exception {
		return totalMapper.randSelectShoesId();
	}
	
	@Override
	public List<Map<String, Object>> searchsMain(String shoes_Name) throws Exception {
		return totalMapper.searchsMain(shoes_Name);
	}
	
	@Override
	public List<Map<String, Object>> searchAdminPageShoes(Paging paging) throws Exception {
		return totalMapper.searchAdminPageShoes(paging);
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
	public List<Map<String, Object>> adminPageSelectUserList() throws Exception {
		return totalMapper.adminPageSelectUserList();
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

}
