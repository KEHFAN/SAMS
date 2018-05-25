package pri.fankehu.sams;

class GetTeacher {
	private String tno;
	private String dno;
	private String tname;
	
	private String sex;
	private String birth;
	
	public GetTeacher(String no,String dno,String tname,String sex,String birth) {
		this.tno=no;
		this.dno=dno;
		
		this.tname=tname;
		this.sex=sex;
		this.birth=birth;
	}
	
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
