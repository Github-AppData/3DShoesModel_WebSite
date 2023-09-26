package com.study.dto;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.study.entity.MemberEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok dependency추가
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO { //회원 정보를 필드로 정의
    private Long id;
    private String memberId;
    private String memberPassword;
    //lombok 어노테이션으로 getter,setter,생성자,toString 메서드 생략 가능
    
    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());

        return memberDTO;
    }
}
//MemberDTO.class