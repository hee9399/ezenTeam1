package model.dao;

import java.util.ArrayList;

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
	public ArrayList<SnsDto> snsList(){
		
		ArrayList<SnsDto> list = new ArrayList<>(); 
		
		try {
			
			String sql ="select * from sns order by sdate desc";
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				SnsDto snsDto = new SnsDto(
						  rs.getInt("sno")
						, rs.getString("sfile")
						, rs.getString("scontent")
						, rs.getString("spwd")
						, rs.getString("sdate"));
				list.add(snsDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
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
