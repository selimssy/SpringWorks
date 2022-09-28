package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	
	// 게시글을 저장할 리스트 : DB 대용
	List<BoardVO> articles = new ArrayList<>();
	
	
	
	// 게시글 전체조회
	@Override
	public List<BoardVO> getArticles() {
		return articles;
	}

	
	
	// 게시글 등록
	@Override
	public void insertArticle(BoardVO article) {
		articles.add(article);
	}
	
	
	// 게시글 삭제
	@Override
	public void deleteArticle(int index) {
		articles.remove(index);
	}

	
	
	// 게시물 내용 보기
	@Override
	public BoardVO getContent(int index) {
		return articles.get(index);
	}
	
	
	
	
	// 게시물 수정
	@Override
	public void modifyArticle(BoardVO article, int index) {
		articles.set(index, article);
	}

}
