package com.spring.database.jdbc.score.service;

import java.util.List;

import com.spring.database.jdbc.score.model.ScoreVO;

public interface IScoreService {
	
	// 점수 등록기능
	void insertScore(ScoreVO scores);


	// 모든 학생의 점수 조회 기능
	List<ScoreVO> selectAll();


	// 점수 삭제기능
	void deleteScore(int stuNum);
	
	
	// 점수 개별조회 기눙
	ScoreVO selectOne(int stuNum);
	
}
