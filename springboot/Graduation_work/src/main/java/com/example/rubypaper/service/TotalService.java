package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.mapper.TotalMapper;
import com.example.rubypaper.mapper.UserMapper;

@Service
public class TotalService {
	
	private TotalMapper totalMapper;
	
	@Autowired
	public TotalService(TotalMapper totalMapper) {
		this.totalMapper = totalMapper;
	}
	
	public int numberOfCart() {
		int numberOfCart = 0;
		try {
			numberOfCart = totalMapper.numberOfCart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberOfCart;
	}
	
	
	
	public  List<Map<String, Object>> boardIdxData(int idx) {
		List<Map<String, Object>> boardIdxDataList = new ArrayList<Map<String, Object>>();
		try {
			boardIdxDataList = totalMapper.boardIdxData(idx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardIdxDataList;
	}
	public  List<Map<String, Object>> myPageUserDataSet(@Param("user_id") String user_ids) {
		List<Map<String, Object>> myPageUserDataSetList = new ArrayList<Map<String, Object>>();
		try {
			myPageUserDataSetList = totalMapper.myPageUserDataSet(user_ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myPageUserDataSetList;
	}
	
	
	
	
	public int cartDeleteShoesId() {
		int cartDeleteShoesId = 0;
		try {
			cartDeleteShoesId = totalMapper.cartDeleteShoesId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartDeleteShoesId;
	}
	
	
	//사용자 목록 가져오기 
		public List<Map<String, Object>> boardCheckIdFindList(@Param("user_id") String user_id) {
			List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
			
			try {
				boardList = totalMapper.boardCheckIdFindList(user_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				return boardList;
			}
	
	
	//사용자 목록 가져오기 
	public List<Map<String, Object>> boardFindList() {
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		
		try {
			boardList = totalMapper.boardFindList();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			return boardList;
		}
	
		// 카트 목록 가져오기 
		public List<Map<String, Object>> cartFindList() {
			List<Map<String, Object>> CartList = new ArrayList<Map<String, Object>>();
			
			try {
				CartList = totalMapper.cartFindList();
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				return CartList;
			}
		
		//신발 가져오기 
	public List<Map<String, Object>> findIsLike() {
		List<Map<String, Object>> findIsLikeList = new ArrayList<Map<String, Object>>();

		try {
			findIsLikeList = totalMapper.findIsLike();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return findIsLikeList;
	}
		
	
	//신발 가져오기 
	public List<Map<String, Object>> randSelectShoesId() {
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();

		try {
				shoesList = totalMapper.randSelectShoesId();
			} catch (Exception e) {
				e.printStackTrace();
			}
				return shoesList;
	}
		
	// is_delete = 1 삭제 하는 쿼리 
	public void FindListIsDelete() throws Exception {
		totalMapper.FindListIsDelete();
	}
		
	//사용자 총 수 
	public int getBoardValue() throws Exception {
		return totalMapper.getBoardValue();
	}
}
