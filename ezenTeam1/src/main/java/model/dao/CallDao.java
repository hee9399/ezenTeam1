package model.dao;

import model.dto.RiderDto;

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
		// 1. 라이더의 위치 DB에 담아주기
		// 2. 담아준 위치와 라이더의 정보들을 조회하기
	
	public boolean RiderAccept(int rno,double 라이더위도,
			double 라이더경도) {
		try {
			String sql = "update rider set 라이더위도 = ?,라이더경도 =? where rno = ?;";
			ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, 라이더위도);
			ps.setDouble(2, 라이더경도);
			ps.setInt(3, rno);
			
			
			int count = ps.executeUpdate();
			if(count == 1) return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	public RiderDto SendRiderInfo(int rno) {
		try {
			String sql = "select  rno,  rname,  rphone,  rphoto,  accept,  라이더위도,  라이더위도 from rider where rno = ? ";
			ps.setInt(1, rno);
			rs= ps.executeQuery();
			if(rs.next()) {
				RiderDto riderDto = new RiderDto(
						rs.getInt("rno"),
						rs.getString("rname"),rs.getString("rphone"),
						rs.getString("rphoto"),rs.getString("accept"),
						rs.getDouble("라이더위도"),rs.getDouble("라이더위도")
						
						);
				return riderDto;
		} 
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	
	
	public RiderDto ApprovalView(int rno) {
		try {
			String sql = "select * from rider where rno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rno);
			rs= ps.executeQuery();
			if(rs.next()) {
				RiderDto riderDto = new RiderDto(
						rs.getInt("rno"),
						rs.getString("rname"), rs.getString("rid"),rs.getString("rphone"),
						rs.getString("rphoto"),rs.getString("rlicense"),
						rs.getString("rregistration"),rs.getString("rdate"),
						rs.getString("raccount"),rs.getString("rbank"),
						rs.getString("rstatus"),rs.getString("rcomment"), rs.getString("rbikenum")
						);
				return riderDto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
}
