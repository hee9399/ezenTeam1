package model.dao;

public class SnsReplyDao extends Dao{

	// 싱글톤 
	private static SnsReplyDao snsReplyDao = new SnsReplyDao();
	private SnsReplyDao() {} 
	public static SnsReplyDao getInstance() {return snsReplyDao;}
	
	
	// 쓰기
	
	
	// 호출
	
	
	// 삭제 
	public boolean replyDelete(int rno, String rpwd) {
		
		try {
			
			String sql = "delete from reply where rno = ? and rpwd = ?";
			
			ps =conn.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.setString(2, rpwd);
			
			System.out.println("replyDelete  :: SQL :: "+ ps);
			int rs = ps.executeUpdate();
			if(rs ==1 ) { return true;}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
}// class e
