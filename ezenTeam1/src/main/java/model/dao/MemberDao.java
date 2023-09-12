package model.dao;

public class MemberDao {

	// 0. 싱글톤 
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return memberDao;}
	
	// 1. 쓰기 , 회원가입
	
	// 2. 출력 , 로그인 
	
	// 3. 아이디/이메일 중복검사 [ 인수 : 검사할아이디 / 반환 : true(중복없이) , false(중복없이) ]
	
	// 4. 수정 , 회원수정 
	
	// 5. 삭제 , 회원탈퇴 
	
	
}// class e
