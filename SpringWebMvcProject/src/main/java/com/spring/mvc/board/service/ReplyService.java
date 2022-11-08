package com.spring.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.model.ReplyVO;
import com.spring.mvc.board.repository.IReplyMapper;

@Service
public class ReplyService implements IReplyService {
	
	@Autowired
	private IReplyMapper mapper;
	
	
	// 댓글 등록
	@Override
	public void register(ReplyVO replyVO) {
		mapper.register(replyVO);
	}
	
	
	// 댓글목록
	@Override
	public List<ReplyVO> getReplyList(int boardNo) {
		return mapper.getReplyList(boardNo);
	}

}