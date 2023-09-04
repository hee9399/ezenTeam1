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
			String sql = "";
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 4. 삭제 
	public boolean sdelete(int sno, String spwd) {
		try {
			String sql = "delete from sns where sno = ? and spwd =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			ps.setString(2, spwd);
			int count = ps.executeUpdate();
			if(count == 1) return true;
			
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	
}// class e
