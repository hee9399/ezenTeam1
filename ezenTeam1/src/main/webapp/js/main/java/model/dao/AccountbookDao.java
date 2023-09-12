package model.dao;

import java.util.ArrayList;

import model.dto.AccountbookDto;

public class AccountbookDao  extends Dao{
	private static AccountbookDao accountbookDao = new AccountbookDao();
    public static AccountbookDao getInstanct () {return accountbookDao;}
    private AccountbookDao() {};
	
	public boolean awriter(AccountbookDto dto) {
		try {String sql = "insert into accountbook(acontent,aprice,adate)values(?,?,?);";
	
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, dto.getAcontent());
			 ps.setInt(2, dto.getAprice());
			 ps.setString(3, dto.getAdate());
			 int rs = ps.executeUpdate();
			 if(rs==1) {return true;}
			 return false;
			 
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public ArrayList<AccountbookDto> aread(){
		ArrayList<AccountbookDto> list = new ArrayList<AccountbookDto>();
		try {
			String sql = "select * from accountbook order by adate desc;";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				int ano =  rs.getInt("ano");
				String acontent=rs.getString("acontent");
				int aprice = rs.getInt("aprice");
				String adate = rs.getString("adate");
				AccountbookDto accountbookDto = new AccountbookDto(ano,acontent,aprice,adate);
				list.add(accountbookDto);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	public boolean aupdate(int ano , String acontent,int aprice , String adate) {
		try {
			String sql = "update accountbook set acontent =? , aprice = ?, adate =?  where ano=?;";
			ps=conn.prepareStatement(sql);
			ps.setString(1, acontent);
			ps.setInt(2, aprice);
			ps.setString(3, adate);
			ps.setInt(4, ano);
		
			int rs = ps.executeUpdate();
			if(rs==1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	public boolean adelete(int ano) {
		try { String sql = "delete from accountbook where ano=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			int rs = ps.executeUpdate();
			if(rs==1) {return true;}
			return false;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;}
	
}