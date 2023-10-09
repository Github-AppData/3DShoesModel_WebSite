package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dao.TotalDAO;

@Service
public class ServiceList {
	
	@Autowired
	TotalDAO totalDAO;
	
	//사용자 목록 가져오기 
	public List<Map<String, Object>> getBoardList() {
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		
		try {
			boardList = totalDAO.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			return boardList;
		}
		
		//신발 가져오기 
	public List<Map<String, Object>> findIsLike() {
		List<Map<String, Object>> findIsLikeList = new ArrayList<Map<String, Object>>();

		try {
			findIsLikeList = totalDAO.findIsLike();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return findIsLikeList;
	}
		
	
	//신발 가져오기 
	public List<Map<String, Object>> randSelectShoesId() {
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();

		try {
				shoesList = totalDAO.randSelectShoesId();
			} catch (Exception e) {
				e.printStackTrace();
			}
				return shoesList;
	}
		
	// is_delete = 1 삭제 하는 쿼리 
	public String FindListIsDelete() throws Exception {
		return totalDAO.FindListIsDelete();
	}
		
	//사용자 총 수 
	public int getBoardValue() throws Exception {
		return totalDAO.getBoardValue();
	}
}
