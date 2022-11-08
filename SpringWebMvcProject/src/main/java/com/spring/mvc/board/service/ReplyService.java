package com.spring.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.board.model.ReplyVO;
import com.spring.mvc.board.repository.IReplyMapper;
import com.spring.mvc.board.repository.IboardMapper;

@Service
public class ReplyService implements IReplyService {
	
	@Autowired
	private IReplyMapper mapper;
	
	@Autowired
	private IboardMapper boardMapper;
	
	
	// 댓글 등록
	@Transactional  //IboardMapper와 연동!!
	@Override
	public void register(ReplyVO replyVO) {
		mapper.register(replyVO);
		boardMapper.updateReplyCnt(replyVO.getBoardNo());
	}
	
	
	// 댓글목록
	@Override
	public List<ReplyVO> getReplyList(int boardNo) {
		return mapper.getReplyList(boardNo);
	}

}