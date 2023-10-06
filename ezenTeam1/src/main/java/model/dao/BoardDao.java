package model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}

	// 저장
	public boolean save(BoardDto dto)  {
		/*
		 this.btarget = btarget;
		 this.btype = btype;
		 this.btitle = btitle;
		 this.bcontent = bcontent;
		 this.bstartdate = bstartdate;
		 this.benddate = benddate;
		 this.fileList = fileList;
		 */
		System.out.println("DAO :: dto:: "+ dto);
		System.out.println("1233");
		try {
			System.out.println("dddddd");
			String sql = "insert into board (btarget,btype,btitle,bcontent,bstartdate,benddate) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getBtarget());
			ps.setString(2, dto.getBtype());
			ps.setString(3, dto.getBtitle());
			ps.setString(4, dto.getBcontent());
			ps.setString(5, dto.getBstartdate().equals("null") ? null : dto.getBstartdate() );
			ps.setString(6, dto.getBenddate().equals("null")? null: dto.getBenddate());
			System.out.println("save ps000"+ ps);


			int count = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("save ps"+ ps);
			rs.next();
			if(count == 1) {
				for(String file:dto.getFileList().values()) {
					sql = "insert into boardfiles(bno, bfile) values( ?,?) ";
					ps= conn.prepareStatement(sql);
					ps.setInt(1, rs.getInt(1));
					ps.setString(2,file);
					ps.executeUpdate();
					System.out.println("filesave ps"+ ps);

				}return true;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return false;
	}

	// 출력
	public ArrayList<BoardDto> boardList(){
		ArrayList<BoardDto> list = new ArrayList<>();
		try {
			String sql = "select "
					+ "  bno "
					+ ", btarget "
					+ ", btype "
					+ ", btitle "
					+ ", bview "
					+ ", DATE_FORMAT(bdate, '%y-%m-%d') as bdate "
					+ ", DATE_FORMAT(bstartdate, '%y-%m-%d') as bstartdate "
					+ ", DATE_FORMAT(benddate, '%y-%m-%d') as benddate  "
					+ "from board "
					+ "order by bno desc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println(" boardList SQL :: " + ps);

			while(rs.next()) {
				BoardDto boardDto = new BoardDto(
					rs.getInt("bno")
					, rs.getString("btarget")
					, rs.getString("btype")
					, rs.getString("btitle")
					, rs.getString("bdate")
					, rs.getInt("bview")
					, rs.getString("bstartdate")
					, rs.getString("benddate"));
				list.add(boardDto);
			}

		}catch(Exception e) {

			System.out.println("Exception :: "+ e);
		} return list;

	}
	
	// 상세보기
	public BoardDto boardView(int bno) {
		

		try {
			
			String sql ="select "
					+ "		b.bno as bno "
					+ "	  , b.btarget as btarget "
					+ "	  , b.btype as btype "
					+ "   , b.btitle as btitle "
					+ "   , b.bcontent as bcontent "
					+ "   , DATE_FORMAT(bdate, '%Y-%m-%d') as bdate "
					+ "   , b.bview as bview "
					+ "   , DATE_FORMAT(b.bstartdate, '%Y-%m-%d') as bstartdate "
					+ "   , DATE_FORMAT(b.benddate, '%Y-%m-%d') as benddate "
					+ "   , bf.bfno as bfno "
					+ "   , bf.bfile as bfile "
					+ " from board b left outer join boardfiles bf on b.bno = bf.bno where b.bno = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			System.out.println("boardView ::ps ::: "+ ps);
			if(rs.next()) {
				BoardDto boardDto = new BoardDto(
						 rs.getInt("bno")
						,rs.getString("btarget") 
						,rs.getString("btype") 
						,rs.getString("btitle") 
						,rs.getString("bcontent") 
						,rs.getString("bdate") 
						,rs.getInt("bview")
						,rs.getString("bstartdate") 
						,rs.getString("benddate") 
						,rs.getInt("bfno")
						,rs.getString("bfile") );
				
				System.out.println("boardView ::boardDto ::: "+ boardDto);
				return boardDto;
			}
		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return null;
	}

	
	
	// 수정
	public boolean update(BoardDao dto) {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;
	}

	// 삭제
	public boolean delete(int bno) {
		try {
			String sql ="delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int cnt = ps.executeUpdate();
			if(cnt == 1) { 	return true; }
			

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;
	}
	// 조회수

}
