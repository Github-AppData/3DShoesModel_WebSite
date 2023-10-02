/*
package com.study.entity;

import com.study.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table") //database에 해당 이름의 테이블 생성
public class MemberEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String memberId;

    @Column
    private String memberPassword;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        return memberEntity;
    }

}
*/
