package model.dto;

public class AccountbookDto {


	
		private int ano;
		private String acontent;
		private int aprice;
		private String adate;

		public AccountbookDto() {
			// TODO Auto-generated constructor stub
		}
		

		public AccountbookDto(String acontent, int aprice, String adate) {
			super();
			this.acontent = acontent;
			this.aprice = aprice;
			this.adate = adate;
		}

		public AccountbookDto(int ano, String acontent, int aprice, String adate) {
			super();
			this.ano = ano;
			this.acontent = acontent;
			this.aprice = aprice;
			this.adate = adate;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public String getAcontent() {
			return acontent;
		}

		public void setAcontent(String acontent) {
			this.acontent = acontent;
		}

		public int getAprice() {
			return aprice;
		}

		public void setAprice(int aprice) {
			this.aprice = aprice;
		}

		public String getAdate() {
			return adate;
		}

		public void setAdate(String adate) {
			this.adate = adate;
		}

		@Override
		public String toString() {
			return "AccountbookDao [ano=" + ano + ", acontent=" + acontent + ", aprice=" + aprice + ", adate=" + adate
					+ "]";
		}

	}
