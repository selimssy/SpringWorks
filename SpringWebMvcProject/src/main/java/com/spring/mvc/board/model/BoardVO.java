package com.spring.mvc.board.model;

import java.util.Date;

public class BoardVO {
	
	private Integer boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Integer viewCnt;
	
	// 썸네일 이미지 경로
	private String thumbImg;
	
	// 해시태그 배열
	private String[] hashtag;

	

	// 신규 게시물에 new마크 붙일지 말지 결정하는 논리필드 선언
	private boolean newMark;
	
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	public boolean isNewMark() {
		return newMark;
	}
	
	
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	public String getThumbImg() {
		return thumbImg;
	}

	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	
	public String[] getHashtag() {
		return hashtag;
	}

	public void setHashtag(String[] hashtag) {
		this.hashtag = hashtag;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", thumbImg=" + thumbImg + ", newMark=" + newMark
				+ "]";
	}


	
	
	
	
	
}
