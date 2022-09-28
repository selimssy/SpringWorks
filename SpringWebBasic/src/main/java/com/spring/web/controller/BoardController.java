package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	
	// 게시글 전체 조회 요청
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("aList", service.getArticles());
		
		return "/board/list";   // void로 해도 되는데 아직 model.addAttribute가 익숙치 않아서 이렇게ㅠ
	}
	
	
	// 게시글 등록화면 요청
	@GetMapping("/write")
	public void write() {
		
	}
	
	// 게시글 등록처리 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	
	
	// 게시글 삭제처리 요청   // a태그로 통해(get)
	@GetMapping("/delete")
	public String delete(int boardNo) {
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	
	
	
	// 게시물 내용 보기 요청
	@GetMapping("/content")
	public void content(int boardNo, Model model) {
		model.addAttribute("article", service.getContent(boardNo));
		model.addAttribute("boardNo", boardNo); // 이거 안하고 위에서 @ModelAttribute("boardNo") int boardNo 로 끝내도 된다!
	}
	
	
	
	
	// 게시물 수정화면 요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		model.addAttribute("article", service.getContent(boardNo));
		model.addAttribute("boardNo", boardNo);  // 여기도 위에랑 동일!
	}
	
	// 게시물 수정처리 요청
	@PostMapping("/modify")
	public String modify(BoardVO article, int boardNo) {
		service.modifyArticle(article, boardNo);
		return "redirect:/board/list";
	}
		
	
	
	
	
	
}
