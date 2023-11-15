package com.example.rubypaper.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.service.BoardService;
import com.example.rubypaper.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/WriteActionServlet")
public class WriteActionServlet extends HttpServlet{
	
	@Autowired
	BoardService boardService;
	
	NoticeBoard noticeBoard = new NoticeBoard();
	
	String title, content;
	
	// 게시판 글쓰기 서블릿 입니다. (Insert) - 로그인 여부는 글쓰기 버튼을 누를 때 체크를 했다.
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// user_id 구하는 것.
		HttpSession session = request.getSession();
		String checkLogin = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		// 시간과 날짜 구하기.
		LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		System.out.println(formatedNow);
		
		// 다른 필드들 값 구하기. 
		title = request.getParameter("title");
		content = request.getParameter("content");
		
		noticeBoard.setContent(content);
		noticeBoard.setUser_id(checkLogin);
		noticeBoard.setTitle(title);
		noticeBoard.setWrite_date(formatedNow);
		
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("noticeBoard", noticeBoard); // set 부분
		
		try {
			boardService.boardInsert(noticeBoard);
			
			System.out.println("등록 되었습니다 !!!");
			response.sendRedirect(request.getContextPath() + "/noticdBoard");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
