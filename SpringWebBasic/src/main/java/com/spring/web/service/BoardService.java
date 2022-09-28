package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.BoardVO;
import com.spring.web.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {
	
	
	@Autowired
	private IBoardDAO dao;
	
	
	
	// 게시글 전체조회
	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles();
	}

	
	
	// 게시글 등록
	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);
	}
	
	
	// 게시글 삭제
	@Override
	public void deleteArticle(int boardNo) {
		int index = boardNo - 1;    // service에서 1을 빼서 DAO에게 넘겨준다
		dao.deleteArticle(index);   
	}
	
	
	// 게시글 내용 보기
	@Override
	public BoardVO getContent(int boardNo) {
		int index = boardNo - 1;
		return dao.getContent(index);
	}
	
	
	
	// 게시글 수정
	@Override
	public void modifyArticle(BoardVO article, int boardNo) {
		int index = boardNo - 1;
		dao.modifyArticle(article, index);
	}

}
