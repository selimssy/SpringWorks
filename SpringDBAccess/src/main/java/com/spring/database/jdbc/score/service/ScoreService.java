package com.spring.database.jdbc.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.jdbc.score.model.ScoreVO;
import com.spring.database.jdbc.score.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreDAO dao;

	
	
	@Override
	public void insertScore(ScoreVO scores) {
		scores.calcData();
		dao.insertScore(scores);
	}

 

	@Override
	public List<ScoreVO> selectAll() {
		return dao.selectAll();
	}

 

	@Override
	public void deleteScore(int stuId) {
		dao.deleteScore(stuId);  
	}

	
	
	public ScoreVO selectOne(int stuNum) {
		return dao.selectOne(stuNum - 1);
	}

}