package model.dao;

public class SnsDao extends Dao{

	// 싱글톤 
	private static SnsDao snsDao = new SnsDao();
	private SnsDao() {} 
	public static SnsDao getInstance() {return snsDao;}
	
	// 1. 쓰기
	
	
	// 2. 출력
	
	
	// 3. 수정
	
	
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
