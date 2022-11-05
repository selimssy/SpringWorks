package com.spring.mvc.board.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadController {
    

    
	HttpServletRequest request;
	//String uploadPath = request.getSession().getServletContext().getRealPath("/resources/images/noticeimg"); //저장경로
 
    
    @GetMapping("/uploadForm")
    public String uploadForm() {
        //upload/uploadForm.jsp로 포워딩
    	return "fileuploadtest";
    }
    
    //업로드 흐름: 업로드 버튼 클릭 -> 임시디렉토리 업로드 -> 지정된 디렉토리 저장 ->파일정보가 file에 저장
    @PostMapping("/uploadForm")
    public ModelAndView uploadFomr(HttpServletRequest request, MultipartFile file, ModelAndView mav) throws Exception{
        
    	String uploadPath = request.getSession().getServletContext().getRealPath("/resources/images/noticeimg"); //저장경로
    	
        //파일 원본 이름 저장
        String originalName = file.getOriginalFilename();
                
        System.out.println("파일이름" + file.getOriginalFilename());
        System.out.println("파일크기" + file.getSize());
        System.out.println("컨텐트타입" + file.getContentType());
       
        
        
		//uploadFile 메서드를 사용해 랜덤의 uuid를 생성해 파일이름에 주입
        //originalName = uploadFile(savedName, file.getBytes());
        
        // uuid 생성 
        UUID uuid = UUID.randomUUID();     
        //savedName 변수에 uuid + 원래 이름 추가
        String savedName = uuid.toString() + "_" + originalName;      
        //uploadPath경로의 savedName 파일에 대한 file 객체 생성
        File target = new File(uploadPath, savedName);      
        //fileData의 내용을 target에 복사함
        FileCopyUtils.copy(file.getBytes(), target);
        originalName = savedName;
        
        
        //모델앤뷰의 뷰 경로지정
        mav.setViewName("uploadresult");
        //속성추가 
        mav.addObject("savedName", originalName);
        mav.addObject("uploadpath", "/resources/images/noticeimg/" + originalName);
        return mav;
    }
    
    /*
    //파일명 랜덤 생성 메서드
    private String uploadFile(String originalName, byte[] fileData) throws Exception{
    
        // uuid 생성 
        UUID uuid = UUID.randomUUID();
        
        //savedName 변수에 uuid + 원래 이름 추가
        String savedName = uuid.toString()+"_"+originalName;
        //uploadPath경로의 savedName 파일에 대한 file 객체 생성
        File target = new File(uploadPath, savedName);
        //fileData의 내용을 target에 복사함
        FileCopyUtils.copy(fileData, target);
 
        return savedName;
    }*/
 
}
 


