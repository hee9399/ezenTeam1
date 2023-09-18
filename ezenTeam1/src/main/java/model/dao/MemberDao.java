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
			String sql = "insert into member(mname, mid, mpwd, memail, mpayinfo) values (?,?,?,?,?);";
			ps= conn.prepareStatement(sql);
			ps.setString(1, mDto.getMname());
			ps.setString(2, mDto.getMid());
			ps.setString(3, mDto.getMpwd());
			ps.setString(4, mDto.getMemail());
			ps.setString(5, mDto.getMpayinfo());
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
			String sql = "select *  from member where mid =? and mpwd=?";;
					ps = conn.prepareStatement(sql);
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

	// 5. 삭제 , 회원탈퇴


}// class e
