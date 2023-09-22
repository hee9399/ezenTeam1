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
	// 3. 승인 거부 함수
	public boolean ApprovalReject(int rno, String rcomment) {
		RiderDto dto = new RiderDto();
		try {
			 String sql = "UPDATE rider SET rstatus = '0', rcomment = ? WHERE rno = ?";
			  ps = conn.prepareStatement(sql);
		        ps.setString(1, rcomment);
		        ps.setInt(2, rno);
		        int count = ps.executeUpdate();
 
		        // 업데이트가 성공하면 count는 1이상의 값을 가집니다.
		        if (count > 0) {
		            return true; // 승인 거부 성공
		        }
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean approval(int rno) {
		RiderDto riderDto = new RiderDto();
		System.out.println("11111"+riderDto);
		try {
			String sql="UPDATE rider SET rstatus =? WHERE rno = ? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, riderDto.getRno());
			ps.setString(2, riderDto.getRstatus());
			int count = ps.executeUpdate();
				System.out.println("11111222"+count);
			if(count>0) {
				// return onapprove(rno);	
				return true;
			}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	/*	
	public boolean onapprove(int rno) { 
		try {
			String sql = "insert into riderstate (rno, rstart, rcall) values (?, ?, ?)";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, rno);
	        ps.setString(2, "1"); // 예시로 '1' 값을 설정
	        ps.setString(3, "1"); // 예시로 '1' 값을 설정

	        int count = ps.executeUpdate();

	        if (count > 0) { 
	            return true;
	        }
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	*/
}
