/*
package com.study.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.entity.MemberEntity;

@Repository // 첫번째 인자 : 어떤 Entity인지, 두번째 인자 : pk 어떤 타입인지
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
{
	// 이메일로 회원 정보 조회( select * from member_table where member_email=?)
    Optional<MemberEntity> findByMemberId(String memberId);
}
*/
