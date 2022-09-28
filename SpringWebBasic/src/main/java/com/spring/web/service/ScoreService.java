package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.ScoreVO;
import com.spring.web.repository.IScoreDAO;

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
	public void deleteScore(int stuNum) {
		dao.deleteScore(stuNum - 1);  // 이런걸 service에서 해야!
	}

	
	
	public ScoreVO selectOne(int stuNum) {
		return dao.selectOne(stuNum - 1);
	}

}