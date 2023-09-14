package model.dto;

public class RiderStateDto { // 라이더상태테이블

	// 필드
	 private int rno;    			// 라이더번호  
     private String rstart;     // 라이더출근상태  
     private String  rcall;	// 라이더콜가능상태
	// 생성자 
	public RiderStateDto() {}
	// 풀 
	public RiderStateDto(int rno, String rstart, String rcall) {
		super();
		this.rno = rno;
		this.rstart = rstart;
		this.rcall = rcall;
	}
	// 메소드
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRstart() {
		return rstart;
	}
	public void setRstart(String rstart) {
		this.rstart = rstart;
	}
	public String getRcall() {
		return rcall;
	}
	public void setRcall(String rcall) {
		this.rcall = rcall;
	}
	@Override
	public String toString() {
		return "RiderStateDto [rno=" + rno + ", rstart=" + rstart + ", rcall=" + rcall + "]";
	}
	
} // class e
