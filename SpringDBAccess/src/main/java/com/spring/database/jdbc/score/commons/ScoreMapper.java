package com.spring.database.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.database.jdbc.score.model.ScoreVO;

// Jdbc Template에서 ResultSet 사용을 편하게 하기위한 클래스
// 근데 한 번 쓰려고 이렇게 클래스 파일 만들지 말고 익명클래스를 만들어서 사용하자!

public class ScoreMapper implements RowMapper<ScoreVO>{  // T에는 VO종류 쓰면 된다

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ScoreVO score = new ScoreVO();
		
		score.setStuId(rs.getInt("stu_id"));
		score.setStuName(rs.getString("stu_name"));
		score.setKor(rs.getInt("kor"));
		score.setEng(rs.getInt("eng"));
		score.setMath(rs.getInt("math"));
		score.setTotal(rs.getInt("total"));
		score.setAverage(rs.getDouble("average"));
		
		return score;
	}   

}
