package model.dao;

import java.util.ArrayList;


import model.dto.SnsReplyDto;

public class SnsReplyDao extends Dao{

	// 싱글톤 
	private static SnsReplyDao snsReplyDao = new SnsReplyDao();
	private SnsReplyDao() {} 
	public static SnsReplyDao getInstance() {return snsReplyDao;}
	
	
	// 쓰기
	
	
	// 호출
	
	
	public ArrayList<SnsReplyDto> getReply(int sno){
		
		ArrayList<SnsReplyDto> list = new ArrayList<>();
		
		try {
			String sql = "select rno,rcontent,rdate from reply where sno = ?  order by rdate desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			rs = ps.executeQuery();
			while(rs.next()) {
				SnsReplyDto dto = new SnsReplyDto(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}
	
	// 삭제 
	
}// class e
