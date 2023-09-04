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
			ps=conn.prepareStatement(sql);
			ps.setString(1,snsDto.getSfile());
			ps.setString(2,snsDto.getScontent());
			ps.setString(3,snsDto.getSpwd());
			int row= ps.executeUpdate();
			if(row==1)return true;
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
