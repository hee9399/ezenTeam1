package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{

	// 0. 싱글톤
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return memberDao;}

	// 1. 쓰기 , 회원가입
	public boolean signup(MemberDto mDto) {
		try {
			String sql = "insert into member(mname, mid, mpwd, memail, mpayinfo,mphoto) values (?,?,?,?,?,?);";
			ps= conn.prepareStatement(sql);
			ps.setString(1, mDto.getMname());
			ps.setString(2, mDto.getMid());
			ps.setString(3, mDto.getMpwd());
			ps.setString(4, mDto.getMemail());
			ps.setString(5, mDto.getMpayinfo());
			ps.setString(6, mDto.getMphoto());
			System.out.println("SQL M signup() ::" +ps);
			int rs = ps.executeUpdate();
			if(rs == 1) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception ::::"+ e);
		}
		return false;
	}



	// 2. 출력 , 로그인
	public boolean login(String mid, String mpwd) {

		try {
			String sql = "select *  from member where mid =? and mpwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;

	}


	// 3. 아이디/이메일 중복검사 [ 인수 : 검사할아이디 / 반환 : true(중복없이) , false(중복없이) ]
	public boolean isExist(String search, String key) {
		String sql = "select *from member  where "+ search +" = ?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, key);
			rs = ps.executeQuery();
			System.out.println("MEMBER :: isExist() _SQL"+ps);

			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception  :: " + e);
		}

		return false;
	}

	// 4. 수정 , 회원수정
	public boolean updateInfo(String mid) {

		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+e);
		}
		return false;
	}

	// 5. 삭제 , 회원탈퇴
	public boolean deleteInfo(String mid) {

		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+e);
		}
		return false;
	}

	// 6. 세션에 저장할 회원정보 가져오기
	public MemberDto getLoginInfo(String mid) {

		try {
			String sql = " select * from member where mid = ? ";
			ps= conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto loginDto = new MemberDto(
						  rs.getInt("mno")
						, rs.getString("mname")
						, rs.getString("mid")
						, rs.getString("memail")
						, rs.getString("mpayinfo")
						, rs.getString("mdate")
						, rs.getString("mphoto"));

				return loginDto;
			}


		} catch (Exception e) {
			System.out.println("Exception :: "+e);
		}
		return null;
	}
	// 7. 아이디 or 비밀번호 찾기
	public MemberDto onFind (String type, String req1, String req2) {

		try {
			String sql = " select * from member where memail = ? ";

			if (type.equals("findId")) { //아이디찾기
				sql += "and mname = " + req1;
			} else if(type.equals("findPwd")) { //비밀번호찾기
				sql += "and mid = " + req1 ;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, req1);
			System.out.println(" MemberDao :: onFind :: "+ ps);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto memberDto = new MemberDto(
						rs.getInt("mno"), rs.getString("mname"),
						 rs.getString("mid"),  rs.getString("memail"),
						 rs.getString("mpayinfo"),  rs.getString("mdate"),
						 rs.getString("mphoto"));
				return memberDto;
			}
		} catch (Exception e) {
			System.out.println("Exception :: " + e);
		}
		return null;
	}

	// 8 내 정보가져오기

	// 9.  결제정보 변경하기
}// class e
