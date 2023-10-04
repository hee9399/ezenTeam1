package model.dao;

import java.sql.Statement;
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
		try {
			String sql = "insert into board (btarget,btype,btitle,bcontent,bstartdate,benddate) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getBtarget());
			ps.setString(2, dto.getBtype());
			ps.setString(3, dto.getBtitle());
			ps.setString(4, dto.getBcontent());
			ps.setString(5, dto.getBstartdate());
			ps.setString(6, dto.getBenddate());
			
			int count = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("save ps");
			rs.next();
			if(count == 1) {
				for(String file:dto.getFileList().values()) {
					sql = "insert into boardfiles(bno, bfile) values( ?,?) ";
					ps= conn.prepareStatement(sql);					
					ps.setInt(1, rs.getInt(1));
					ps.setString(2,file);
					ps.executeUpdate();
					
				}return true;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return false;
	}

	// 출력

	// 수정
	public boolean update(BoardDao dto) {
		return false;
	}
	// 삭제
	public boolean delete(BoardDao dto) {
		return false;
	}
	// 조회수

}
