package com.spring.mvc.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.model.ReplyVO;
import com.spring.mvc.board.service.IBoardService;
import com.spring.mvc.board.service.IReplyService;
import com.spring.mvc.commons.PageCreator;
import com.spring.mvc.commons.PageVO;
import com.spring.mvc.commons.SearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	@Autowired
	private IReplyService replyService;
	
	
	// 게시글 목록 불러오기 요청(페이징처리 이전)
	/*@GetMapping("/list")
	public String list(Model model) {
		
		List<BoardVO> list = service.getArticleList();
		System.out.println("URL: /board/list GET -> result" + list.size());
		//list.forEach(vo -> System.out.println(vo));
		model.addAttribute("articles", list);
		
		return "board/list";
	}  */
	
	// 페이징처리 이후 게시글 목록 불러오기 요청
	/*@GetMapping("/list")
	public String list(PageVO paging, Model model) { // PageVO paging 일 때 PageVO 객체가 생성되는거다...
		
		List<BoardVO> list = service.getArticleListPaging(paging);
		System.out.println("URL: /board/list GET -> result" + list.size());
		System.out.println("페이지 번호 : " + paging.getPage() + "페이지, " + paging.getCountPerPage() + "개씩 출력");
		
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}  */
	
	
	// 검색처리 이후 게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(SearchVO search, Model model) { // PageVO paging 일 때 PageVO 객체가 생성되는거다...
		
		//String condition = search.getCondition();
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);  // 부모자식관계니까 그냥 이렇게해도 ok!
		
		List<BoardVO> list = service.getArticleList(search);
		pc.setArticleTotalCount(service.countArticles(search));
		
		/*List<BoardVO> list = service.getArticleListByTitle(search);
		System.out.println("URL: /board/list GET -> result" + list.size());
		System.out.println("페이지 번호 : " + search.getPage() + "페이지, " + search.getCountPerPage() + "개씩 출력");
				
		pc.setArticleTotalCount(service.countArticlesByTitle(search));  */
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		
		return "board/list";
	}  
	
	
	
	
	// 글쓰기 화면 띄우기 요청
	@GetMapping("/write")
	public String write(HttpSession session, RedirectAttributes ra) {
		
	  // 이젠 인터셉터가 이걸 처리하도록!!
//		if(session.getAttribute("login") == null) {
//			ra.addFlashAttribute("msg", "notLogin");
//			return "redirect:/";
//		}
		
		return "board/write";
	}
	
	
	
	
	// 글쓰기 처리 요청
	@PostMapping("/write")
	public String write(@RequestParam(value="hasht") String[] hasht, BoardVO article, RedirectAttributes ra) {
		
		System.out.println("parameter : " + article);  // t) 이런 파라미터 잘 들어오는지 확인하는습관 들이는게 좋다!
		System.out.println("이게 되려나 : " + Arrays.toString(hasht));
		service.insert(article);	
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";
	}
	
	
	
	
	// 게시물 상세보기 요청
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable Integer boardNo, SearchVO search, Model model) {
		// @PathVariable : 경로에서 파라미터variable을 읽어서 Integer boardNo 에 집어넣겠다 (이게 요즘 추세다!)
		// 원형은 @PathVariable("boardNo") Integer boardNo  인데 이름이 같으면 생략 가능하다
		
		System.out.println(boardNo + "번 게시물 조회 요청");
		model.addAttribute("article", service.getArticle(boardNo));
		model.addAttribute("p", search);  // 위에서 파라미터로 @ModelAttribute("p") PageVO paging 이렇게 받아도 된다!
		
		
		// 댓글관련 작업
		List<ReplyVO> replyList = replyService.getReplyList(boardNo);
		model.addAttribute("replyList", replyList);
		
		
		return "board/content";
	}
	
	
	
	
	// 게시물 삭제 요청
	@PostMapping("/delete")
	public String delete(Integer boardNo, PageVO paging, RedirectAttributes ra) {  // input String이지만 그냥 Integer boardNo로 받아도 된다!(커맨드?)
		
		System.out.println(boardNo + "번 게시물 삭제 요청");
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");
		
		ra.addAttribute("page", paging.getPage());   
		ra.addAttribute("countPerPage", paging.getCountPerPage());
		// ra.addAttribute : redirect url에 파라미터 연결해주는 기능!(자동으로 ~~list?page=해당값&countPerPage=해당값 이렇게 붙는다!!★)
		// 아래 return 주소 뒤에다가 줄줄이 붙여도 되지만 이 방법이 더 깔끔하다!
		// 계속 ra.으로 안해도 되고 그냥 .으로 이어서 코딩해도 된다!
		
		return "redirect:/board/list";
	}
	
	
	
	
	// 게시물 수정페이지 요청
	@GetMapping("/modify")
	public String modify(Integer boardNo, PageVO paging, Model model) {
		System.out.println(boardNo + "번 게시물 수정 요청 : GET");
		model.addAttribute("article", service.getArticle(boardNo));
		model.addAttribute("p", paging); // 역시 파라미터로 @ModelAttribute("p") PageVO paging 이렇게 한 번에 처리해도 된다
		return "board/modify";
	}
	
	// 게시물 수정 요청
	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes ra) { 
		// 원래는 boardNo를 hidden으로 줘야되는데 spring에선 같은url 이면 get에서 썼던걸 그대로 넘겨준다! 근데 확실하게 하려면 hidden 넣어주자
		System.out.println("번 게시물 수정 요청 : POST");
		service.update(article);
		ra.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/content/" + article.getBoardNo();
	}
	
	
	
	
	
	// 댓글 등록
	@PostMapping("/reply")
	public String reply(ReplyVO replyVO, RedirectAttributes ra) {
		
		replyService.register(replyVO);
		
		return "redirect:/board/content/" + replyVO.getBoardNo();
	}

	
	
	
	
	
	
	
	// ckeditor
	@ResponseBody
	@PostMapping("/fileupload")
    public void communityImageUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile) throws Exception{
		JsonObject jsonObject = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		
		if(file != null) {
			if(file.getSize() >0 &&  StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("image/")) {
				    try{
				    	 
			            String fileName = file.getOriginalFilename();
			            byte[] bytes = file.getBytes();
			           
			            //String uploadPath = req.getSession().getServletContext().getRealPath("/resources/images/noticeimg"); //저장경로
			            String uploadPath = req.getSession().getServletContext().getRealPath("/resources/images/noticeimg"); //저장경로
			            System.out.println("uploadPath:"+uploadPath);

			            File uploadFile = new File(uploadPath);
			            if(!uploadFile.exists()) {
			            	uploadFile.mkdir();
			            }
			            String fileName2 = UUID.randomUUID().toString();
			            uploadPath = uploadPath + "/" + fileName2 +fileName;
			            
			            out = new FileOutputStream(new File(uploadPath)); 
			            out.write(bytes);
			            
			            printWriter = resp.getWriter();
			            String fileUrl = req.getContextPath() + "/resources/images/noticeimg/" +fileName2 +fileName; //url경로
			            System.out.println("fileUrl :" + fileUrl);
			            JsonObject json = new JsonObject();
			            json.addProperty("uploaded", 1);
			            json.addProperty("fileName", fileName);
			            json.addProperty("url", fileUrl);
			            printWriter.print(json);
			            System.out.println(json);
			 
			        }catch(IOException e){
			            e.printStackTrace();
			        } finally {
			            if (out != null) {
		                    out.close();
		                }
		                if (printWriter != null) {
		                    printWriter.close();
		                }
			        }
				}

			
		}
		
	}
	}

}
