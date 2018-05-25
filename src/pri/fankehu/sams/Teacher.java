package pri.fankehu.sams;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Teacher {

	private Connection con;//连接
	protected Shell shell;
	private String Tea_no;
	private Statement state=null;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private String sql;
	private ResultSet rs;//查询结果
	private Table table;
	private Table table_1;
	private Text text_5;
	private Table table_2;
	private PreparedStatement pr=null;
	private PreparedStatement preparedStatement;
	private Table table_3;
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
		shell.setText("教师 -"+getTea_no());
		setState((Statement) getCon().createStatement());
		shell.setLayout(null);
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		

		
		tabFolder.setBounds(10, 10, 448, 450);
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				
			}
		});
		tabItem.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tabItem.setControl(composite);
		composite.setLayout(null);
		
		Label label = new Label(composite, SWT.NONE);
		label.setBounds(56, 68, 61, 17);
		label.setText("\u6559\u804C\u5DE5\u53F7");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(149, 68, 200, 23);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(56, 115, 61, 17);
		label_1.setText("\u59D3      \u540D");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(149, 109, 200, 23);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(56, 158, 61, 17);
		label_2.setText("\u6027      \u522B");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(149, 152, 200, 23);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBounds(56, 207, 61, 17);
		label_3.setText("\u51FA\u751F\u65E5\u671F");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(149, 201, 200, 23);
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setBounds(56, 261, 61, 17);
		label_4.setText("\u6240\u5C5E\u9662\u7CFB");
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(149, 255, 200, 23);
		
		
		//打开查询个人信息
		sql="select T_no,T_name,T_sex,D_name,T_birth from t "
				+ "join d on d.D_no=t.D_no where "
				+ "T_no='"+getTea_no()+"';";
		
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
				//GetTeacher te=new GetTeacher(rs.getString("T_no"),rs.getString("T_name"),rs.getString("T_sex"),rs.getString("D_name"),rs.getString("T_birth"));
				text.setText(rs.getString("T_no"));
				text_1.setText(rs.getString("T_name"));
				text_2.setText(rs.getString("T_sex"));
				text_3.setText(rs.getString("T_birth"));
				text_4.setText(rs.getString("D_name"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("\u6388\u8BFE\u4FE1\u606F");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tabItem_1.setControl(composite_1);
		composite_1.setLayout(null);
		
		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setBounds(10, 10, 61, 17);
		label_6.setText("\u6240\u6388\u8BFE\u7A0B");
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		table.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		table.setBounds(10, 33, 420, 69);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableColumn.setWidth(72);
		tableColumn.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
		tableColumn_1.setWidth(80);
		tableColumn_1.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
		tableColumn_2.setWidth(88);
		tableColumn_2.setText("\u5F00\u8BFE\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_3 = tableViewerColumn_3.getColumn();
		tableColumn_3.setWidth(41);
		tableColumn_3.setText("\u5B66\u65F6");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_4.getColumn();
		tableColumn_4.setWidth(38);
		tableColumn_4.setText("\u5B66\u5206");
		
		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setBounds(10, 126, 61, 17);
		label_7.setText("\u5168\u6821\u8BFE\u7A0B");
		
		TableViewer tableViewer_1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		
		
		table_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		table_1.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 149, 420, 261);
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_5 = tableViewerColumn_5.getColumn();
		tableColumn_5.setWidth(70);
		tableColumn_5.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_6 = tableViewerColumn_6.getColumn();
		tableColumn_6.setWidth(82);
		tableColumn_6.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_7 = tableViewerColumn_7.getColumn();
		tableColumn_7.setWidth(87);
		tableColumn_7.setText("\u5F00\u8BFE\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_8 = tableViewerColumn_8.getColumn();
		tableColumn_8.setWidth(40);
		tableColumn_8.setText("\u5B66\u65F6");
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_9 = tableViewerColumn_9.getColumn();
		tableColumn_9.setWidth(40);
		tableColumn_9.setText("\u5B66\u5206");
		
		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.addControlListener(new ControlAdapter() {
			@Override
			public void controlMoved(ControlEvent e) {
				
				System.out.println("选择");
			}
		});
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		Label label_17 = new Label(composite_1, SWT.NONE);
		label_17.setBounds(124, 126, 88, 17);
		label_17.setText("\u6CE8\uFF1A\u53CC\u51FB\u9009\u62E9");
		
		Label label_18 = new Label(composite_1, SWT.NONE);
		label_18.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_18.setBounds(234, 126, 196, 17);
		
		Label label_19 = new Label(composite_1, SWT.NONE);
		label_19.setBounds(124, 10, 86, 17);
		label_19.setText("\u6CE8\uFF1A\u53CC\u51FB\u5220\u9664");
		
		
		
		
		
		
		TabItem tabItem_2 = new TabItem(tabFolder, SWT.NONE);
		tabItem_2.setText("\u6211\u7684\u5B66\u751F");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tabItem_2.setControl(composite_2);
		composite_2.setLayout(null);
		
		Label label_8 = new Label(composite_2, SWT.NONE);
		label_8.setBounds(216, 23, 61, 17);
		label_8.setText("\u5B66        \u53F7\uFF1A");
		
		Label label_9 = new Label(composite_2, SWT.NONE);
		label_9.setBounds(290, 23, 138, 17);
		
		Label label_10 = new Label(composite_2, SWT.NONE);
		label_10.setBounds(217, 71, 61, 17);
		label_10.setText("\u59D3        \u540D\uFF1A");
		
		Label label_11 = new Label(composite_2, SWT.NONE);
		label_11.setBounds(288, 72, 142, 17);
		
		Label label_12 = new Label(composite_2, SWT.NONE);
		label_12.setBounds(215, 125, 61, 17);
		label_12.setText("\u79D1        \u76EE\uFF1A");
		
		Label label_13 = new Label(composite_2, SWT.NONE);
		label_13.setBounds(292, 126, 138, 17);
		
		Label label_14 = new Label(composite_2, SWT.NONE);
		label_14.setBounds(215, 232, 61, 17);
		label_14.setText("\u6210        \u7EE9\uFF1A");
		
		text_5 = new Text(composite_2, SWT.BORDER);
		text_5.setBounds(289, 226, 71, 23);
		
		TableViewer tableViewer_2 = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_2 = tableViewer_2.getTable();
		
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(10, 7, 194, 364);
		
		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_10 = tableViewerColumn_10.getColumn();
		tableColumn_10.setWidth(58);
		tableColumn_10.setText("\u5B66\u53F7");
		
		TableViewerColumn tableViewerColumn_13 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_13 = tableViewerColumn_13.getColumn();
		tableColumn_13.setWidth(57);
		tableColumn_13.setText("\u59D3\u540D");
		
		TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_11 = tableViewerColumn_11.getColumn();
		tableColumn_11.setWidth(42);
		tableColumn_11.setText("\u6027\u522B");
		
		TableViewerColumn tableViewerColumn_14 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_14 = tableViewerColumn_14.getColumn();
		tableColumn_14.setWidth(43);
		tableColumn_14.setText("\u5206\u6570");
		
		Button button_1 = new Button(composite_2, SWT.NONE);
		
		button_1.setBounds(347, 272, 80, 27);
		button_1.setText("\u786E\u8BA4");
		
		Label label_15 = new Label(composite_2, SWT.NONE);
		label_15.setBounds(215, 176, 61, 17);
		label_15.setText("\u5B66        \u9662\uFF1A");
		
		Label label_16 = new Label(composite_2, SWT.NONE);
		label_16.setBounds(285, 175, 155, 17);
		
		Label label_5 = new Label(composite_2, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_5.setBounds(216, 277, 112, 17);
		
		//统计人数
		sql="select count(sc.S_no) from sc "
				
				+ "where C_no=(select C_no from tc where "
				+ "T_no='"+getTea_no()+"')";
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
		
		
			while(rs.next()) {
				label_5.setText("当前选课人数： "+rs.getString("count(sc.S_no)"));

				
			}
		
		TabItem tabItem_4 = new TabItem(tabFolder, SWT.NONE);
		tabItem_4.setText("\u6210\u7EE9\u6392\u540D");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tabItem_4.setControl(composite_3);
		
		Label lblNewLabel = new Label(composite_3, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 61, 17);
		lblNewLabel.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		Label label_20 = new Label(composite_3, SWT.NONE);
		label_20.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_20.setBounds(77, 10, 353, 17);
		
		Label label_21 = new Label(composite_3, SWT.NONE);
		label_21.setBounds(10, 33, 61, 17);
		label_21.setText("\u5E73 \u5747  \u5206");
		
		Label lblNewLabel_1 = new Label(composite_3, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setBounds(77, 33, 61, 17);
		
		TableViewer tableViewer_3 = new TableViewer(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_3 = tableViewer_3.getTable();
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		table_3.setBounds(10, 99, 420, 311);
		
		TableViewerColumn tableViewerColumn_12 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_12 = tableViewerColumn_12.getColumn();
		tableColumn_12.setWidth(100);
		tableColumn_12.setText("\u5B66\u53F7");
		
		TableViewerColumn tableViewerColumn_15 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_15 = tableViewerColumn_15.getColumn();
		tableColumn_15.setWidth(100);
		tableColumn_15.setText("\u59D3\u540D");
		
		TableViewerColumn tableViewerColumn_16 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_16 = tableViewerColumn_16.getColumn();
		tableColumn_16.setWidth(100);
		tableColumn_16.setText("\u5206\u6570");
		
		TableViewerColumn tableViewerColumn_17 = new TableViewerColumn(tableViewer_3, SWT.NONE);
		TableColumn tableColumn_17 = tableViewerColumn_17.getColumn();
		tableColumn_17.setWidth(100);
		tableColumn_17.setText("\u6392\u540D");
		
		//默认查询课程，全校课程
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
		tableViewer_1.setContentProvider(new TableViewContentProvider());
		tableViewer_1.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_1.setInput(listcou);
				
		//T-课程   每个教师只能教授一门课
		List<GetCourse> listct=new ArrayList<GetCourse>();
		/*
		sql="select C_no,C_name,D_name,C_time,C_credit from c "
				+ "join d on d.D_no=c.D_no ";*/
		sql="select tc.C_no,c.C_name,d.D_name,C_time,C_credit from tc "
				+ "join c on c.C_no=tc.C_no "
				+ "join d on d.D_no=(select c.D_no from c where c.C_no=(select C_no from tc where T_no='"+getTea_no()+"'))  "
				+ "where tc.T_no='"
				+ getTea_no()+"';";
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
				listct.add(co);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		tableViewer.setContentProvider(new TableViewContentProvider());
		tableViewer.setLabelProvider(new TableViewerLabelProvider());
		tableViewer.setInput(listct);
				
		
		
		//我的学生
		
		List<Getsct> liststus=new ArrayList<Getsct>();
		sql="select sc.S_no,S_name,S_sex,score from sc "
				+ "join s on s.S_no=sc.S_no "
				+ "where C_no=(select C_no from tc where "
				+ "T_no='"+getTea_no()+"')";
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
		
		
			while(rs.next()) {
				System.out.println(rs.getString("sc.S_no"));
				System.out.println(rs.getString("S_name"));
				System.out.println(rs.getString("S_sex"));
				System.out.println(rs.getString("score"));
				
				
				//Getsct sts=new Getsct(rs.getString("sc.S_no"),rs.getString("S_name"),rs.getString("S_sex"),Integer.valueOf((rs.getString("score"))));
				Getsct sts=new Getsct();
				sts.setNo(rs.getString("sc.S_no"));
				sts.setName(rs.getString("S_name"));
				sts.setSex(rs.getString("S_sex"));
				sts.setScore(((rs.getString("score"))));
				liststus.add(sts);
			}
		
		tableViewer_2.setContentProvider(new TableViewContentProvider());
		tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_2.setInput(liststus);
		
		table_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(table_1.getSelectionIndex());
			}
		});
		//我的学生单击
		table_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table_2.getSelectionIndex();
				System.out.println(table_2.getSelectionIndex());
				table_2.getSelection();
				System.out.println(table_2.getSelection());
				table_2.getItem(table_2.getSelectionIndex());
				System.out.println(table_2.getItem(table_2.getSelectionIndex()).getText(1));
				
				label_9.setText(table_2.getItem(table_2.getSelectionIndex()).getText(0));
				label_11.setText(table_2.getItem(table_2.getSelectionIndex()).getText(1));
				
				//每个老师只能选授一门课
				sql="select C_name from c join tc on tc.C_no=c.C_no "
						+ " where "
						+ "T_no='"+getTea_no()+"';";
				
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
						
						label_13.setText(rs.getString("C_name"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sql="select D_name from s join d on d.D_no=s.D_no "
						+ " where "
						+ "S_no='"+table_2.getItem(table_2.getSelectionIndex()).getText(0)+"';";
				
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
						label_16.setText(rs.getString("D_name"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//label_13
				text_5.setText(table_2.getItem(table_2.getSelectionIndex()).getText(3));
			}
		});
		
		
		//全校课程  双击添加选课  
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				System.out.println("双击 "+table_1.getSelectionIndex());
				/**
				 * 双击检查课程是否在TC表中存在，是拒绝选择 ，否添加选课，一个教师只能一门课
				 */
				table_1.getItem(table_1.getSelectionIndex()).getText(0);
				System.out.println(table_1.getItem(table_1.getSelectionIndex()).getText(0));
				
				//检查教师选课数
				sql="select T_no from tc ";
				
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
				boolean Tselect=true;//代表可以选课
				try {
					while(rs.next()) {
						if(rs.getString("T_no").equals(getTea_no())) {
							System.out.println("选课数超出限制！");
							label_18.setText("您的选课数量超出限制！");
							Tselect=false;//不能在选课
							
							//弹框提示
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//检查是否有人选过
				sql="select count(C_no) from tc where C_no='"
						+table_1.getItem(table_1.getSelectionIndex()).getText(0) +"';";
				
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
				
				if(Tselect) {
					try {
						while(rs.next()) {
							if(Integer.valueOf(rs.getString("count(C_no)"))>0) {
								System.out.println("有人选过！");//已经备选
								label_18.setText("该课程已有人选！");
								Tselect=false;//不能在选课
								
								//弹框提示
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				//如果为true
				if(Tselect) {
					//将选择课程添加进tc表
					System.out.println("可以添加");
					sql="insert into tc "
							+ "values (?,?)";
					try {
						preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
						preparedStatement.setString(1, getTea_no());
						preparedStatement.setString(2, table_1.getItem(table_1.getSelectionIndex()).getText(0));
						
						preparedStatement.executeUpdate();
						label_18.setText("选课成功！");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//添加完更新选课表
					//T-课程   每个教师只能教授一门课
					List<GetCourse> listctnew=new ArrayList<GetCourse>();
					/*
					sql="select C_no,C_name,D_name,C_time,C_credit from c "
							+ "join d on d.D_no=c.D_no ";*/
					sql="select tc.C_no,c.C_name,d.D_name,C_time,C_credit from tc "
							+ "join c on c.C_no=tc.C_no "
							+ "join d on d.D_no=(select c.D_no from c where c.C_no=(select C_no from tc where T_no='"+getTea_no()+"'))  "
							+ "where tc.T_no='"
							+ getTea_no()+"';";
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
							GetCourse conew=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
							listctnew.add(conew);
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					tableViewer.setContentProvider(new TableViewContentProvider());
					tableViewer.setLabelProvider(new TableViewerLabelProvider());
					tableViewer.setInput(listctnew);
				}
				
			}
		});
		
		//教师选课 双击删除
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				sql="delete from tc where T_no='"
						+ getTea_no()+"';";
				try {
					pr.executeUpdate(sql);
					System.out.println("删除成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//删除后更新表
				//T-课程   每个教师只能教授一门课
				List<GetCourse> listctnew=new ArrayList<GetCourse>();
				/*
				sql="select C_no,C_name,D_name,C_time,C_credit from c "
						+ "join d on d.D_no=c.D_no ";*/
				sql="select tc.C_no,c.C_name,d.D_name,C_time,C_credit from tc "
						+ "join c on c.C_no=tc.C_no "
						+ "join d on d.D_no=(select c.D_no from c where c.C_no=(select C_no from tc where T_no='"+getTea_no()+"'))  "
						+ "where tc.T_no='"
						+ getTea_no()+"';";
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
						GetCourse conew=new GetCourse(rs.getString("C_no"),rs.getString("C_name"),rs.getString("D_name"),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
						listctnew.add(conew);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				tableViewer.setContentProvider(new TableViewContentProvider());
				tableViewer.setLabelProvider(new TableViewerLabelProvider());
				tableViewer.setInput(listctnew);
			}
		});
		
		//登记成绩按钮   点击 登记成绩 并更新我的学生
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sql="update sc set score="+Integer.valueOf(text_5.getText())+" where S_no='"+label_9.getText()+"' "
						+ "and C_no= (select C_no from tc where T_no='"
						+ getTea_no()+"')";
				try {
					pr.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//更新我的学生
				//我的学生
				
				List<Getsct> liststusne=new ArrayList<Getsct>();
				sql="select sc.S_no,S_name,S_sex,score from sc "
						+ "join s on s.S_no=sc.S_no "
						+ "where C_no=(select C_no from tc where "
						+ "T_no='"+getTea_no()+"')";
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
							System.out.println(rs.getString("sc.S_no"));
							System.out.println(rs.getString("S_name"));
							System.out.println(rs.getString("S_sex"));
							System.out.println(rs.getString("score"));
		
							Getsct sts=new Getsct();
							sts.setNo(rs.getString("sc.S_no"));
							sts.setName(rs.getString("S_name"));
							sts.setSex(rs.getString("S_sex"));
							sts.setScore(((rs.getString("score"))));
							liststusne.add(sts);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				tableViewer_2.setContentProvider(new TableViewContentProvider());
				tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_2.setInput(liststusne);
				
				//更新成绩排名
				//排名信息   注意在更新成绩按钮处添加排名更新
				//
				List<GetOrdFromView> liststusne1=new ArrayList<GetOrdFromView>();
				sql="select a.S_no,S_name,score,rand from cou_"+getTea_no()+" a "
						+ "join cou_"+getTea_no()+"_ord b on "
								+ "a.S_no=b.S_no "
								+ "order by score desc;";
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
							

							GetOrdFromView sts=new GetOrdFromView();
							sts.setNo(rs.getString("S_no"));
							sts.setName(rs.getString("S_name"));
							sts.setScore(Integer.valueOf((rs.getString("score"))));
							
							//有问题
							System.out.println(rs.getString("rand"));
							sts.setOrd(Integer.valueOf((rs.getString("rand"))));
							liststusne1.add(sts);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				tableViewer_3.setContentProvider(new TableViewContentProvider());
				tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_3.setInput(liststusne1);
				
			}
		});
		
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
			}
		});
		
		//查询成绩排名
		//首先创建指定课程视图-查询-删除视图
		sql="drop view if exists cou_"+getTea_no()+";";
		try {
			pr.executeUpdate(sql);
			System.out.println("删除成功");
			//创建
			sql="create view cou_"+getTea_no()+" as "
					+ "select a.S_no,S_name,a.C_no,a.score from sc a " + 
					"join s on s.S_no=a.S_no " + 
					"where a.C_no=(select C_no from tc where T_no='"
					+ getTea_no()+"')";
			pr.executeUpdate(sql);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//创建排名视图
		sql="drop view if exists cou_"+getTea_no()+"_ord;";
		try {
			pr.executeUpdate(sql);
			
			//创建
			sql="create view cou_"+getTea_no()+"_ord as "
					+ "select a.S_no,(select count(b.score)+1 from cou_"+
					getTea_no()+" b where b.score>a.score) rand from cou_"+
					getTea_no()+" a order by a.score desc;";
			pr.executeUpdate(sql);
							
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//课程名称，平均分
		sql="select C_name from tc join c on c.C_no=tc.C_no where "
				+ "T_no='"
				+ getTea_no()+"';";
		System.out.println(sql);
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
		while(rs.next()) {
			label_20.setText(rs.getString("C_name"));
			lblNewLabel_1.setText("nihao");
		}
		//平均分
		sql="select avg(score) from cou_"+getTea_no();
		System.out.println(sql);
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
		while(rs.next()) {
			
			lblNewLabel_1.setText(rs.getString("avg(score)"));
		}
		
		
		
		
		//排名信息   注意在更新成绩按钮处添加排名更新
		//
		List<GetOrdFromView> liststusne=new ArrayList<GetOrdFromView>();
		sql="select a.S_no,S_name,score,rand from cou_"+getTea_no()+" a "
				+ "join cou_"+getTea_no()+"_ord b on "
						+ "a.S_no=b.S_no "
						+ "order by score desc;";
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
					

					GetOrdFromView sts=new GetOrdFromView();
					sts.setNo(rs.getString("S_no"));
					sts.setName(rs.getString("S_name"));
					sts.setScore(Integer.valueOf((rs.getString("score"))));
					
					//有问题
					System.out.println(rs.getString("rand"));
					sts.setOrd(Integer.valueOf((rs.getString("rand"))));
					liststusne.add(sts);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		tableViewer_3.setContentProvider(new TableViewContentProvider());
		tableViewer_3.setLabelProvider(new TableViewerLabelProvider());
		tableViewer_3.setInput(liststusne);
		
		
		
		
		
		
		
		
		
		setState((Statement) getCon().createStatement());
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.MIN | SWT.TITLE);
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				shell.close();
			}
		});
		shell.setSize(484, 510);
		shell.setText("\u6559\u5E08");

	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getState() {
		return state;
	}

	public void setState(Statement state) {
		this.state = state;
	}

	public String getTea_no() {
		return Tea_no;
	}

	public void setTea_no(String tea_no) {
		Tea_no = tea_no;
	}
}
