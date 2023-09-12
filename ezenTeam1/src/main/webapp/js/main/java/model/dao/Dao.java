package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	//1. 필드
		public Connection conn; 			// DB연동 객체
		public PreparedStatement ps;	// 연동된 DB에서 SQL조작하는 객체
		public ResultSet rs; 				// SQL 조각 결과를 가져오는 객체
		
		//2.생성자 : 객체 생성시 초기화 담당
			// 기본생성자에 DB연동 코드 작성 *DAO객체생성시 바로 DB연동
		public Dao() { // DB에 연동하는 상위 클래스 
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("안내] DB연동성공");
			
			}catch(Exception e) {
				System.out.println("안내] DB연동실패: "+e);
			}
		}
}
