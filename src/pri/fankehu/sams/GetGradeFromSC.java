package pri.fankehu.sams;

class GetGradeFromSC {
	private String no;//ѧ�Ż�γ̺�
	private String name;//ѧ��������γ���
	private int score;
	private double avgscore;
	private int ord;//����
	/*
	public GetGradeFromSC(String no,String name,int score,int avgscore,int ord) {
		this.no=no;
		this.name=name;
		this.score=score;
		this.avgscore=avgscore;
		this.ord=ord;
	}
	*/
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(double avgscore) {
		this.avgscore = avgscore;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
}
