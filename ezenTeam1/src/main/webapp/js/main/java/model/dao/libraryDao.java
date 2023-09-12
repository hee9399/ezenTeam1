package model.dao;

import java.util.ArrayList;

import model.dto.libraryDto;

public class libraryDao extends Dao{
	  // 0. 싱글톤
	   private static libraryDao libraryDao = new libraryDao();
	   private libraryDao() {}
	   public static libraryDao getInstance() { return libraryDao; }
	   
	   
	   // 1. 저장 
	   public boolean lwriter(libraryDto dto) {
		   try {
			   
			   String sql="insert into library(lno,lname,lphone) values(?,?,?)";
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, dto.getLno());
			   ps.setString(2, dto.getLname());
			   ps.setString(3, dto.getLphone());
			   int rs = ps.executeUpdate();
			   if(rs==1) {return true;}
			   return false;
			   
		   }catch (Exception e) {System.out.println(e);}
		   return false;
	   }
	   
	   
	   // 2. 호출 [ 인수 : x , 리턴 : 여러개(ArrayList)의 방문록DTO = 모든 레코드 가져오기 ]
	   public ArrayList<libraryDto> lread() { 
	      ArrayList<libraryDto> list = new ArrayList<>(); // 여러개 dto를 담을 리스트 객체 
	      try {
	         String sql = "select * from library order by lno desc ";
	         ps = conn.prepareStatement(sql);
	         rs = ps.executeQuery(); // s->q , i/d/u -> u ,
	         while( rs.next() ) { // rs.next() : select 검색결과중 다음레코드 이동 =존재하면 true / 존재하지 않으면 false 
	            // * 하나 레코드/하나 줄/ 하나 행/ 하나 방문록 / 하나 DTO
	            // 레코드 --> DTO 변환 ( 레코드마다 각 필드 호출 = rs.get타입(필드순서번호) vs  rs.get타입("필드명") ) 
	            libraryDto libraryDto = new libraryDto( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ) );
	            
	            // ** 여러개 dto를 저장할 리스트에 저장 
	            list.add(libraryDto);
	         }
	      }catch (Exception e) {System.out.println(e);}
	      return list;  // 리스트 반환 
	   }
	   
	   // 3. 삭제 [ 인수 : 삭제할방문록번호(int) , 리턴 : 성공/실패(boolean)=true/false ] 
	   public boolean ldelete( int lno) {
	      try {
	         String sql ="delete from library where lno = ?"; // 1. SQL 작성 
	         ps = conn.prepareStatement(sql);   // 2. SQL 연결
	         ps.setInt(1, lno);   // 3. SQL 매개변수 대입
	         int row = ps.executeUpdate();   // 4. SQL 실행
	         if ( row ==1 ) return true; // 5. SQL 실행 결과 따른 제어
	         return false; 
	      }catch (Exception e) { System.out.println(e); }
	      
	      return false; 
	      
	   }
	}