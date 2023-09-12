package model.dto;

public class HrmDto {
	private int hrmno; 
	private String hrmimg;
	private String hrmname ;
    private String hrmphone;
    private String hrmposition;
    
    public HrmDto() {}

	public HrmDto(int hrmno, String hrmimg, String hrmname, String hrmphone, String hrmposition) {
		super();
		this.hrmno = hrmno;
		this.hrmimg = hrmimg;
		this.hrmname = hrmname;
		this.hrmphone = hrmphone;
		this.hrmposition = hrmposition;
	}
	
	

	public HrmDto(String hrmimg, String hrmname, String hrmphone, String hrmposition) {
		super();
		this.hrmimg = hrmimg;
		this.hrmname = hrmname;
		this.hrmphone = hrmphone;
		this.hrmposition = hrmposition;
	}

	public int getHrmno() {
		return hrmno;
	}

	public void setHrmno(int hrmno) {
		this.hrmno = hrmno;
	}

	public String getHrmimg() {
		return hrmimg;
	}

	public void setHrmimg(String hrmimg) {
		this.hrmimg = hrmimg;
	}

	public String getHrmname() {
		return hrmname;
	}

	public void setHrmname(String hrmname) {
		this.hrmname = hrmname;
	}

	public String getHrmphone() {
		return hrmphone;
	}

	public void setHrmphone(String hrmphone) {
		this.hrmphone = hrmphone;
	}

	public String getHrmposition() {
		return hrmposition;
	}

	public void setHrmposition(String hrmposition) {
		this.hrmposition = hrmposition;
	}

	@Override
	public String toString() {
		return "HrmDto [hrmno=" + hrmno + ", hrmimg=" + hrmimg + ", hrmname=" + hrmname + ", hrmphone=" + hrmphone
				+ ", hrmposition=" + hrmposition + "]";
	}
    
    
}

