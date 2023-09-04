package model.dao;

import model.dto.SnsDto;

public class SnsDao extends Dao{

	// 싱글톤 
	private static SnsDao snsDao = new SnsDao();
	private SnsDao() {} 
	public static SnsDao getInstance() {return snsDao;}
	
	// 1. 쓰기
	
	
	// 2. 출력
	
	
	// 3. 수정
	public boolean snsUpdate( SnsDto dto ) {
		
		try {
			String sql = "";
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 4. 삭제 
	
	
	
	
}// class e
