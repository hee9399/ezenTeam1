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
					+ "	rider( rname , rid , rpwd , rphone , rphoto , rlicense ,  rregistration , raccount , rbank , rbikenum ) \r\n"
					+ "	values( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
			System.out.println("sql 입력받았어요"+sql);
			// sql 실행
			ps = conn.prepareStatement(sql);
			// 입력받을 데이터
			ps.setString(1 , dto.getRname() );			ps.setString(2 , dto.getRid() );
			ps.setString(3 , dto.getRpwd() );			ps.setString(4 , dto.getRphone() );
			ps.setString(5 , dto.getRphoto() );			ps.setString(6 , dto.getRlicense() );
			ps.setString(7 , dto.getRregistration() );	ps.setString(8 , dto.getRaccount() );	
			ps.setString(9 , dto.getRbank() );  ps.setString(10, dto.getRbikenum() ); 
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	
	// 2. 출력 , 로그인 
	public boolean Riderlogin( String rid , String rpwd ) {
		
		try {
			String sql = "select * from rider where rid = ? and rpwd = ? ";
			// 실행한다. 
			ps = conn.prepareStatement(sql);
			ps.setString(1, rid); ps.setString(2, rpwd);
		
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 3. 내정보 출력 
	public RiderDto info( String rid ) {
		
		try {
			
			String sql = "select rno , rname , rid , rphone , rphoto , rlicense , rregistration from rider where rid = ? ";
			ps = conn.prepareStatement(sql);
			// 입력받을것 
			ps.setString(1, rid);
			rs = ps.executeQuery();
			// 하나의 정보만 출력할꺼기 때문에 if 사용 
			if(rs.next() ) {
				
				
				
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 4. 수정 
	public boolean rupdate( int rno , String rphone ) {
		
		try {
			
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 5. 삭제 
	public boolean rdelete( int rno , String rpwd ) {
		
		try {
			String sql = "delete from rider where rno = ? and rpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rno); ps.setString(2, rpwd);
			int count = ps.executeUpdate();
			if(count == 1) return true; // 삭제성공 => 회원탈퇴 
			
		} catch (Exception e) {System.out.println(e);}
		
		return false; // 회원번호 또는 입력받은 패스워드 일치하지 않거나 
	}
	
}// class e
