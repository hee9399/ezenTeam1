package model.dao;

import java.time.LocalDateTime;

import model.dto.RiderDto;

public class RiderDao extends Dao{ // 라이더 

	// 0. 싱글톤 
	private static RiderDao riderDao = new RiderDao();
	private RiderDao() {}
	public static RiderDao getInstance() {return riderDao;}
	
	// 1. 쓰기 / 라이더 회원가입 
	public boolean RiderSignup( RiderDto dto ) {
		System.out.println("RiderDao 도착");
		try {
			String sql = "insert into \r\n"
					+ "	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank ) \r\n"
					+ "	values ( ? , ? , ? , ? , ? , ? , ? , ? , ? ); ";
			System.out.println("sql 입력받았어요"+sql);
			// sql 실행
			ps = conn.prepareStatement(sql);
			// 입력받을 데이터
			ps.setString(1 , dto.getRname() );			ps.setString(2 , dto.getRid() );
			ps.setString(3 , dto.getRpwd() );			ps.setInt(4, dto.getRphone());
			ps.setString(5 , dto.getRphoto() );			ps.setString(6 , dto.getRlicense() );
			ps.setString(7 , dto.getRregistration() );	ps.setString(8 , dto.getRaccount() );	
			ps.setString(9 , dto.getRbank() );
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	
	// 2. 출력 , 로그인 
	public boolean info( String rid , String rpwd ) {
		
		try {
			String sql = "select * from rider where rid = ? and rpwd = ? ";
			// 실행한다. 
			ps = conn.prepareStatement(sql);
			ps.setString(1, rid); ps.setString(2, rpwd);
		
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 3. 수정 
	
	
	// 4. 삭제 
	
	
}// class e
