package pri.fankehu.sams;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

class TableViewContentProvider implements IStructuredContentProvider{

	public void dispose() {
		
	}
	
	public void inputChanged(Viewer viewer,Object oldInput,Object newInput) {
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		if(inputElement instanceof List) {
			return ((List)inputElement).toArray();
		}
		else {
			return new Object[0];
		}
		
	}
	
	
}
