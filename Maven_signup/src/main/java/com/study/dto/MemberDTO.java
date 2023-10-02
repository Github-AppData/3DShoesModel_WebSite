package com.study.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/*
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok dependency추가
@Getter
@Setter
@NoArgsConstructor
@ToString
*/

public class MemberDTO { //회원 정보를 필드로 정의
	
    private Long id;
	
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String memberId;
	
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문, 숫자, 특수문자를 사용하세요.")
    private String memberPassword;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public String toString() {
		return "MemberDTO[memberId = "+ id +" , memberPassword = "+ memberPassword +"]";
	}
	
    //lombok 어노테이션으로 getter,setter,생성자,toString 메서드 생략 가능
    
    /*
    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());

        return memberDTO;
    }
    */
}
//MemberDTO.class