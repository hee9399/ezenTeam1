package model.dao;

import model.dto.ServiceDto;

public class CallDao extends Dao{

	
	private static CallDao callDao = new CallDao();
	private CallDao() {}
	public static CallDao getInstance() {return callDao;}
	

	// 2. 상세보기 
	public ServiceDto ApprovalView(int mno) {
		try {
			String sql = "select * from service where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs= ps.executeQuery();
			if(rs.next()) {
				ServiceDto serviceDto = new ServiceDto(
						rs.getInt(1),
						rs.getDouble(2), rs.getDouble(3),rs.getDouble(4),
						rs.getDouble(5)
						
						);
				return serviceDto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
}
