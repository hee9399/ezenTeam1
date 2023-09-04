package model.dao;

import model.dto.SnsDto;

public class SnsDao extends Dao{

	// 싱글톤 
	private static SnsDao snsDao = new SnsDao();
	private SnsDao() {} 
	public static SnsDao getInstance() {return snsDao;}
	
	// 1. 쓰기
	public boolean swrite(SnsDto snsDto) {
		
		try {
			String sql="insert into sns(sfile,scontent,spwd) values(?,?,?)";
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 출력
	
	
	// 3. 수정
	public boolean snsUpdate( SnsDto dto ) {
		
		try {
			// sql작성 
			String sql = "update sns set sfile = ? , scontent = ? , spwd = ? where sno = ?";
			// sql 실행 
			ps = conn.prepareStatement(sql);
			// 입력받을 dto생성자 
			ps.setString( 1 , dto.getSfile() );
			ps.setString( 2 , dto.getScontent() );
			ps.setString( 3 , dto.getSpwd() );
			ps.setString( 4 , dto.getSdate() );
			ps.setInt(5 , dto.getSno() );
			int count = ps.executeUpdate();
			// 1개의 레코드 이면 true
			if(count == 1)return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 4. 삭제 
	public boolean sdelete(int sno) {
		try {
			String sql = "delete from sns where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			int count = ps.executeUpdate();
			if(count == 1) return true;
			
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	
}// class e
