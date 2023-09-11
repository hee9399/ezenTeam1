package model.dto;

public class RiderDto {// 기사 Dto

	// 필드 
	private int rno;      			// 라이더번호              	
	private String rname; 			// 라이더이름              		
	private String rid;				// 라이더아이디		
	private String rpwd; 			// 라이더비밀번호 
	private String rphone ;			// 라이더전화번호
	private String rphoto;			// 라이더프로필사진 //이미지
	private String rlicense;		// 면허증  //이미지
	private String rregistration;	// 차량등록증  //이미지
	private String rdate;			// 등록일
	private String raccount; 		// 계좌번호
	private String rstatus;			// 승인상태
	private String rcomment;				// 승인거부시 사유
	// 생성자
	public RiderDto() {}
	// 풀 
	public RiderDto(int rno, String rname, String rid, String rpwd, String rphone, String rphoto, String rlicense,
			String rregistration, String rdate, String raccount, String rstatus, String rcomment) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.rid = rid;
		this.rpwd = rpwd;
		this.rphone = rphone;
		this.rphoto = rphoto;
		this.rlicense = rlicense;
		this.rregistration = rregistration;
		this.rdate = rdate;
		this.raccount = raccount;
		this.rstatus = rstatus;
		this.rcomment = rcomment;
	}
	// 메소드 
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRphoto() {
		return rphoto;
	}
	public void setRphoto(String rphoto) {
		this.rphoto = rphoto;
	}
	public String getRlicense() {
		return rlicense;
	}
	public void setRlicense(String rlicense) {
		this.rlicense = rlicense;
	}
	public String getRregistration() {
		return rregistration;
	}
	public void setRregistration(String rregistration) {
		this.rregistration = rregistration;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRaccount() {
		return raccount;
	}
	public void setRaccount(String raccount) {
		this.raccount = raccount;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getRcomment() {
		return rcomment;
	}
	public void setRcomment(String rcomment) {
		this.rcomment = rcomment;
	}
	@Override
	public String toString() {
		return "RiderDto [rno=" + rno + ", rname=" + rname + ", rid=" + rid + ", rpwd=" + rpwd + ", rphone=" + rphone
				+ ", rphoto=" + rphoto + ", rlicense=" + rlicense + ", rregistration=" + rregistration + ", rdate="
				+ rdate + ", raccount=" + raccount + ", rstatus=" + rstatus + ", rcomment=" + rcomment + "]";
	}
	
	
}// class e