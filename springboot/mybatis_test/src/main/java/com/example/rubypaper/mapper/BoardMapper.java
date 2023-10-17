package com.example.rubypaper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;

@Mapper
public interface BoardMapper {

	public void boardInsert(NoticeBoard noticeBoard);

	public NoticeBoard boardFindList(NoticeBoard noticeBoard);

	public int boardCount();

	public void boardIdxData(@Param("idx") int idx);

}
