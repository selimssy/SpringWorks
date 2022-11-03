package com.spring.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IboardMapper;
import com.spring.mvc.commons.SearchVO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IboardMapper mapper;

	
	
	@Override
	public void insert(BoardVO article) {
		
		// 썸네일 경로 넣는 작업
		String content = article.getContent();
		String imgReg = "(<img[^>]*src\s*=\s*[\"']?([^>\"\']+)[\"']?[^>]*>)";
		Pattern pattern = Pattern.compile(imgReg);
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()) {
			article.setThumbImg(matcher.group(2));
		}
		
		mapper.insert(article);
	}

	@Override
	public BoardVO getArticle(Integer boardNo) {
		mapper.updateViewCnt(boardNo); // 여기서 조회수 증가
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
		mapper.update(article);
	}

	@Override
	public void delete(Integer boardNo) {
		mapper.delete(boardNo);
	}


	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
		List<BoardVO> list = mapper.getArticleList(search);
		
		// 1일 이내 신규 글 new마크 처리 로직
		for(BoardVO article : list) {
			// 현재시간 읽어오기
			long now = System.currentTimeMillis();
			// 각 게시물들의 작성 시간을 밀리초로 읽어오기(by getTime() 메서드)
			long regTime = article.getRegDate().getTime();
			
			if(now - regTime < 60 * 60 * 24 * 1000) {
				article.setNewMark(true);
			}
		}
				
		return list;
	}


	@Override
	public Integer countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}

}
