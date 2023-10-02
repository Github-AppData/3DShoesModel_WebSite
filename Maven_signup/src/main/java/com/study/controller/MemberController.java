package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.crypt.SHA256;
import com.study.dto.MemberDTO;
import com.study.mapper.MemberMapper;
import com.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //MemberService에 대한 멤버를 사용 가능
public class MemberController {

    // 생성자 주입
    //private final MemberService memberService;
    
	@Autowired
	MemberService memberService;
	
	
	@Autowired
	SqlSession sqlSession;
	
    //private final BCryptPasswordEncoder encoder;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")    // name값을 requestparam에 담아온다
    public String save(HttpServletRequest request, Model model, @Valid MemberDTO memberDTO, Errors errors) throws Exception {
        /* post요청시 넘어온 user 입력값에서 Validation에 걸리는 경우 */
    	/* post요청시 넘어온 user 입력값에서 Validation에 걸리는 경우 */
        if (errors.hasErrors()) {
            /* 회원가입 실패시 입력 데이터 유지 */
            model.addAttribute("memberDTO", memberDTO);
            /* 회원가입 실패시 message 값들을 모델에 매핑해서 View로 전달 */
            Map<String, String> validateResult = memberService.validateHandler(errors);
            // map.keySet() -> 모든 key값을 갖고온다.
            // 그 갖고온 키로 반복문을 통해 키와 에러 메세지로 매핑
            for (String key : validateResult.keySet()) {
                // ex) model.addAtrribute("valid_id", "아이디는 필수 입력사항 입니다.")
                model.addAttribute(key, validateResult.get(key));
            }
            return "save";
        }
        
        if(memberService.idChk(memberDTO) > 0)
        {
        	return "save";
        }
        memberDTO.setMemberId(request.getParameter("memberId"));
        memberDTO.setMemberPassword(request.getParameter("memberPassword"));
        
        memberService.memberInsert(memberDTO);

        return "index";
    }
    
    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }
    

    @PostMapping("/member/login") // session : 로그인 유지
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) throws Exception {
    	String pwd = new SHA256().encrypt(memberDTO.getMemberPassword());
    	memberDTO.setMemberPassword(pwd);
    	MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginId", loginResult.getMemberId());
            System.out.println(loginResult.getMemberId());
        	System.out.println(loginResult.getMemberPassword());
            return "main";
        } else {
            // login 실패
        	System.out.println("로그인 실패");
        	System.out.println(memberDTO.getMemberPassword());
            return "login";
        }
    }

    
    @GetMapping("/member/")
    public String findAll(Model model) throws Exception{
        //List<MemberDTO> memberDTOList = memberService.findAll();
    	//List<MemberDTO> memberDTOList = memberDAO.memberfindAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
    	List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "list";

    }
    
}