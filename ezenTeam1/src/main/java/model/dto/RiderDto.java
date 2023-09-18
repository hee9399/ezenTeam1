package model.dto;

public class RiderDto {// 기사 Dto

	// 필드 
	private int rno;      			// 라이더번호              	
	private String rname; 		// 라이더이름              		
	private String rid;				// 라이더아이디		
	private String rpwd; 			// 라이더비밀번호 
	private int rphone;				// 라이더전화번호 
	private String rphoto;			// 라이더프로필사진 //이미지
	private String rlicense;		// 면허증  //이미지
	private String rregistration;	// 차량등록증  //이미지
	private String rdate;			// 등록일
	private String raccount; 		// 계좌번호
	private String rbank;			// 은행
	private String rstatus;			// 승인상태
	private String rcomment;	// 승인거부시 사유
	// 생성자
	public RiderDto() {}
	// 풀 
	public RiderDto(int rno, String rname, String rid, String rpwd, int rphone, String rphoto, String rlicense,
			String rregistration, String rdate, String raccount, String rbank, String rstatus, String rcomment) {
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
		this.rbank = rbank;
		this.rstatus = rstatus;
		this.rcomment = rcomment;
	}
	// 라이더 회원가입 생성자
	// 등록할때 필요한 생성자 
	public RiderDto(String rname, String rid, String rpwd, int rphone, String rphoto, String rlicense,
			String rregistration, String raccount, String rbank) {
		super();
		this.rname = rname;
		this.rid = rid;
		this.rpwd = rpwd;
		this.rphone = rphone;
		this.rphoto = rphoto;
		this.rlicense = rlicense;
		this.rregistration = rregistration;
		this.raccount = raccount;
		this.rbank = rbank;
	}
	// 라이더 간단한 정보 출력할때 생성자
	public RiderDto(int rno, String rid, String rdate) {
		super();
		this.rno = rno;
		this.rid = rid;
		this.rdate = rdate;
	}
	
	// 상세정보 불러올때 필요한 생성자
	public RiderDto(int rno, String rname, String rid, String rphoto, String rlicense, String rregistration,
			String rdate, String raccount, String rbank, String rstatus, String rcomment) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.rid = rid;
		this.rphoto = rphoto;
		this.rlicense = rlicense;
		this.rregistration = rregistration;
		this.rdate = rdate;
		this.raccount = raccount;
		this.rbank = rbank;
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
	public int getRphone() {
		return rphone;
	}
	public void setRphone(int rphone) {
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
	public String getRbank() {
		return rbank;
	}
	public void setRbank(String rbank) {
		this.rbank = rbank;
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
				+ rdate + ", raccount=" + raccount + ", rbank=" + rbank + ", rstatus=" + rstatus + ", rcomment="
				+ rcomment + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// class e
