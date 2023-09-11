package model.dto;

public class MemberDto { // 회원 Dto

	// 필드 
	private int mno;      		// 회원번호              	
	private String mname;  		// 회원이름              		
	private String mid;  		// 회원아이디		
	private String mpwd;		// 회원비밀번호 
	private String memail; 		// 회원이메일
	private String mphone; 		// 회원전화번호
	private String mpayinfo; 	// 결제카드번호
	private String mdate;		// 회원등록일
	
	// 셍성자 
	public MemberDto() {}
	// 풀
	public MemberDto(int mno, String mname, String mid, String mpwd, String memail, String mphone, String mpayinfo,
			String mdate) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mphone = mphone;
		this.mpayinfo = mpayinfo;
		this.mdate = mdate;
	}
	// 등록할때 필요한 생성자 
	public MemberDto(String mname, String mid, String mpwd, String memail, String mphone, String mpayinfo) {
		super();
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mphone = mphone;
		this.mpayinfo = mpayinfo;
	}
	// 메소드 
	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMpayinfo() {
		return mpayinfo;
	}
	public void setMpayinfo(String mpayinfo) {
		this.mpayinfo = mpayinfo;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mname=" + mname + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail
				+ ", mphone=" + mphone + ", mpayinfo=" + mpayinfo + ", mdate=" + mdate + ", getMno()=" + getMno()
				+ ", getMname()=" + getMname() + ", getMid()=" + getMid() + ", getMpwd()=" + getMpwd()
				+ ", getMemail()=" + getMemail() + ", getMphone()=" + getMphone() + ", getMpayinfo()=" + getMpayinfo()
				+ ", getMdate()=" + getMdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}// class e
