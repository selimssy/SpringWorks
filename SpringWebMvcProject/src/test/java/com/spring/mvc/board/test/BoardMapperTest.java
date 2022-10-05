package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IboardMapper;



@RunWith(SpringJUnit4ClassRunner.class)  // 이거 쓰려면 Spring Test 모듈 maven 주입해야
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {
	
	@Autowired
	private IboardMapper mapper;
	
	
	
	// 게시글 등록 테스트
	@Test
	public void insertTest() {
		BoardVO article = new BoardVO();
		article.setTitle("테스트 제목입니다");
		article.setWriter("홍길동");
		article.setContent("테스트 게시물 컨텐츠");
		mapper.insert(article);
		System.out.println("게시물 등록 성공!");
	}
	
	
}
