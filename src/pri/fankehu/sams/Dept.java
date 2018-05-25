package pri.fankehu.sams;

class Dept {
	private String no;
	private String name;
	
	public Dept(String no,String name) {
		this.no=no;
		this.name=name;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
