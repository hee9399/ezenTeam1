package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao{
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstance() {return hrmDao;}
	private HrmDao() {}
	
	public boolean save(HrmDto dto) {
		try {
			String sql="insert into hrm(hrmimg,hrmname,hrmphone,hrmposition) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getHrmimg());
			ps.setString(2, dto.getHrmname());
			ps.setString(3, dto.getHrmphone());
			ps.setString(4, dto.getHrmposition());
			
			int row = ps.executeUpdate();
			if(row==1)return true;
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}

public ArrayList<HrmDto>hread(){
		ArrayList<HrmDto> list = new ArrayList<HrmDto>();
		try {
			String sql ="select * from hrm order by hrmday desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				int hrmno = rs.getInt("hrmno");
				String hrmimg = rs.getString("hrmimg");
				String hrmname = rs.getString("hrmname");
				String hrmphone = rs.getString("hrmphone");
				String hrmposition = rs.getString("hrmposition");
				HrmDto hrmDto = new HrmDto(hrmno,hrmimg,hrmname,hrmphone,hrmposition);
				list.add(hrmDto);
				
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
}

