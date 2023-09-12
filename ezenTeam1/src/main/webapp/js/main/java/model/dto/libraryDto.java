package model.dto;

public class libraryDto {
	  // 1. 필드
	   private int lno; // 좌석번호
	   private String lname; // 이름
	   private String lphone; // 연락처
	   
	   // 2. 생성자
	   public libraryDto() {}

	   public libraryDto(int lno, String lname, String lphone) {
	      super();
	      this.lno = lno;
	      this.lname = lname;
	      this.lphone = lphone;
	   }
	   
	   
	   
	   public libraryDto(String lname, String lphone) {
		super();
		this.lname = lname;
		this.lphone = lphone;
	}

	// 3. 메소드
	   public int getLno() {
	      return lno;
	   }

	   public void setLno(int lno) {
	      this.lno = lno;
	   }

	   public String getLname() {
	      return lname;
	   }

	   public void setLname(String lname) {
	      this.lname = lname;
	   }

	   public String getLphone() {
	      return lphone;
	   }

	   public void setLphone(String lphone) {
	      this.lphone = lphone;
	   }

	   @Override
	   public String toString() {
	      return "libraryDto [lno=" + lno + ", lname=" + lname + ", lphone=" + lphone + "]";
	   } 
	   
	}