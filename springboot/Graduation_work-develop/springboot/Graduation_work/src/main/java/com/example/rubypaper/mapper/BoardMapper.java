package com.example.rubypaper.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;

@Mapper
public interface BoardMapper {

	public void boardInsert(NoticeBoard noticeBoard);

	public NoticeBoard boardFindList(NoticeBoard noticeBoard);
}
