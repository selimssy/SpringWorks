package com.spring.database.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.repository.IBoardDAO;

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
		dao.deleteArticle(boardNo);   
	}
	
	
	// 게시글 내용 보기
	@Override
	public BoardVO getContent(int boardNo) {
		return dao.getContent(boardNo);
	}
	
	
	
	// 게시글 수정
	@Override
	public void modifyArticle(BoardVO article) {
		dao.modifyArticle(article);
	}
	
	
	
	
	// 게시글 검색
	@Override
	public List<BoardVO> getSearchList(String keyword) {
		keyword = "%" + keyword + "%";
		return dao.getSearchList(keyword);
	}

}
