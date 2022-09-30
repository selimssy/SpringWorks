package com.spring.database.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DbConnectTest {
	
	private String driver = "com.mysql.cj.jdbc.Driver";  // mysql 8버전부터는 중간에 cj 추가해야
	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";  // 8버전부터 ?serverTimezone=Asia/Seoul 추가해야
	private String uid="root";
	private String upw = "mysql";
	
	//DB 연결 테스트
	@Test
	public void connectTest() {
		
		Connection conn = null;
		
		try {
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB 커넥션 성공!");
			System.out.println("conn: " + conn);
			
		}catch(Exception e){
			
		}finally {
			try {conn.close();} catch(Exception e){}
		}
		
	}
}
