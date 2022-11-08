package com.spring.mvc.board.model;

import java.util.Date;

public class ReplyVO {
	
	private int replyNo;  // 댓글 번호
	private int boardNo;  // 게시글 번호
	
	private String content;   // 댓글 내용 
	private String replyer;   // 댓글 작성자
	private Date replyDate;   // 댓글 작성일
	private Date updateDate;  // 댓글 수정일
	
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", boardNo=" + boardNo + ", content=" + content + ", replyer=" + replyer
				+ ", replyDate=" + replyDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
}