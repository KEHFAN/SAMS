package pri.fankehu.sams;

class GetCourse {
	private String cno;
	private String dno;
	
	private String cname;
	private int ctime;
	private int credit;
	
	public GetCourse(String cno,String dno,String cname,int ctime,int credit) {
		this.setCno(cno);
		this.setDno(dno);
		
		this.setCname(cname);
		this.setCtime(ctime);
		this.setCredit(credit);
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCtime() {
		return ctime;
	}

	public void setCtime(int ctime) {
		this.ctime = ctime;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
