package com.example.rubypaper.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.rubypaper.crypt.PasswordHashingUtil;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/InsertInfoServlet")
public class InsertInfoServlet extends HttpServlet {
	// 이 서블릿은 '회원가입'시 모든 로직을 담고 있다.
	
	@Autowired
	UserService userService;
	
	User resultId;
	User user = new User();
	String input_pw;
	String hashedPassword;
	Date birth_date;
	Object data;
	
	PasswordHashingUtil passwordHashingUtil = new PasswordHashingUtil();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); // 세션 객체 가져오기
		
		// 사용자로부터 입력 된 데이터를 받아옵니다.
		String id = request.getParameter("id");
		input_pw = request.getParameter("pw");
		String adress = request.getParameter("adress");
		String detail_adress = request.getParameter("detail_adress");
		String phone = request.getParameter("phone_number");
	    String email = request.getParameter("email");
	    
	    // 생일 관련 날짜 처리 
	    String birthday = request.getParameter("birthday");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    
	    
	    try {
	    	birth_date = dateFormat.parse(birthday);
		} catch (ParseException e) {
			// TODO: handle exception
		}

	    /*
	    	TODO : 회원가입시 조건을 달아 놓을 예정입니다
	    	
	    	조건 : 1. id 중복체크 (select문을 이용 해야 한다. - userService) = 구현완료.
    		   	   2. 비밀번호 조건 확인
	     */
	    
	    // 아이디 중복 체크 
	    try {
			resultId = userService.idCheckSelect2(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    // 아이디가 중복된게 없다면,,,
	    if(resultId == null)
	    {	
			// DTO 객체 생성 및 데이터 설정 User user = new User(); user.setId(id);
	    	 user.setId(id);
			 user.setEmail(email); 
			 user.setBirthday(birth_date);
			 user.setAdress(adress);
			 user.setDetail_adress(detail_adress);
			 user.setPhone(phone);
			 user.setIs_Status(1);
			 user.setPhone(phone);
			 
			 String salt = passwordHashingUtil.generateSalt(); // 솔트 생성
			 user.setSalt(salt);
			 
			
			 
			try {
				// 암호화 
				hashedPassword = passwordHashingUtil.hashPassword(input_pw, user.getSalt());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			// 해싱된 비밀번호와 솔트를 저장
		        user.setPw(hashedPassword);
		    
		     // 사용자 객체에 저장된 비밀번호 및 솔트 확인
		        System.out.println("Hashed Password: " + user.getPw());
		        System.out.println("Salt: " + user.getSalt());
			 
			 try {
				// 사용자 입력한 데이터를 DB에 Insert 한다.
				userService.userInsert(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			 request.setAttribute("user", user);
			 
			 // 서블릿 컨텍스트에 DTO 객체 저장 
			 System.out.println(user.toString()); 
			 System.out.println(user.getId());
			 
			 // 결과 화면으로 !!! 
			System.out.println("회원가입 되었습니다. 확인 해 보세요 !");
	    	response.sendRedirect(request.getContextPath() + "/sLogin");
	    	session.setAttribute("login", user.getId());
	    	
	    	 ServletContext servletContext = getServletContext();
			 servletContext.setAttribute("user", user); // set 부분
	    }
	    else {
	    	System.out.println("존재하는 아이디 입니다.");
	    	
	    	// 조건 실패시 제자리 
	    	response.sendRedirect(request.getContextPath() + "/SignUp");
	    }
	    

	}

	
}
