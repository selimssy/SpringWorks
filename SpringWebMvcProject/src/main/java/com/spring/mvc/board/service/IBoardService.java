package com.spring.mvc.board.service;

import java.util.List;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.commons.PageVO;
import com.spring.mvc.commons.SearchVO;

public interface IBoardService {

	// 게시글 등록 기능
	void insert(BoardVO article);
	
	// 게시글 상세 조회기능
	BoardVO getArticle(Integer boardNo);

	// 게시글 수정 기능
	void update(BoardVO article);

	// 게시글 삭제 기능
	void delete(Integer boardNo);
	
	// # 검색, 페이징 기능이 포함된 게시물 목록 조회기능
	List<BoardVO> getArticleList(SearchVO search);
	
	// # 검색, 페이징 기능이 포함된 게시물 수 조회기능
	Integer countArticles(SearchVO search);
	
	
	
	/*

	// 게시글 목록 조회기능(페이징처리 이전)
	List<BoardVO> getArticleList();
	// 페이징처리 이후 게시글 목록조회 기능
	List<BoardVO> getArticleListPaging(PageVO paging);
	
	// 제목으로 검색기능
	List<BoardVO> getArticleListByTitle(SearchVO search);
	
	// 총 게시물의 수 조회기능
	Integer countArticles();
	
	// 제목으로 검색 이후 게시물 수 조회기능
	Integer countArticlesByTitle(SearchVO search);

	*/
		
	
}
