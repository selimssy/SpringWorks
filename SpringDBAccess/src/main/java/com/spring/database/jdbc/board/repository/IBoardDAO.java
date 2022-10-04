package com.spring.database.jdbc.board.repository;

import java.util.List;

import com.spring.database.jdbc.board.model.BoardVO;

public interface IBoardDAO {
	
	// 게시글 목록 가져오기
	List<BoardVO> getArticles();
	
	// 게시글 등록
	void insertArticle(BoardVO article);
	
	// 게시글 삭제
	void deleteArticle(int index);
	
	// 게시글 내용보기
	BoardVO getContent(int index);
	
	// 게시글 수정
	void modifyArticle(BoardVO article);
	
}
