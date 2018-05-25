package pri.fankehu.sams;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

class TableViewerLabelProvider implements ITableLabelProvider{

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	//以下方法模板化
	@Override
	public String getColumnText(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg0 instanceof Dept) {//判断对象 实现多用
			Dept dept=(Dept) arg0;
			if(arg1==0) {
				return dept.getNo().toString();
			}
			if(arg1==1) {
				return dept.getName();
			}
			return "";
		}
		else if(arg0 instanceof GetTeacher) {
			GetTeacher tea=(GetTeacher) arg0;
			if(arg1==0) {
				return tea.getTno();
			}
			if(arg1==1) {
				return tea.getDno();
			}
			
			if(arg1==2) {
				return tea.getTname();
			}
			if(arg1==3) {
				return tea.getSex();
			}
			if(arg1==4) {
				return tea.getBirth();
			}
			return "";
		}
		else if(arg0 instanceof GetCourse) {
			GetCourse co=(GetCourse) arg0;
			if(arg1==0) {
				return co.getCno();
			}
			if(arg1==1) {
				return co.getDno();
			}
			
			if(arg1==2) {
				return co.getCname();
			}
			if(arg1==3) {
				return String.valueOf(co.getCtime());
			}
			if(arg1==4) {
				return String.valueOf(co.getCredit());
			}
			return "";
		}
		else if(arg0 instanceof GetStudent) {
			GetStudent s=(GetStudent) arg0;
			if(arg1==0) {
				return s.getSno();
			}
			if(arg1==1) {
				return s.getDno();
			}
			
			if(arg1==2) {
				return s.getSname();
			}
			if(arg1==3) {
				return (s.getSex());
			}
			if(arg1==4) {
				return String.valueOf(s.getSclass());
			}
			if(arg1==5) {
				return s.getBirth();
			}
			if(arg1==6) {
				return s.getEntry();
			}
			if(arg1==7) {
				return s.getHome();
			}
			return "";
		}
		else if(arg0 instanceof Getsct) {
			Getsct s=(Getsct) arg0;
			if(arg1==0) {
				return s.getNo();
			}
			if(arg1==1) {
				return s.getName();
			}
			
			if(arg1==2) {
				return s.getSex();
			}
			if(arg1==3) {
				return String.valueOf(s.getScore());
			}
			
			return "";
		}
		else if(arg0 instanceof GetSutSCfromTC) {
			GetSutSCfromTC s=(GetSutSCfromTC) arg0;
			if(arg1==0) {
				return s.getCno();
			}
			if(arg1==1) {
				return s.getCname();
			}
			
			if(arg1==2) {
				return s.getCteacher();
			}
			if(arg1==3) {
				return s.getcDname();
			}
			if(arg1==4) {
				return String.valueOf(s.getCtime());
			}
			if(arg1==5) {
				return String.valueOf(s.getCredit());
			}
			return "";
		}
		else if(arg0 instanceof GetGradeFromSC) {
			GetGradeFromSC s=(GetGradeFromSC) arg0;
			if(arg1==0) {
				return s.getNo();
			}
			if(arg1==1) {
				return s.getName();
			}
			
			if(arg1==2) {
				return String.valueOf(s.getScore());
			}
			if(arg1==3) {
				return String.valueOf(s.getAvgscore());
			}
			if(arg1==4) {
				return String.valueOf(s.getOrd());
			}
			return "";
		}
		else if(arg0 instanceof GetOrdFromView) {
			GetOrdFromView s=(GetOrdFromView) arg0;
			if(arg1==0) {
				return s.getNo();
			}
			if(arg1==1) {
				return s.getName();
			}
			
			if(arg1==2) {
				return String.valueOf(s.getScore());
			}
			if(arg1==3) {
				return String.valueOf(s.getOrd());
			}
			return "";
		}
		
		return null;
	}
	
}
