package com.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.study.crypt.SHA256;
import com.study.dto.MemberDTO;
import com.study.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service("com.study.service.MemberService")
//스프링이 관리해주는 객체 == 스프링 빈
//@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할 
public class MemberService {

	private final MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public void memberInsert(MemberDTO memberDTO) throws Exception{
		String pwd = new SHA256().encrypt(memberDTO.getMemberPassword());
		memberDTO.setMemberPassword(pwd);
		memberMapper.memberInsert(memberDTO);
	}
	
	public List<MemberDTO> findAll() throws Exception {
		//List<MemberDTO> memberList = memberMapper.findAll();
        return memberMapper.findAll();
    }
	
	public int idChk(MemberDTO memberDTO) throws Exception{
		return memberMapper.idChk(memberDTO);
	}

    public MemberDTO login(MemberDTO memberDTO) throws Exception {
//    	Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());
    	MemberDTO member = memberMapper.login(memberDTO);
        if(member != null){
        	if(member.getMemberPassword().equals(memberDTO.getMemberPassword()))
        	{
        		//member.setMemberId(memberDTO.getMemberId());
            	//member.setMemberPassword(memberDTO.getMemberPassword());
                return member;
        	}
        	else
        	{
        		return null;
        	}
        } else {
            // 조회 결과가 없다
            return null;
        }
    }
    
    public Map<String, String> validateHandler(Errors errors) {
        Map<String, String> validateResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = "valid_" + error.getField();
            validateResult.put(validKeyName, error.getDefaultMessage());
        }


        return validateResult;
    }
    
	
	/*
//   private final MemberRepository memberRepository; // 먼저 jpa, mysql dependency 추가
    private final BCryptPasswordEncoder encoder;
    
    public void save(MemberDTO memberDTO) {
        // Repository save 메서드 호출
//        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
//        memberRepository.save(memberEntity);
        //Repository save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }
    
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        //Controller로 dto로 변환해서 줘야 함
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }
    
    */

    
}
