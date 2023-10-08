package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dao.BoardDAO;

@Service
public class BoardServiceList {
	
	// DB에 있는 데이터를 화면에 띄우기 위한 클래스 입니다.

	@Autowired
	BoardDAO boardDAO;
	
	//사용자 목록 가져오기 
		public List<Map<String, Object>> getBoardList() {
			List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
			
			try {
				boardList = boardDAO.getBoardList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return boardList;
		}
		
		//사용자 총 수 
		public int getBoardValue() throws Exception {
			return boardDAO.getBoardValue();
		}
}
