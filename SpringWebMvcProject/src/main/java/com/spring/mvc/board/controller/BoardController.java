package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	
	
	// 게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		
		List<BoardVO> list = service.getArticleList();
		System.out.println("URL: /board/list GET -> result" + list.size());
		//list.forEach(vo -> System.out.println(vo));
		model.addAttribute("articles", list);
		
		return "board/list";
	}
	
	
}
