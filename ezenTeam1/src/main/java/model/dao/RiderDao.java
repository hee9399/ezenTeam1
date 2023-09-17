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
					+ "	rider( rname , rid , rpwd , rphoto , rlicense ,  rregistration , raccount , rbank ) \r\n"
					+ "	values ( ? , ? , ? , ? , ? , ? , ? , ? ) ";
			System.out.println("sql 입력받았어요"+sql);
			// sql 실행
			ps = conn.prepareStatement(sql);
			// 입력받을 데이터
			ps.setString(1 , dto.getRname() );		ps.setString(2 , dto.getRid() );
			ps.setString(3 , dto.getRpwd() );		ps.setString(4 , dto.getRphoto() );
			ps.setString(5 , dto.getRlicense() );	ps.setString(6 , dto.getRregistration() );
			ps.setString(7 , dto.getRaccount() );	ps.setString(8 , dto.getRbank() );
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	// 2. 로그인 ( 세션 저장 ) 
	
	// 3. 출력 
	public RiderDto info( String rid ) {
		
		try {
			String sql = "select rno , rname , rid , rphoto , rlicense , rregistration , raccount , rbank , rstatus ,  rcomment from rider where rid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rid);
			rs = ps.executeQuery();
			if(rs.next()) {
				RiderDto riderDto = new RiderDto(
						LocalDateTime.now().toString() 
						rs.getInt(1) , rs.getString(2) ,
						rs.getString(3) , rs.getString(4) , 
						rs.getString(5) , rs.getString(6) ,
						rs.getString(7) , rs.getString(8) ,
						rs.getString(9) , rs.getString(10) );
				return riderDto;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 4. 수정 
	
	// 5. 삭제 
	
}// class e
