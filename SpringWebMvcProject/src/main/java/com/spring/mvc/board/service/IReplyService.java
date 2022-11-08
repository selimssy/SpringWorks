package com.spring.mvc.board.service;

import java.util.List;

import com.spring.mvc.board.model.ReplyVO;

public interface IReplyService {
	
	// 댓글 추가
	void register(ReplyVO replyVO);  
	
	// 댓글 목록 조회
	List<ReplyVO> getReplyList(int boardNo);
	
}