package model.dao;

import model.dto.ServiceDto;

public class CallDao extends Dao{

	
	private static CallDao callDao = new CallDao();
	private CallDao() {}
	public static CallDao getInstance() {return callDao;}
	

	// 1. 사용자 콜정보 INSERT
	public boolean MemberCall(int mno, double sfromla,double sfromlo,double stola, double stolo ) {
		try {
			String sql = "insert into service (mno,sfromla,sfromlo,stola,stolo) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setDouble(2, sfromla);
			ps.setDouble(3, sfromlo);
			ps.setDouble(4, stola);
			ps.setDouble(5, stolo);
			
			int count = ps.executeUpdate();
			if(count == 1) return true;
	

		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 콜했을때 두가지
		// 1. 라이더의 위치 DB에 수정
	public boolean RiderAccept(int rno,double sriderla,
			double sriderlo, int sno) {
		try {
			String sql = "update service set sriderla = ?,sriderlo =? ,rno = ? where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, sriderla);
			ps.setDouble(2, sriderlo);
			ps.setInt(3, rno);
			ps.setInt(4, sno);
			
			
			int count = ps.executeUpdate();
			if(count == 1) return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2. 콜 수락했을때 사용자가 라이더 정보 확인
	public ServiceDto ShowRiderInfo(int sno, int rno, double sriderla, double sriderlo, String rname, String rphoto, String rbikenum) {
		try {
			String sql = "SELECT s.sno, s.sriderla, s.sriderlo, s.rno, r.rname, r.rphoto, r.rbikenum " +
                    "	FROM service s " +
                    "	INNER JOIN rider r ON s.rno = r.rno	where s.sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rno);
			rs= ps.executeQuery();
			if(rs.next()) {
				ServiceDto servicedto= new ServiceDto(
						rs.getInt("sno"),
						rs.getInt("rno"),
						rs.getDouble("sriderla"),
						rs.getDouble("sriderlo"),
						 rs.getString("rphoto"),
						 rs.getString("rname"),
						 rs.getString("rbikenum")
						);
				return servicedto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
}
