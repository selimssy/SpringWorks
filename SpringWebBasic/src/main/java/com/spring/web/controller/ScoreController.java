package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.ScoreVO;
import com.spring.web.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {


	@Autowired
	private IScoreService service;

	
	// 점수 등록 화면을 열어주는 요청 메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register 요청 들어옴: GET");
		return "score/write-form";
	}

	

	// 점수 등록 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
		System.out.println("/score/register 요청 들어옴 : POST");
		System.out.println("Controller param : " + scores);
		service.insertScore(scores);
		return "score/write-result";
	}

	

	

	// 전체 학생 점수조회 요청 메서드
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list 요청 들어옴 : GET");
		//List<ScoreVO> list = service.selectAll();
		//model.addAttribute("sList", list);
		model.addAttribute("sList", service.selectAll());
	}

	
	

	// 특정 학생점수 삭제 요청 메서드
	@GetMapping("/delete")
	public String delete(@RequestParam("stuNum") int stuNum, RedirectAttributes ra) {  // t)그냥 int stuNum으로 해도 된다....
		System.out.println("삭제할 학생 번호 : " + stuNum + "번");
		service.deleteScore(stuNum);
		ra.addFlashAttribute("message", "delSuccess");
		return "redirect:/score/list";
	}
	
	
	
	
	
	// 점수 개별조회화면 요청 메서드
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search 요청 들어옴 : GET" );
	}
	
	
	// 특정학생 데이터 요청, 출력 메서드
	@GetMapping("/selectOne") 
	public String selectOne(String stuNum, Model model,
							RedirectAttributes ra) {
		System.out.println("/score/selectOne: GET");
		
		List<ScoreVO> list = service.selectAll();
		
		try {
			int n = Integer.parseInt(stuNum);
			
			if(n > list.size()) {
				ra.addFlashAttribute("msg", "학번정보가 없습니다.");
				return "redirect:/score/search";
			} else {
				model.addAttribute("stu", service.selectOne(n));
				return "score/selectOne";
			}
		} catch(NumberFormatException e) {
			ra.addFlashAttribute("msg", "숫자로만 입력하세요!");
			return "redirect:/score/search";
		}
		
	}
	
	
	
	
}