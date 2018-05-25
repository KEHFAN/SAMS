package pri.fankehu.sams;

class GetSutSCfromTC {
	private String cno;
	private String cname;
	private String cteacher;
	private String cDname;
	private int ctime;
	private int credit;
	
	public GetSutSCfromTC(String cno,String cname,String cteacher,String cDname,int ctime,int credit) {
		this.setCno(cno);
		this.cteacher=cteacher;
		this.cDname=cDname;
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

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public String getcDname() {
		return cDname;
	}

	public void setcDname(String cDname) {
		this.cDname = cDname;
	}
}
