package com.spring.database.jdbc.score.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.score.commons.ScoreMapper;
import com.spring.database.jdbc.score.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {
	
	
	
	// # 전통적 방식의 JDBC
	private String driver = "com.mysql.cj.jdbc.Driver";  // mysql 8버전부터는 중간에 cj 추가해야
	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";  // 8버전부터 ?serverTimezone=Asia/Seoul 추가해야
	private String uid="root";
	private String upw = "stm1020";
	

	/*
	@Override
	public void insertScore(ScoreVO scores) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO scores (stu_name, kor, eng, math, total, average) VALUES (?,?,?,?,?,?)";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scores.getStuName());
			pstmt.setInt(2, scores.getKor());
			pstmt.setInt(3, scores.getEng());
			pstmt.setInt(4, scores.getMath());
			pstmt.setInt(5, scores.getTotal());
			pstmt.setDouble(6, scores.getAverage());
			
			pstmt.executeUpdate();
			System.out.println("점수 등록 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close(); pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	*/
	
	
	// # Spring-JDBC 방식의 처리 : JDBCTemplate 사용!
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertScore(ScoreVO scores) {
		
		String sql = "INSERT INTO scores (stu_name, kor, eng, math, total, average) VALUES (?,?,?,?,?,?)";	
		template.update(sql, scores.getStuName(), scores.getKor(), scores.getEng(), scores.getMath(), scores.getTotal(), scores.getAverage());   
	}
 
	
	
	/*
	// # 전통적방식
	@Override
	public List<ScoreVO> selectAll() {
		
		List<ScoreVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM scores";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStuId(rs.getInt("stu_id"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMath(rs.getInt("math"));
				vo.setTotal(rs.getInt("total"));
				vo.setAverage(rs.getDouble("average"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); pstmt.close(); rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	*/
	
	
	@Override
	public List<ScoreVO> selectAll() {
		String sql = "SELECT * FROM scores";
		//List<ScoreVO> list = template.query(sql, new ScoreMapper());  // new ScoreMapper()를 넣어주면 template.query가 ScoreMapper 클래스의 mapRow 메서드 호출(rs넣고 db에 총 몇행인지 세서 알아서 다 반복해서 List형태로 만들어서 넘겨준다)		
		List<ScoreVO> list = template.query(sql, new RowMapper<ScoreVO>() {  // 익명클래스!
			
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
			
		} );
		return list;
	}
	
 

	@Override
	public void deleteScore(int stuId) {
		
		String sql = "DELETE FROM scores WHERE stu_id=?";	
		template.update(sql, stuId);   
		
	}



	@Override
	public ScoreVO selectOne(int stuNum) {
		
		return null;
	}
	
	
	
	
	
}
 