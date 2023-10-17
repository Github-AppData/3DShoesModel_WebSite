package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.BoardMapper;

@Service
public class BoardService {

	private final BoardMapper boardMapper;
	
	@Autowired
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public void boardInsert(NoticeBoard noticeBoard) throws Exception {
	    boardMapper.boardInsert(noticeBoard);
	}
	
	public void boardFindList(NoticeBoard noticeBoard) throws Exception{
		boardMapper.boardFindList(noticeBoard);
	}
	
	public int boardCount() throws Exception{
		return boardMapper.boardCount();
	}
	
	public void boardIdxData(int idx) throws Exception {
		boardMapper.boardIdxData(idx);
	}
	
	
	
}
