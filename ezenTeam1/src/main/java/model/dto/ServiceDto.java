package model.dto;

public class ServiceDto {// 서비스 Dto

	// 필드 
	private int sno;			// 서비스번호
	private int mno; 			// 회원번호  
	private int rno;     		// 회원번호              	
	private String sdate; 		// 서비스이용일
	private double sfromla; 	// 서비스 시작위치 위도
	private double sfromlo;		// 서비스 시작위치 경도
	private double stola;		// 서비스 도착위치 위도
	private double stolo;		// 서비스 도착위치 경도
	private int spayment; 		// 서비스결제금액
	private boolean spayYN;		// 결제여부
	private String sreview;		// 리뷰
	private int spoint;			// 별점
	// 생성자 
	public ServiceDto() {}
	// 풀 
	public ServiceDto(int sno, int mno, int rno, String sdate, double sfromla, double sfromlo, double stola,
			double stolo, int spayment, boolean spayYN, String sreview, int spoint) {
		super();
		this.sno = sno;
		this.mno = mno;
		this.rno = rno;
		this.sdate = sdate;
		this.sfromla = sfromla;
		this.sfromlo = sfromlo;
		this.stola = stola;
		this.stolo = stolo;
		this.spayment = spayment;
		this.spayYN = spayYN;
		this.sreview = sreview;
		this.spoint = spoint;
	}
	
	// 라이더가 콜을 누르기 전에 저장되는 생성자
	public ServiceDto(int mno, double sfromla, double sfromlo, double stola, double stolo) {
		super();
		this.mno = mno;
		this.sfromla = sfromla;
		this.sfromlo = sfromlo;
		this.stola = stola;
		this.stolo = stolo;
	}
	
	// 서비스 정보 조회 생성자
	public ServiceDto(int sno, int rno, String sdate, String sreview, int spoint) {
		super();
		this.sno = sno;
		this.rno = rno;
		this.sdate = sdate;
		this.sreview = sreview;
		this.spoint = spoint;
	}
	
	// 라이더가 콜을 누른 후에 저장되는 생성자
	
	// 메소드 
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public double getSfromla() {
		return sfromla;
	}
	public void setSfromla(double sfromla) {
		this.sfromla = sfromla;
	}
	public double getSfromlo() {
		return sfromlo;
	}
	public void setSfromlo(double sfromlo) {
		this.sfromlo = sfromlo;
	}
	public double getStola() {
		return stola;
	}
	public void setStola(double stola) {
		this.stola = stola;
	}
	public double getStolo() {
		return stolo;
	}
	public void setStolo(double stolo) {
		this.stolo = stolo;
	}
	public int getSpayment() {
		return spayment;
	}
	public void setSpayment(int spayment) {
		this.spayment = spayment;
	}
	public boolean isSpayYN() {
		return spayYN;
	}
	public void setSpayYN(boolean spayYN) {
		this.spayYN = spayYN;
	}
	public String getSreview() {
		return sreview;
	}
	public void setSreview(String sreview) {
		this.sreview = sreview;
	}
	public int getSpoint() {
		return spoint;
	}
	public void setSpoint(int spoint) {
		this.spoint = spoint;
	}
	@Override
	public String toString() {
		return "ServiceDto [sno=" + sno + ", mno=" + mno + ", rno=" + rno + ", sdate=" + sdate + ", sfromla=" + sfromla
				+ ", sfromlo=" + sfromlo + ", stola=" + stola + ", stolo=" + stolo + ", spayment=" + spayment
				+ ", spayYN=" + spayYN + ", sreview=" + sreview + ", spoint=" + spoint + "]";
	}
	
	
}// class
