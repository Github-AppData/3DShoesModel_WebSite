package com.study.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")	//localhost:8090/board/write
	public String boardWriteForm() {
		
		return "/boardwrite";
	}
	
	@PostMapping("/board/writepro")
	public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception{

		boardService.write(board, file);
		
		model.addAttribute("message", "글 작성이 완료되었습니다.");
		model.addAttribute("serchUrl", "/board/list");
		
		return "message";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC)
	Pageable pageable) {
		
		Page<Board> list = boardService.boardList(pageable);
		
		int nowPage = list.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 5, list.getTotalPages());
		
		model.addAttribute("list", boardService.boardList(pageable));
		//model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "/boardlist";
	}
	
	@GetMapping("/board/view")	//localhost:8090/board/view?id=1
	public String boardView(Model model, Integer id) { 
		
		model.addAttribute("board", boardService.boardView(id));
		
		return "/boardview";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		
		boardService.boardDelete(id);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("board", boardService.boardView(id));
		
		return "/boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer id, Board board, MultipartFile file) throws Exception{
		
		Board boardTemp = boardService.boardView(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		
		boardService.write(boardTemp, file);
		
		return "redirect:/board/list";
	}
	
}
