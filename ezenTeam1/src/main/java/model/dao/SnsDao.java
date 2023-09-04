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
