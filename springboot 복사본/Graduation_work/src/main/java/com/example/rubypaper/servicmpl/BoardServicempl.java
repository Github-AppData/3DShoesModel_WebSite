package com.example.rubypaper.servicmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.mapper.BoardMapper;
import com.example.rubypaper.service.BoardService;

@Service
public class BoardServicempl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void boardInsert(NoticeBoard noticeBoard) throws Exception {
		boardMapper.boardInsert(noticeBoard);
	}

	@Override
	public void boardFindList(NoticeBoard noticeBoard) throws Exception {
		boardMapper.boardFindList(noticeBoard);
	}

	@Override
	public int boardCount() throws Exception {
		return boardMapper.boardCount();
	}

	@Override
	public void boardIdxData(int idx) throws Exception {
		boardMapper.boardIdxData(idx);
	}

}
