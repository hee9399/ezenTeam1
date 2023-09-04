package model.dto;

public class SnsDto {
	
	// 필드
	private int sno;
	private String sfile;
	private String scontent;
	private String spwd;
	private String sdate;
	
	// 기본 생성자
	public SnsDto() {}

	// 풀 
	public SnsDto(int sno, String sfile, String scontent, String spwd, String sdate) {
		super();
		this.sno = sno;
		this.sfile = sfile;
		this.scontent = scontent;
		this.spwd = spwd;
		this.sdate = sdate;
	}
	// 등록할때 필요한 생성자
	public SnsDto(String sfile, String scontent, String spwd) {
		super();
		this.sfile = sfile;
		this.scontent = scontent;
		this.spwd = spwd;
	}
	
	// 메소드
	
	public int getSno() {
		return sno;
	}	

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "SnsDto [sno=" + sno + ", sfile=" + sfile + ", scontent=" + scontent + ", spwd=" + spwd + ", sdate="
				+ sdate + "]";
	}
	
	
	
	
	
}// class e
