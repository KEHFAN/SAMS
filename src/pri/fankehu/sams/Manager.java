package pri.fankehu.sams;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class Manager {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Shell parentShell;//获取父窗口
	private Connection con;//连接
	private Statement state=null;
	private PreparedStatement preparedStatement;
	private PreparedStatement pr;
	private ResultSet rs;//查询结果
	private String sql;//sql语句
	private Text text_4;
	private String d_no;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Table table_3;
	private int c;
	private int d;
	private int s;
	private int t;
	private boolean isUpdate=false;

	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public void open() throws SQLException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		setState((Statement) getCon().createStatement());
		System.out.println("login");
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws SQLException 
	 */
	protected void createContents() throws SQLException {
		shell = new Shell(SWT.TITLE);
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				
			}
		});
		shell.setSize(783, 556);
		shell.setText("\u7BA1\u7406\u5458");
		
		
		Label label_51 = new Label(shell, SWT.NONE);
		label_51.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_51.setBounds(74, 10, 293, 17);
		
		Label label_52 = new Label(shell, SWT.NONE);
		label_52.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_52.setBounds(74, 108, 180, 17);
		
		Label label_53 = new Label(shell, SWT.NONE);
		label_53.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_53.setBounds(71, 232, 164, 17);
		
		Label label_54 = new Label(shell, SWT.NONE);
		label_54.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_54.setBounds(74, 354, 161, 17);

		System.out.println("label_51");
		//查询表行数赋值给51
		sql="select count(*) from d";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		while(rs.next()) {
			label_51.setText("共 "+rs.getString("count(*)")+" 条记录");
			d=Integer.valueOf(rs.getString("count(*)"));
		}
		sql="select count(*) from t";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		while(rs.next()) {
			label_52.setText("共 "+rs.getString("count(*)")+" 条记录");
			t=Integer.valueOf(rs.getString("count(*)"));
		}
		sql="select count(*) from c";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		while(rs.next()) {
			label_53.setText("共 "+rs.getString("count(*)")+" 条记录");
			c=Integer.valueOf(rs.getString("count(*)"));
		}
		sql="select count(*) from s";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		while(rs.next()) {
			label_54.setText("共 "+rs.getString("count(*)")+" 条记录");
			s=Integer.valueOf(rs.getString("count(*)"));
		}
		
		
		
		List<String> list=new ArrayList<>();
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 61, 17);
		label.setText("\u6DFB\u52A0\u7CFB\u522B");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(50, 68, 61, 17);
		label_1.setText("\u7CFB\u522B\u7F16\u53F7\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(50, 35, 61, 17);
		label_2.setText("\u7CFB\u522B\u540D\u79F0\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(117, 29, 250, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(117, 62, 88, 23);
		
		Button button = new Button(shell, SWT.NONE);
	
		button.setBounds(287, 58, 80, 27);
		button.setText("\u6DFB\u52A0");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(10, 108, 61, 17);
		label_3.setText("\u6DFB\u52A0\u6559\u5E08");
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(10, 100, 64, 2);
		
		Label label_5 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(74, 100, 64, 2);
		
		Label label_6 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_6.setBounds(132, 100, 64, 2);
		
		Label label_7 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_7.setBounds(190, 100, 64, 2);
		
		Label label_8 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setBounds(249, 100, 64, 2);
		
		Label label_9 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_9.setBounds(307, 100, 64, 2);
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(50, 131, 61, 17);
		label_10.setText("\u6559\u5E08\u59D3\u540D\uFF1A");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(117, 125, 88, 23);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(294, 125, 73, 23);
		
		Label label_11 = new Label(shell, SWT.NONE);
		label_11.setBounds(218, 131, 61, 17);
		label_11.setText("\u6559\u5E08\u7F16\u53F7\uFF1A");
		
		Label label_12 = new Label(shell, SWT.NONE);
		label_12.setBounds(50, 162, 61, 17);
		label_12.setText("\u6240\u5C5E\u9662\u7CFB\uFF1A");
		
		Label label_13 = new Label(shell, SWT.NONE);
		label_13.setBounds(220, 158, 33, 17);
		label_13.setText("\u6027\u522B");
		
		Label label_14 = new Label(shell, SWT.NONE);
		label_14.setBounds(49, 189, 61, 17);
		label_14.setText("\u51FA\u751F\u5E74\u6708\uFF1A");
		
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setBounds(270, 162, 33, 17);
		button_1.setText("\u7537");
		
		Button button_2 = new Button(shell, SWT.RADIO);
		button_2.setBounds(316, 162, 33, 17);
		button_2.setText("\u5973");
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(117, 154, 88, 25);
		
		Combo combo_1 = new Combo(shell, SWT.READ_ONLY);
		combo_1.setBounds(117, 281, 88, 25);
		
		Combo combo_2 = new Combo(shell, SWT.READ_ONLY);
		combo_2.setBounds(117, 398, 88, 25);
		int i=d;
		sql="select D_name from d";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		String [] items=new String[i];
		i=0;
		while(rs.next()) {
			items[i]=rs.getString("D_name");
			list.add(items[i]);
			//System.out.println(items[i]);
			i++;
		}
		combo.setItems(items);
		combo_1.setItems(items);
		combo_2.setItems(items);
		
		
		
		DateTime dateTime_2 = new DateTime(shell, SWT.BORDER);
		dateTime_2.setBounds(117, 182, 88, 24);
		
		Button button_3 = new Button(shell, SWT.NONE);
		
		button_3.setBounds(287, 189, 80, 27);
		button_3.setText("\u6DFB\u52A0");
		
		Label label_15 = new Label(shell, SWT.NONE);
		label_15.setBounds(10, 232, 61, 17);
		label_15.setText("\u6DFB\u52A0\u8BFE\u7A0B");
		
		Label label_16 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_16.setBounds(7, 224, 64, 2);
		
		Label label_17 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_17.setBounds(61, 224, 64, 2);
		
		Label label_18 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_18.setBounds(115, 224, 64, 2);
		
		Label label_19 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_19.setBounds(171, 224, 64, 2);
		
		Label label_20 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_20.setBounds(220, 224, 64, 2);
		
		Label label_21 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_21.setBounds(303, 224, 64, 2);
		
		Label label_22 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_22.setBounds(249, 224, 64, 2);
		
		Label label_23 = new Label(shell, SWT.NONE);
		label_23.setBounds(50, 261, 61, 17);
		label_23.setText("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		
		Label label_24 = new Label(shell, SWT.NONE);
		label_24.setBounds(50, 284, 61, 17);
		label_24.setText("\u5F00\u8BFE\u9662\u7CFB\uFF1A");
		
		Label label_25 = new Label(shell, SWT.NONE);
		label_25.setBounds(218, 261, 61, 17);
		label_25.setText("\u8BFE\u7A0B\u7F16\u53F7\uFF1A");
		
		Label label_26 = new Label(shell, SWT.NONE);
		label_26.setBounds(218, 284, 61, 17);
		label_26.setText("\u8BFE\u65F6\uFF1A");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(50, 318, 61, 17);
		lblNewLabel.setText("\u5B66\u5206\uFF1A");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(117, 255, 88, 23);
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(294, 255, 73, 23);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(294, 284, 73, 23);
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(117, 315, 88, 23);
		
		
		
		Button button_4 = new Button(shell, SWT.NONE);
		
		button_4.setBounds(287, 313, 80, 27);
		button_4.setText("\u6DFB\u52A0");
		
		Label label_27 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_27.setBounds(287, 346, 64, 2);
		
		Label label_28 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_28.setBounds(239, 346, 64, 2);
		
		Label label_29 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_29.setBounds(190, 346, 64, 2);
		
		Label label_30 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_30.setBounds(126, 346, 64, 2);
		
		Label label_31 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_31.setBounds(61, 346, 64, 2);
		
		Label label_32 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_32.setBounds(7, 346, 64, 2);
		
		Label label_33 = new Label(shell, SWT.NONE);
		label_33.setBounds(10, 354, 61, 17);
		label_33.setText("\u6DFB\u52A0\u5B66\u751F");
		
		Label label_34 = new Label(shell, SWT.NONE);
		label_34.setBounds(49, 377, 61, 17);
		label_34.setText("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		Label label_35 = new Label(shell, SWT.NONE);
		label_35.setBounds(218, 377, 32, 17);
		label_35.setText("\u5B66\u53F7\uFF1A");
		
		Label label_36 = new Label(shell, SWT.NONE);
		label_36.setBounds(218, 406, 43, 17);
		label_36.setText("\u6027\u522B\uFF1A");
		
		Button button_5 = new Button(shell, SWT.RADIO);
		button_5.setBounds(270, 406, 33, 17);
		button_5.setText("\u7537");
		
		Button button_6 = new Button(shell, SWT.RADIO);
		button_6.setBounds(316, 406, 33, 17);
		button_6.setText("\u5973");
		
		Label label_37 = new Label(shell, SWT.NONE);
		label_37.setBounds(50, 406, 61, 17);
		label_37.setText("\u6240\u5C5E\u9662\u7CFB\uFF1A");
		
		Label label_38 = new Label(shell, SWT.NONE);
		label_38.setBounds(50, 429, 61, 17);
		label_38.setText("\u73ED\u7EA7\uFF1A");
		
		Label label_39 = new Label(shell, SWT.NONE);
		label_39.setBounds(214, 438, 53, 17);
		label_39.setText("\u51FA\u751F\u5E74\u6708\uFF1A");
		
		Label label_40 = new Label(shell, SWT.NONE);
		label_40.setBounds(50, 496, 61, 17);
		label_40.setText("\u5165\u5B66\u5E74\u6708\uFF1A");
		
		Label label_41 = new Label(shell, SWT.NONE);
		label_41.setBounds(50, 462, 61, 17);
		label_41.setText("\u7C4D\u8D2F\uFF1A");
		
		
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(270, 431, 88, 24);
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(117, 489, 88, 24);
		
		
		
		Button button_7 = new Button(shell, SWT.NONE);
		
		button_7.setBounds(287, 486, 80, 27);
		button_7.setText("\u6DFB\u52A0");
		

		
		
		
		Button button_8 = new Button(shell, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					getCon().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//设置父窗口可用
				shell.setVisible(false);
				
				//parentShell.setEnabled(true);
				//getParentShell().setEnabled(true);
			}
		});
		button_8.setBounds(660, 486, 80, 27);
		button_8.setText("\u9000\u51FA");
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(117, 371, 88, 23);
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(117, 429, 88, 23);
		
		text_11 = new Text(shell, SWT.BORDER);
		text_11.setBounds(117, 461, 250, 23);
		
		
		
		
		
		
		
		
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(294, 371, 73, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(d==0) {
					text_1.setText("1001");
				}
				else {
					sql="select MAX(D_no) from d";
					try {
						rs=state.executeQuery(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//查询结果
					try {
						while(rs.next()) {
							//System.out.println("glsajdlsgjlasgj");
							
							
							
								text_1.setText(String.valueOf(Integer.valueOf(rs.getString("MAX(D_no)"))+1));
							
						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(211, 63, 33, 27);
		btnNewButton.setText("\u751F\u6210");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(t==0) {
					text_3.setText("2001");
				}
				else {
					sql="select MAX(T_no) from t";
					try {
						rs=state.executeQuery(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//查询结果
					try {
						while(rs.next()) {
							text_3.setText(String.valueOf(Integer.valueOf(rs.getString("MAX(T_no)"))+1));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(259, 105, 32, 22);
		btnNewButton_1.setText("\u751F\u6210");
		
		Button button_9 = new Button(shell, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(c==0) {
					text_6.setText("3001");
				}
				else {
					sql="select MAX(C_no) from c";
					try {
						rs=state.executeQuery(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//查询结果
					try {
						while(rs.next()) {
							text_6.setText(String.valueOf(Integer.valueOf(rs.getString("MAX(C_no)"))+1));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		button_9.setBounds(259, 232, 32, 23);
		button_9.setText("\u751F\u6210");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(s==0) {
					text_4.setText("2016001");
				}
				else {
					sql="select MAX(S_no) from s";
					try {
						rs=state.executeQuery(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//查询结果
					try {
						while(rs.next()) {
							text_4.setText(String.valueOf(Integer.valueOf(rs.getString("MAX(S_no)"))+1));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(251, 373, 33, 25);
		btnNewButton_2.setText("\u751F\u6210");
		
		Label label_42 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_42.setBounds(373, 10, 2, 64);
		
		Label label_43 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_43.setBounds(373, 68, 2, 64);
		
		Label label_44 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_44.setBounds(373, 131, 2, 64);
		
		Label label_45 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_45.setBounds(373, 189, 2, 64);
		
		Label label_46 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_46.setBounds(373, 255, 2, 64);
		
		Label label_47 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_47.setBounds(373, 318, 2, 64);
		
		Label label_48 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_48.setBounds(373, 377, 2, 64);
		
		Label label_49 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_49.setBounds(373, 438, 2, 64);
		
		Label label_50 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_50.setBounds(373, 482, 2, 64);
		
		//系别
		
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		
		tabFolder.setBounds(381, 10, 376, 467);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		
		tbtmNewItem.setText("\u7CFB\u522B\u5217\u8868");
		
		TableViewer tableViewer = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		tbtmNewItem.setControl(table);
		
		
		
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableColumn.setWidth(100);
		tableColumn.setText("\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u9662\u7CFB");
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		
		tabItem.setText("\u6559\u5E08\u5217\u8868");
		CellEditor[] cellEditors=new CellEditor[2];
		cellEditors[0]=null;//第一列不可编辑
		
		
		
		
		TableViewer tableViewer_1 = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		tabItem.setControl(table_1);
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
		tableColumn_2.setWidth(48);
		tableColumn_2.setText("\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_5 = tableViewerColumn_5.getColumn();
		tableColumn_5.setWidth(54);
		tableColumn_5.setText("\u59D3\u540D");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_6 = tableViewerColumn_6.getColumn();
		tableColumn_6.setWidth(39);
		tableColumn_6.setText("\u6027\u522B");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_4.getColumn();
		tableColumn_4.setWidth(75);
		tableColumn_4.setText("\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_20 = tableViewerColumn_7.getColumn();
		tableColumn_20.setWidth(95);
		tableColumn_20.setText("\u51FA\u751F\u5E74\u6708");
		
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		
		tabItem_1.setText("\u8BFE\u7A0B\u5217\u8868");
		
		TableViewer tableViewer_2 = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table_2 = tableViewer_2.getTable();
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		tabItem_1.setControl(table_2);
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_7 = tableViewerColumn_8.getColumn();
		tableColumn_7.setWidth(66);
		tableColumn_7.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_10 = tableViewerColumn_11.getColumn();
		tableColumn_10.setWidth(72);
		tableColumn_10.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_9 = tableViewerColumn_10.getColumn();
		tableColumn_9.setWidth(90);
		tableColumn_9.setText("\u5F00\u8BFE\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_12 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_11 = tableViewerColumn_12.getColumn();
		tableColumn_11.setWidth(40);
		tableColumn_11.setText("\u8BFE\u65F6");
		
		TableViewerColumn tableViewerColumn_13 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_21 = tableViewerColumn_13.getColumn();
		tableColumn_21.setWidth(38);
		tableColumn_21.setText("\u5B66\u5206");
		
		TabItem tabItem_2 = new TabItem(tabFolder, SWT.NONE);
		
		tabItem_2.setText("\u5B66\u751F\u5217\u8868");
		
		TableViewer tableViewer_3 = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table_3 = tableViewer_3.getTable();
		table_3.setLinesVisible(true);
		table_3.setHeaderVisible(true);
		tabItem_2.setControl(table_3);
		
		TableViewerColumn tableViewerColumn_22 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_22 = tableViewerColumn_22.getColumn();
		tableColumn_22.setWidth(61);
		tableColumn_22.setText("\u5B66\u53F7");
		
		TableViewerColumn tableViewerColumn_19 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_17 = tableViewerColumn_19.getColumn();
		tableColumn_17.setWidth(53);
		tableColumn_17.setText("\u59D3\u540D");
		
		TableViewerColumn tableViewerColumn_18 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_16 = tableViewerColumn_18.getColumn();
		tableColumn_16.setWidth(40);
		tableColumn_16.setText("\u6027\u522B");
		
		TableViewerColumn tableViewerColumn_20 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_18 = tableViewerColumn_20.getColumn();
		tableColumn_18.setWidth(81);
		tableColumn_18.setText("\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_17 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_15 = tableViewerColumn_17.getColumn();
		tableColumn_15.setWidth(43);
		tableColumn_15.setText("\u73ED\u7EA7");
		
		TableViewerColumn tableViewerColumn_16 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_14 = tableViewerColumn_16.getColumn();
		tableColumn_14.setWidth(81);
		tableColumn_14.setText("\u51FA\u751F\u65E5\u671F");
		
		TableViewerColumn tableViewerColumn_15 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_13 = tableViewerColumn_15.getColumn();
		tableColumn_13.setWidth(86);
		tableColumn_13.setText("\u5165\u5B66\u65E5\u671F");
		
		TableViewerColumn tableViewerColumn_14 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_12 = tableViewerColumn_14.getColumn();
		tableColumn_12.setWidth(362);
		tableColumn_12.setText("\u7C4D\u8D2F");
		
		
		
		
		
		
		
		
		//系别
		List<Dept> listdept=new ArrayList<Dept>();
		sql="select D_no,D_name from d";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		while(rs.next()) {
			Dept de=new Dept(rs.getString("D_no"),rs.getString("D_name"));
			listdept.add(de);
		}
		//设定内容器和标签器
		tableViewer.setContentProvider(new TableViewContentProvider());
		tableViewer.setLabelProvider(new TableViewerLabelProvider());
		tableViewer.setInput(listdept);
		
		//教师
		List<GetTeacher> listtea=new ArrayList<GetTeacher>();
		sql="select T_no,T_name,T_sex,D_name,T_birth from t "
				+ "join d on d.D_no=t.D_no";
		
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		
		while(rs.next()) {
			GetTeacher te=new GetTeacher(rs.getString("T_no"),rs.getString("T_name"),rs.getString("T_sex"),rs.getString("D_name"),rs.getString("T_birth"));
			listtea.add(te);
		}
		tableViewer_1.setContentProvider(new TableViewContentProvider());
		tableViewer_1.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_1.setInput(listtea);
		
		
		
		
		
		
		
		//课程
		List<GetCourse> listcou=new ArrayList<GetCourse>();
		sql="select C_no,C_name,D_name,C_time,C_credit from c "
				+ "join d on d.D_no=c.D_no";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		
		while(rs.next()) {
			GetCourse co=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
			listcou.add(co);
		}
		tableViewer_2.setContentProvider(new TableViewContentProvider());
		tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_2.setInput(listcou);
		
		
		
		
		//学生
		List<GetStudent> liststu=new ArrayList<GetStudent>();
		sql="select S_no,S_name,S_sex,S_class,D_name,S_birth,S_entr,S_home from s "
				+ "join d on d.D_no=s.D_no";
		pr=(PreparedStatement) getCon().prepareStatement(sql);
		rs=pr.executeQuery();
		
		while(rs.next()) {
			GetStudent st=new GetStudent(rs.getString("S_no"),rs.getString("S_name"),rs.getString("S_sex"),(rs.getString("D_name")),Integer.valueOf(rs.getString("S_class")),rs.getString("S_birth"),rs.getString("S_entr"),rs.getString("S_home"));
			liststu.add(st);
		}
		
		
		//设定内容器和标签器
		tableViewer_3.setContentProvider(new TableViewContentProvider());
		tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_3.setInput(liststu);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sql="insert into d (D_no,D_name) "
						+ "values (?,?)";
				try {
					preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
					preparedStatement.setString(1, text_1.getText());
					preparedStatement.setString(2, text.getText());
					
					preparedStatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sql="select count(*) from d";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						label_51.setText("共 "+rs.getString("count(*)")+" 条记录");
						d=Integer.valueOf(rs.getString("count(*)"));
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text.setText("");
				text_1.setText("");
				
				int i=d;
				sql="select D_name from d";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String [] items=new String[i];
				i=0;
				try {
					while(rs.next()) {
						items[i]=rs.getString("D_name");
						list.add(items[i]);
						//System.out.println(items[i]);
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				combo.setItems(items);
				combo_1.setItems(items);
				combo_2.setItems(items);
				
				//系别
				List<Dept> listdept=new ArrayList<Dept>();
				sql="select D_no,D_name from d";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						Dept de=new Dept(rs.getString("D_no"),rs.getString("D_name"));
						listdept.add(de);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//设定内容器和标签器
				tableViewer.setContentProvider(new TableViewContentProvider());
				tableViewer.setLabelProvider(new TableViewerLabelProvider());
				tableViewer.setInput(listdept);
			}
		});
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				sql=" insert into t (T_no,D_no,T_name,T_sex,T_birth) "
						+ "values (?,?,?,?,?);";
				try {
					preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
					//教师编号
					preparedStatement.setString(1, text_3.getText());
					System.out.println(text_3.getText());
					
					//院系编号
					
					System.out.println(combo.getText());
					//String sqql="select D_no from d where D_name='信软学院'";//+combo.getText();
					String sqql="select D_no from d where D_name='"
							+ String.valueOf(combo.getText())+"';";
					System.out.println(sqql);
					pr=(PreparedStatement) getCon().prepareStatement(sqql);
					rs=pr.executeQuery();
					while(rs.next()) {
						preparedStatement.setString(2, rs.getString("D_no"));
					}
					//preparedStatement.setString(2, String.valueOf(1001+list.indexOf(combo.getText())));//换算成学院代码
					
					//姓名
					preparedStatement.setString(3, text_2.getText());
					System.out.println(text_2.getText());
					//性别
					if(button_1.getSelection()) {
						preparedStatement.setString(4, button_1.getText());
					}
					else if(button_2.getSelection()) {
						preparedStatement.setString(4, button_2.getText());
					}
					System.out.println(button_2.getText());
					//出生日期
					preparedStatement.setString(5, String.valueOf(dateTime_2.getYear())+"/"+String.valueOf(dateTime_2.getMonth())+"/"+String.valueOf(dateTime_2.getDay()));
					System.out.println(String.valueOf(dateTime_2.getYear())+"/"+String.valueOf(dateTime_2.getMonth())+"/"+String.valueOf(dateTime_2.getDay()));
					
					
					preparedStatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_3.setText("");
				text_2.setText("");
				sql="select count(*) from t";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					while(rs.next()) {
						label_52.setText("共 "+rs.getString("count(*)")+" 条记录");
						t=Integer.valueOf(rs.getString("count(*)"));
					}
				} catch (NumberFormatException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//教师
				List<GetTeacher> listtea=new ArrayList<GetTeacher>();
				sql="select T_no,T_name,T_sex,D_name,T_birth from t "
						+ "join d on d.D_no=t.D_no";
				
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					while(rs.next()) {
						GetTeacher te=new GetTeacher(rs.getString("T_no"),rs.getString("T_name"),rs.getString("T_sex"),rs.getString("D_name"),rs.getString("T_birth"));
						listtea.add(te);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableViewer_1.setContentProvider(new TableViewContentProvider());
				tableViewer_1.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_1.setInput(listtea);
				
				sql="select count(*) from t";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						label_52.setText("共 "+rs.getString("count(*)")+" 条记录");
						t=Integer.valueOf(rs.getString("count(*)"));
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sql=" insert into c (C_no,D_no,C_name,C_time,C_credit) "
						+ "values (?,?,?,?,?);";
				try {
					preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
					
					preparedStatement.setString(1, text_6.getText());
					System.out.println(text_6.getText());
					
					String sqql="select D_no from d where D_name='"
							+ String.valueOf(combo_1.getText())+"';";
					System.out.println(sqql);
					pr=(PreparedStatement) getCon().prepareStatement(sqql);
					rs=pr.executeQuery();
					while(rs.next()) {
						preparedStatement.setString(2, rs.getString("D_no"));
						System.out.println(rs.getString("D_no"));
					}
					
					//preparedStatement.setString(2, String.valueOf(1001+list.indexOf(combo_1.getText())));//换算成学院代码
					
					preparedStatement.setString(3, text_5.getText());
					System.out.println(text_5.getText());

					
					preparedStatement.setString(4, text_7.getText());
					System.out.println(text_7.getText());
	
					preparedStatement.setString(5, text_8.getText());
					System.out.println(text_8.getText());
					
					
					preparedStatement.executeUpdate();
					System.out.println("error!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_5.setText("");
				text_7.setText("");
				text_8.setText("");
				text_6.setText("");
				
				
				sql="select count(*) from c";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						label_53.setText("共 "+rs.getString("count(*)")+" 条记录");
						c=Integer.valueOf(rs.getString("count(*)"));
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//课程
				List<GetCourse> listcou=new ArrayList<GetCourse>();
				sql="select C_no,C_name,D_name,C_time,C_credit from c "
						+ "join d on d.D_no=c.D_no";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					while(rs.next()) {
						GetCourse co=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
						listcou.add(co);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableViewer_2.setContentProvider(new TableViewContentProvider());
				tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_2.setInput(listcou);
			}
		});
		
		
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sql="insert into s (S_no,D_no,S_name,S_sex,S_class,S_birth,S_entr,S_home) "
						+ "values (?,?,?,?,?,?,?,?)";
				try {
					preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
					preparedStatement.setString(1, text_4.getText());
					System.out.println(text_4.getText());
					
					String sqql="select D_no from d where D_name='"
							+ String.valueOf(combo_2.getText())+"';";
					System.out.println(sqql);
					pr=(PreparedStatement) getCon().prepareStatement(sqql);
					rs=pr.executeQuery();
					while(rs.next()) {
						preparedStatement.setString(2, rs.getString("D_no"));
						System.out.println(rs.getString("D_no"));
					}
					
						
					//preparedStatement.setString(2, String.valueOf(1001+list.indexOf(combo_2.getText())));//换算成学院代码
					
					
					
					preparedStatement.setString(3, text_9.getText());
					System.out.println(text_9.getText());
					//性别
					if(button_5.getSelection()) {
						preparedStatement.setString(4, button_5.getText());
						System.out.println(button_5.getText());
					}
					
					else if(button_6.getSelection()) {
						preparedStatement.setString(4, button_6.getText());
						System.out.println(button_6.getText());
					}
						
					preparedStatement.setString(5, text_10.getText());
					System.out.println(text_10.getText());
					preparedStatement.setString(6, String.valueOf(dateTime.getYear())+"/"+String.valueOf(dateTime.getMonth())+"/"+String.valueOf(dateTime.getDay()));
					System.out.println(String.valueOf(dateTime.getYear())+"/"+String.valueOf(dateTime.getMonth())+"/"+String.valueOf(dateTime.getDay()));
					
					preparedStatement.setString(7, String.valueOf(dateTime_1.getYear())+"/"+String.valueOf(dateTime_1.getMonth())+"/"+String.valueOf(dateTime_1.getDay()));
					System.out.println(String.valueOf(dateTime_1.getYear())+"/"+String.valueOf(dateTime_1.getMonth())+"/"+String.valueOf(dateTime_1.getDay()));
					preparedStatement.setString(8, text_11.getText());
					System.out.println(text_11.getText());
					
					//有问题
					preparedStatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_11.setText("");
				text_4.setText("");
				text_10.setText("");
				text_9.setText("");
				
				sql="select count(*) from s";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()) {
						label_54.setText("共 "+rs.getString("count(*)")+" 条记录");
						s=Integer.valueOf(rs.getString("count(*)"));
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//学生
				List<GetStudent> liststu=new ArrayList<GetStudent>();
				sql="select S_no,S_name,S_sex,S_class,D_name,S_birth,S_entr,S_home from s "
						+ "join d on d.D_no=s.D_no";
				try {
					pr=(PreparedStatement) getCon().prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs=pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					while(rs.next()) {
						GetStudent st=new GetStudent(rs.getString("S_no"),rs.getString("S_name"),rs.getString("S_sex"),(rs.getString("D_name")),Integer.valueOf(rs.getString("S_class")),rs.getString("S_birth"),rs.getString("S_entr"),rs.getString("S_home"));
						liststu.add(st);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//设定内容器和标签器
				tableViewer_3.setContentProvider(new TableViewContentProvider());
				tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_3.setInput(liststu);
			}
		});
		
		
		//刷新数据类
		
		
		tbtmNewItem.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				//系别
				tableColumn.setText("ngskfg");
				System.out.println("系别表出现");
				
			}
		});
		
		tabItem.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				//教师
				
			}
		});
		
		tabItem_1.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				//课程
				
				
			}
		});
		
		tabItem_2.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				//学生
				
				
			}
		});
		
		//修改系别
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				AlterDept alterDept=new AlterDept(shell);
				alterDept.setNo(table.getItem(table.getSelectionIndex()).getText(0));
				alterDept.setName(table.getItem(table.getSelectionIndex()).getText(1));
				
				
				alterDept.open();
				
				setUpdate(alterDept.isUp()); 
				if(isUpdate()) {
					System.out.println("可以更新");
				}
				
				//修改后更新表
				
				//在此处更新语句
				System.out.println("更新");
				if(isUpdate()) {
					if(alterDept.isSelection()) {
						System.out.println("勾选删除");
						sql="delete from d where D_no='"
								+ alterDept.getNo()+"';";
						try {
							pr.executeUpdate(sql);
							System.out.println("删除成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//更新数据
						//系别
						List<Dept> listdept=new ArrayList<Dept>();
						sql="select D_no,D_name from d";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							while(rs.next()) {
								Dept de=new Dept(rs.getString("D_no"),rs.getString("D_name"));
								listdept.add(de);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//设定内容器和标签器
						tableViewer.setContentProvider(new TableViewContentProvider());
						tableViewer.setLabelProvider(new TableViewerLabelProvider());
						tableViewer.setInput(listdept);
						
					}
					else {
						System.out.println("未勾选删除");
						//更新操作
						sql="update d set D_name='"
								+ alterDept.getName()+"' where "
										+ "D_no='"
										+ alterDept.getNo()+"';";
						
						try {
							pr.executeUpdate(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						//更新数据
						//系别
						List<Dept> listdept=new ArrayList<Dept>();
						sql="select D_no,D_name from d";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							while(rs.next()) {
								Dept de=new Dept(rs.getString("D_no"),rs.getString("D_name"));
								listdept.add(de);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//设定内容器和标签器
						tableViewer.setContentProvider(new TableViewContentProvider());
						tableViewer.setLabelProvider(new TableViewerLabelProvider());
						tableViewer.setInput(listdept);
					}
				}
			
			}
		});
		//教师
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				AlterTeacher alterTeacher=new AlterTeacher(shell);
				alterTeacher.setNo(table_1.getItem(table_1.getSelectionIndex()).getText(0));
				alterTeacher.setName(table_1.getItem(table_1.getSelectionIndex()).getText(1));
				alterTeacher.setSex(table_1.getItem(table_1.getSelectionIndex()).getText(2));
				alterTeacher.setBirth(table_1.getItem(table_1.getSelectionIndex()).getText(4));
				
				alterTeacher.open();
				
				
				
				
				//修改后更新表
				
				//在此处更新语句
				setUpdate(alterTeacher.isUp());
				if(isUpdate()) {
					if(alterTeacher.isSelection()) {
						//删除
						sql="delete from t where T_no='"
								+ alterTeacher.getNo()+"';";
						try {
							pr.executeUpdate(sql);
							System.out.println("删除成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//更新数据
						//教师
						List<GetTeacher> listtea=new ArrayList<GetTeacher>();
						sql="select T_no,T_name,T_sex,D_name,T_birth from t "
								+ "join d on d.D_no=t.D_no";
						
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetTeacher te=new GetTeacher(rs.getString("T_no"),rs.getString("T_name"),rs.getString("T_sex"),rs.getString("D_name"),rs.getString("T_birth"));
								listtea.add(te);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tableViewer_1.setContentProvider(new TableViewContentProvider());
						tableViewer_1.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_1.setInput(listtea);
					}
					else {
						//更新
						
						try {
							sql="update t set T_name='"+alterTeacher.getName()+"' where T_no='"+alterTeacher.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update t set T_sex='"+alterTeacher.getSex()+"' where T_no='"+alterTeacher.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update t set T_birth='"+alterTeacher.getBirth()+"' where T_no='"+alterTeacher.getNo()+"';";
							pr.executeUpdate(sql);
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						//更新数据
						//教师
						List<GetTeacher> listtea=new ArrayList<GetTeacher>();
						sql="select T_no,T_name,T_sex,D_name,T_birth from t "
								+ "join d on d.D_no=t.D_no";
						
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetTeacher te=new GetTeacher(rs.getString("T_no"),rs.getString("T_name"),rs.getString("T_sex"),rs.getString("D_name"),rs.getString("T_birth"));
								listtea.add(te);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tableViewer_1.setContentProvider(new TableViewContentProvider());
						tableViewer_1.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_1.setInput(listtea);
						
					}
				}
			}
		});
		//课程
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				AlterCourse alterCourse=new AlterCourse(shell);
				alterCourse.setNo(table_2.getItem(table_2.getSelectionIndex()).getText(0));
				alterCourse.setName(table_2.getItem(table_2.getSelectionIndex()).getText(1));
				alterCourse.setCtime(Integer.valueOf(table_2.getItem(table_2.getSelectionIndex()).getText(3)));
				alterCourse.setCredit(Integer.valueOf(table_2.getItem(table_2.getSelectionIndex()).getText(4)));
				alterCourse.open();
				
				
				
				
				//修改后更新表
				
				//在此处更新语句
				setUpdate(alterCourse.isUp());
				if(isUpdate()) {
					if(alterCourse.isSelection()) {
						//删除
						sql="delete from c where C_no='"
								+ alterCourse.getNo()+"';";
						try {
							pr.executeUpdate(sql);
							System.out.println("删除成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//更新数据
						//课程
						List<GetCourse> listcou=new ArrayList<GetCourse>();
						sql="select C_no,C_name,D_name,C_time,C_credit from c "
								+ "join d on d.D_no=c.D_no";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetCourse co=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
								listcou.add(co);
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tableViewer_2.setContentProvider(new TableViewContentProvider());
						tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_2.setInput(listcou);
					}
					else {
						//更新
						
						try {
							sql="update c set C_name='"+alterCourse.getName()+"' where C_no='"+alterCourse.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update c set C_time='"+Integer.valueOf(alterCourse.getCtime())+"' where C_no='"+alterCourse.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update c set C_credit='"+Integer.valueOf(alterCourse.getCredit())+"' where C_no='"+alterCourse.getNo()+"';";
							pr.executeUpdate(sql);
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						//
						//课程
						List<GetCourse> listcou=new ArrayList<GetCourse>();
						sql="select C_no,C_name,D_name,C_time,C_credit from c "
								+ "join d on d.D_no=c.D_no";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetCourse co=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
								listcou.add(co);
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tableViewer_2.setContentProvider(new TableViewContentProvider());
						tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_2.setInput(listcou);
					}
				}
			}
		});
		//学生
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				AlterStudent alterStudent=new AlterStudent(shell);
				alterStudent.setNo(table_3.getItem(table_3.getSelectionIndex()).getText(0));
				alterStudent.setName(table_3.getItem(table_3.getSelectionIndex()).getText(1));
				
				alterStudent.setSex(table_3.getItem(table_3.getSelectionIndex()).getText(2));
				alterStudent.setSclass(Integer.valueOf(table_3.getItem(table_3.getSelectionIndex()).getText(4)));
				alterStudent.setBirth(table_3.getItem(table_3.getSelectionIndex()).getText(5));
				alterStudent.setEntr(table_3.getItem(table_3.getSelectionIndex()).getText(6));
				alterStudent.setHome(table_3.getItem(table_3.getSelectionIndex()).getText(7));
				
				alterStudent.open();
				//修改后更新表
				
				//在此处更新语句
				setUpdate(alterStudent.isUp());
				if(isUpdate()) {
					if(alterStudent.isSelection()) {
						//删除
						sql="delete from s where S_no='"
								+ alterStudent.getNo()+"';";
						try {
							pr.executeUpdate(sql);
							System.out.println("删除成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//更新数据
						//学生
						List<GetStudent> liststu=new ArrayList<GetStudent>();
						sql="select S_no,S_name,S_sex,S_class,D_name,S_birth,S_entr,S_home from s "
								+ "join d on d.D_no=s.D_no";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetStudent st=new GetStudent(rs.getString("S_no"),rs.getString("S_name"),rs.getString("S_sex"),(rs.getString("D_name")),Integer.valueOf(rs.getString("S_class")),rs.getString("S_birth"),rs.getString("S_entr"),rs.getString("S_home"));
								liststu.add(st);
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//设定内容器和标签器
						tableViewer_3.setContentProvider(new TableViewContentProvider());
						tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_3.setInput(liststu);
					}
					else {
						
						//更新
						/*
						sql="update s set S_name='"+alterStudent.getName()+"' "
								+ "S_sex='"+alterStudent.getSex()+"' "
								+ "S_class="+Integer.valueOf(alterStudent.getSclass())+" "
								+ "S_birth='"+alterStudent.getBirth()+"' "
								+ "S_entr='"+alterStudent.getEntr()+"' "
								+ "S_home='"+alterStudent.getHome()+"' "
								+ "where S_no='"+alterStudent.getNo()+"';";
						*/
						System.out.println(sql);
						try {
							sql="update s set S_name='"+alterStudent.getName()+"' where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update s set S_home='"+alterStudent.getHome()+"' where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update s set S_sex='"+alterStudent.getSex()+"' where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
							//以上三个可以
							
							sql="update s set S_birth='"+alterStudent.getBirth()+"' where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
							sql="update s set S_entr='"+alterStudent.getEntr()+"' where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
							//以上两个可以
							
							sql="update s set S_class="+Integer.valueOf(alterStudent.getSclass())+" where S_no='"+alterStudent.getNo()+"';";
							pr.executeUpdate(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//更新数据
						//学生
						List<GetStudent> liststu=new ArrayList<GetStudent>();
						sql="select S_no,S_name,S_sex,S_class,D_name,S_birth,S_entr,S_home from s "
								+ "join d on d.D_no=s.D_no";
						try {
							pr=(PreparedStatement) getCon().prepareStatement(sql);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs=pr.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							while(rs.next()) {
								GetStudent st=new GetStudent(rs.getString("S_no"),rs.getString("S_name"),rs.getString("S_sex"),(rs.getString("D_name")),Integer.valueOf(rs.getString("S_class")),rs.getString("S_birth"),rs.getString("S_entr"),rs.getString("S_home"));
								liststu.add(st);
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//设定内容器和标签器
						tableViewer_3.setContentProvider(new TableViewContentProvider());
						tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
						tableViewer_3.setInput(liststu);
					}
				}
			}
		});
		//end
	}



	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Shell getParentShell() {
		return parentShell;
	}

	public void setParentShell(Shell parentShell) {
		this.parentShell = parentShell;
	}

	

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getState() {
		return state;
	}

	public void setState(Statement state) {
		this.state = state;
	}

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}


