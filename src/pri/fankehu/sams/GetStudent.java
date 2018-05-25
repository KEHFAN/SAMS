package pri.fankehu.sams;

class GetStudent {
	private String sno;
	private String dno;
	
	private String sname;
	private String sex;
	private int sclass;
	private String birth;
	private String entry;
	private String home;
	
	public GetStudent(String sno,String dno,String sname,String sex,int sclass,String birth,String entry,String home) {
		this.setSno(sno);
		this.setDno(dno);
		
		this.setSname(sname);
		this.setSex(sex);
		this.setSclass(sclass);
		this.setBirth(birth);
		this.setEntry(entry);
		this.setHome(home);
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getSclass() {
		return sclass;
	}

	public void setSclass(int sclass) {
		this.sclass = sclass;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
}
