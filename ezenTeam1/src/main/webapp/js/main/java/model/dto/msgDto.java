package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.MemberDao;

public class msgDto {					// 주고받은 메세지 정보들을 설걔한 클래스
	private String frommid;			// 보낸사람
	private String msg;				 	// 보낸 내용
	private String frommimg;			// 보낸사람 프로필 이미지
	private String date;					// 보낸시간
	
fgxfx
	public msgDto() {}

	public msgDto(String frommid, String msg, String frommimg, String date) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		this.frommimg = frommimg;
		this.date = date;
	}
	
	public msgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		// 객체 생성시 추가코드
			// 1. 보낸사람 프로필 가져오기( 맴버다오에서  info함수를 가져오는데 info함수는 memberdto를 반환하고있으니 거기서 mimg만 빼오겠다.
			this.frommimg=MemberDao.getInstance().info(frommid).getMimg();
			// 2. 보낸일시 구하기
				// 1. new Date() : 현재 시간 /날짜 제공하는 클래스 [import java.util.Date]
			Date date = new Date(); System.out.println("현재날짜/시간"+date);
				// 2. 날짜 포멧(형식)
			SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm");
				// y연도 M월 d일 h시m분s초 a오전오후
			this.date = sdf.format(date); // 현재시간을 정의한형식으로 변환
			// 생성자는 실행은 되는데 메소드와 다른점은  리턴이없다. - 결과값을 다른곳으로 리턴 불가능
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "msgDto [frommid=" + frommid + ", msg=" + msg + ", frommimg=" + frommimg + ", date=" + date + "]";
	}
	
	
}
