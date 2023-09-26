package model.dao;



public class CallDao extends Dao{

	
	private static CallDao callDao = new CallDao();
	private CallDao() {}
	public static CallDao getInstance() {return callDao;}
	

	// 2. 상세보기 
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
}
