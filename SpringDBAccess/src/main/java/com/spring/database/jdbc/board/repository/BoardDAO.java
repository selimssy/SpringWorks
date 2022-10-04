package com.spring.database.jdbc.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.score.model.ScoreVO;
import com.spring.database.jdbc.score.repository.ScoreDAO.ScoreMapper;

@Repository
public class BoardDAO implements IBoardDAO {
	
	
	
	// 내부클래스 선언
	public class BoardMapper implements RowMapper<BoardVO>{ 

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO article = new BoardVO();
			
			article.setBoardNo(rs.getInt("board_no"));
			article.setWriter(rs.getString("writer"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			
			return article;
		}   

	}
	
	
	
	// JdbcTemplate 객체 주입
	@Autowired
	private JdbcTemplate template;
	
	
	
	
	
	// 게시글 전체조회
	@Override
	public List<BoardVO> getArticles() {
		
		String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";  // 게시판일 때는 전체조회 내림차순해야!
		List<BoardVO> list = template.query(sql, new BoardMapper());
		
		return list;
	}

	
	
	// 게시글 등록
	@Override
	public void insertArticle(BoardVO article) {
		
		String sql = "INSERT INTO jdbc_board (writer, title, content) VALUES (?,?,?)";	
		template.update(sql, article.getWriter(), article.getTitle(), article.getContent());   
		
	}
	
	
	// 게시글 삭제
	@Override
	public void deleteArticle(int boardNo) {
		
		String sql = "DELETE FROM jdbc_board WHERE board_no=?";	
		template.update(sql, boardNo);   
		
	}

	
	
	// 게시물 내용 보기
	@Override
	public BoardVO getContent(int boardNo) {
		
		String sql = "SELECT * FROM jdbc_board WHERE board_no=?";
		return template.queryForObject(sql, new BoardMapper(), boardNo);
		

	}
	
	
	
	
	// 게시물 수정
	@Override
	public void modifyArticle(BoardVO article) {
		
		String sql = "UPDATE jdbc_board SET writer=?, title=?, content=? WHERE board_no=?";
		template.update(sql, article.getWriter(), article.getTitle(), article.getContent(), article.getBoardNo());   
		
	}

}
