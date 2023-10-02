package model.dao;

import model.dto.BoardDto;

public class BoardDao {

	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}

	// 저장
	public boolean save(BoardDto dto) {
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
