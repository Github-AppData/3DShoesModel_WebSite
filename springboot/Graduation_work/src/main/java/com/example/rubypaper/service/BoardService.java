package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.BoardMapper;


public interface BoardService {

	public void boardInsert(NoticeBoard noticeBoard) throws Exception;
	public void boardFindList(NoticeBoard noticeBoard) throws Exception;
	public int boardCount() throws Exception;
	public void boardIdxData(int idx) throws Exception;
	
	
}
