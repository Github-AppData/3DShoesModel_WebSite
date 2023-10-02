package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	public List<MemberDTO> findAll() throws Exception;
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception; 
	
	public int idChk(MemberDTO memberDTO) throws Exception;
	
	public void memberInsert(MemberDTO memberDTO);
}
