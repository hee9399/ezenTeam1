package model.dao;



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
	
	// 2. 콜정보에 대한 수락정보 INSERT
	public boolean RiderAccept(int rno , double 라이더위도 , double 라이더경도 , String accept ) {
		try {
			String sql = "insert into rider ( rno, 라이더위도,라이더경도,accept) values (?,?,?,?) ";
			ps.setInt(1, rno);
			ps.setDouble(2, 라이더위도);
			ps.setDouble(3, 라이더경도);
			ps.setString(4, accept);
			
			int count = ps.executeUpdate();
			if(count == 1) return true;
		} catch (Exception e) {
			System.out.println();
		}
		
		
		return false;
		
	}
}
