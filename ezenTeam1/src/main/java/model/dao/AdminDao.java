package model.dao;

import java.util.ArrayList;

import model.dto.RiderDto;

public class AdminDao extends Dao{
	// 0. 싱글톤
	private static AdminDao adminDao = new AdminDao();
	private AdminDao() {}
	public static AdminDao getInstance() {return adminDao;}
	
	
	
	// 1. 기본적인 내용 호출
	public ArrayList<RiderDto> ApprovalPrint(){
		ArrayList<RiderDto> list = new ArrayList<>();
		try {
			// 2.  최신순으로 라이더가 회원가입 요청했을때 간단한 라이더 정보 가져오는 쿼리문
			String sql ="select rno , rid , rdate from rider order by rdate asc";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			// 3. 정보가 여러개니깐 while문으로 여러개 레코드 조회
			while(rs.next()) {
				RiderDto dto = new RiderDto(
						rs.getInt("rno"), rs.getString("rid"),
						rs.getString("rdate")	);
				
				// 4. 리스트에 dto 를 담는다,
				list.add(dto);
			}
			
		}catch (Exception e) {System.out.println(e);}
		// 5. 리스트에 dto 를 담아서 리턴.
		return list;
	}
	
	
	// 2. 상세보기 
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
