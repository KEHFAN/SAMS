package pri.fankehu.sams;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Student {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private String StuNo;//学号
	private Connection con;//连接
	private Statement state=null;
	private PreparedStatement pr=null;
	private PreparedStatement preparedStatement;
	private String sql;//查询语句
	private ResultSet rs;//查询结果
	private Table table;
	private Table table_1;
	private Table table_2;
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
		shell.setText("学生-"+getStuNo());
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
		shell.setSize(534, 538);
		shell.setText("\u5B66\u751F");
		shell.setLayout(new StackLayout());
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(null);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(34, 36, 61, 17);
		lblNewLabel.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(71, 89, 61, 17);
		lblNewLabel_1.setText("\u59D3\u540D");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(71, 161, 61, 17);
		lblNewLabel_2.setText("\u5B66\u53F7");
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setBounds(71, 125, 61, 17);
		lblNewLabel_3.setText("\u6027\u522B");
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setBounds(71, 200, 61, 17);
		lblNewLabel_4.setText("\u7CFB\u522B");
		
		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setBounds(71, 237, 61, 17);
		lblNewLabel_5.setText("\u73ED\u7EA7");
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(71, 275, 61, 17);
		label_2.setText("\u5165\u5B66\u5E74\u6708");
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBounds(71, 318, 61, 17);
		label_3.setText("\u51FA\u751F\u5E74\u6708");
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setBounds(71, 356, 61, 17);
		label_4.setText("\u7C4D\u8D2F");
		
		text = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(175, 83, 253, 23);
		
		text_1 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(175, 119, 253, 23);
		
		text_2 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(175, 155, 253, 23);
		
		text_3 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(175, 194, 253, 23);
		
		text_4 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(175, 231, 253, 23);
		
		text_5 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(175, 269, 253, 23);
		
		text_6 = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(175, 312, 253, 23);
		
		text_7 = new Text(composite, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		text_7.setBounds(175, 350, 253, 23);
		
		
		//打开查询个人信息
				sql="select S_no,S_name,S_sex,D_name,S_class,S_birth,S_entr,S_home from s "
						+ "join d on d.D_no=s.D_no where "
						+ "s_no='"+getStuNo()+"';";
				
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
						text.setText(rs.getString("S_name"));
						text_1.setText(rs.getString("S_sex"));
						text_2.setText(rs.getString("S_no"));
						text_3.setText(rs.getString("D_name"));//
						text_4.setText(rs.getString("S_class"));
						text_5.setText(rs.getString("S_entr"));
						text_6.setText(rs.getString("S_birth"));
						text_7.setText(rs.getString("S_home"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		composite.setVisible(true);
		Composite composite_1 = new Composite(shell, SWT.NONE);
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setBounds(10, 194, 61, 17);
		label.setText("\u6240\u6709\u8BFE\u7A0B");
		
		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setBounds(10, 10, 61, 17);
		label_5.setText("\u6211\u7684\u9009\u8BFE");
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 33, 498, 155);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableColumn.setWidth(77);
		tableColumn.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_3 = tableViewerColumn_3.getColumn();
		tableColumn_3.setWidth(90);
		tableColumn_3.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableColumn tableColumn_16 = new TableColumn(table, SWT.NONE);
		tableColumn_16.setWidth(68);
		tableColumn_16.setText("\u6388\u8BFE\u6559\u5E08");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
		tableColumn_2.setWidth(96);
		tableColumn_2.setText("\u5F00\u8BFE\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_4.getColumn();
		tableColumn_4.setWidth(43);
		tableColumn_4.setText("\u8BFE\u65F6");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_5 = tableViewerColumn_5.getColumn();
		tableColumn_5.setWidth(44);
		tableColumn_5.setText("\u5B66\u5206");
		
		TableViewer tableViewer_1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		table_1.setBounds(10, 217, 498, 252);
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_6 = tableViewerColumn_6.getColumn();
		tableColumn_6.setWidth(79);
		tableColumn_6.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_9 = tableViewerColumn_9.getColumn();
		tableColumn_9.setWidth(90);
		tableColumn_9.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableColumn tableColumn_15 = new TableColumn(table_1, SWT.NONE);
		tableColumn_15.setWidth(66);
		tableColumn_15.setText("\u6388\u8BFE\u6559\u5E08");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_8 = tableViewerColumn_8.getColumn();
		tableColumn_8.setWidth(96);
		tableColumn_8.setText("\u5F00\u8BFE\u9662\u7CFB");
		
		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_10 = tableViewerColumn_10.getColumn();
		tableColumn_10.setWidth(45);
		tableColumn_10.setText("\u8BFE\u65F6");
		
		TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_11 = tableViewerColumn_11.getColumn();
		tableColumn_11.setWidth(41);
		tableColumn_11.setText("\u5B66\u5206");
		
		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setBounds(77, 10, 87, 17);
		label_6.setText("\u6CE8\uFF1A\u53CC\u51FB\u5220\u9664");
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setBounds(10, 10, 61, 17);
		label_1.setText("\u6211\u7684\u6210\u7EE9");
		
		TableViewer tableViewer_2 = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_2 = tableViewer_2.getTable();
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(10, 33, 290, 436);
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
		tableColumn_1.setWidth(66);
		tableColumn_1.setText("\u8BFE\u7A0B\u7F16\u53F7");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_7 = tableViewerColumn_7.getColumn();
		tableColumn_7.setWidth(118);
		tableColumn_7.setText("\u8BFE\u7A0B\u540D\u79F0");
		
		TableViewerColumn tableViewerColumn_12 = new TableViewerColumn(tableViewer_2, SWT.NONE);
		TableColumn tableColumn_12 = tableViewerColumn_12.getColumn();
		tableColumn_12.setWidth(67);
		tableColumn_12.setText("\u5206\u6570");
		
		Label label_7 = new Label(composite_2, SWT.NONE);
		label_7.setBounds(316, 33, 61, 17);
		label_7.setText("\u603B        \u5206");
		
		Label label_8 = new Label(composite_2, SWT.NONE);
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_8.setBounds(383, 33, 125, 17);
		
		Label label_9 = new Label(composite_2, SWT.NONE);
		label_9.setBounds(316, 130, 61, 17);
		label_9.setText("\u6392        \u540D");
		
		Label label_10 = new Label(composite_2, SWT.NONE);
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_10.setBounds(383, 81, 125, 17);
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		composite_1.setVisible(false);
		
		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_11.setBounds(238, 194, 174, 17);
		label_11.setText("\u6709\u8001\u5E08\u6388\u8BFE\u7684\u8BFE\u7A0B\u624D\u4F1A\u663E\u793A");
		
		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setBounds(77, 194, 87, 17);
		label_12.setText("\u6CE8\uFF1A\u53CC\u51FB\u9009\u8BFE");
		composite_2.setVisible(false);
		
		Label label_13 = new Label(composite_2, SWT.NONE);
		label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_13.setBounds(383, 130, 125, 17);
		
		Label label_14 = new Label(composite_2, SWT.NONE);
		label_14.setBounds(316, 81, 61, 17);
		label_14.setText("\u5E73  \u5747   \u5206");
		composite.setVisible(true);
		
		
		//
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_1.setVisible(false);
				composite_2.setVisible(false);
				composite.setVisible(true);
				//查询个人信息
				//打开查询个人信息
				sql="select S_no,S_name,S_sex,D_name,S_class,S_birth,S_entr,S_home from s "
						+ "join d on d.D_no=s.D_no where "
						+ "s_no='"+getStuNo()+"';";
				
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
						text.setText(rs.getString("S_name"));
						text_1.setText(rs.getString("S_sex"));
						text_2.setText(rs.getString("S_no"));
						text_3.setText(rs.getString("D_name"));//
						text_4.setText(rs.getString("S_class"));
						text_5.setText(rs.getString("S_entr"));
						text_6.setText(rs.getString("S_birth"));
						text_7.setText(rs.getString("S_home"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntmNewItem.setSelection(true);
		mntmNewItem.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite.setVisible(false);
				composite_2.setVisible(false);
				composite_1.setVisible(true);
				
				//默认查询课程，全校课程
				//课程-基于教师选课表，只有有教师授课的课程才能选课
				List<GetSutSCfromTC> listcou=new ArrayList<GetSutSCfromTC>();
				sql="select c.C_no,C_name,T_name,D_name,C_time,C_credit from c,t,d,tc " + 
						" where t.T_no=tc.T_no and d.D_no=c.D_no and tc.C_no=c.C_no;";
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
						GetSutSCfromTC co=new GetSutSCfromTC(rs.getString("c.C_no"),rs.getString("C_name"),rs.getString("T_name"),(rs.getString("D_name")),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
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
				
				//sc_course  待修改
				List<GetSutSCfromTC> listsc=new ArrayList<GetSutSCfromTC>();
				sql="select c.C_no,C_name,T_name,D_name,C_time,C_credit from c,t,d,sc,tc " + 
						" where t.T_no=tc.T_no and d.D_no=c.D_no and sc.C_no=c.C_no and sc.C_no=tc.C_no and sc.C_no=c.C_no " + 
						" and sc.S_no='"
						+ getStuNo()+"';";
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
						GetSutSCfromTC sco=new GetSutSCfromTC(rs.getString("c.C_no"),rs.getString("C_name"),rs.getString("T_name"),(rs.getString("D_name")),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
						listsc.add(sco);
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
				tableViewer.setInput(listsc);
			}
		});
		composite.setVisible(true);
		mntmNewItem_1.setText("\u8BFE\u7A0B\u4FE1\u606F");
		
		MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite.setVisible(false);
				composite_1.setVisible(false);
				composite_2.setVisible(true);
				
				//查询成绩
				sql="select sc.C_no,C_name,score,avg(score) from sc "
						+ "join c on c.C_no=sc.C_no "
						+ "where S_no='"
						+ getStuNo()+"' "
						+ "group by sc.C_no;";
				List<GetGradeFromSC> listgrade=new ArrayList<GetGradeFromSC>();
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
						//有问题
						//GetGradeFromSC conew=new GetGradeFromSC(rs.getString("sc.C_no"),rs.getString("C_name"),Integer.valueOf(rs.getString("score")),Integer.valueOf(rs.getString("avg(score)")),Integer.valueOf(rs.getString("avg(score)")));
						GetGradeFromSC conew=new GetGradeFromSC();
						conew.setNo(rs.getString("sc.C_no"));
						conew.setName(rs.getString("C_name"));
						conew.setScore(Integer.valueOf(rs.getString("score")));
						System.out.println(rs.getString("avg(score)"));
						
						System.out.println(Double.valueOf(rs.getString("avg(score)")));
						conew.setAvgscore(Double.valueOf(rs.getString("avg(score)")));
						conew.setOrd(0);
						listgrade.add(conew);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableViewer_2.setContentProvider(new TableViewContentProvider());
				tableViewer_2.setLabelProvider(new TableViewerLabelProvider());
				tableViewer_2.setInput(listgrade);
				
				//计算总分
				sql="select susc,avsc from avscore where S_no='"
						+ getStuNo()+"';";
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
						label_8.setText(rs.getString("susc"));
						label_10.setText(rs.getString("avsc"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//计算排名
				sql="select rank from avord where S_no='"
						+ getStuNo()+"';";
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
						label_13.setText(rs.getString("rank"));
						//label_10.setText(rs.getString("avsc"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewItem_2.setText("\u6211\u7684\u6210\u7EE9");

		//双击选课
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				//检查是否选过这门课
				boolean stusel=false;//表示未选过 可以选择
				sql="select count(C_no) from sc "
						+ "where S_no='"
						+ getStuNo()+"' and C_no='"
						+ table_1.getItem(table_1.getSelectionIndex()).getText(0)+"';";
				//table_1.getSelectionIndex();
				//table_1.getItem(table_1.getSelectionIndex()).getText(0);
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
						if(Integer.valueOf(rs.getString("count(C_no)"))>0) {
							System.out.println("你已经选过这门课！");//已经备选
							//label_18.setText("该课程已有人选！");
							//Tselect=false;//不能在选课
							label_11.setText("你已经选过这门课！");
							stusel=true;
							//弹框提示
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(!stusel) {
					//如果没选过这门课 则选择
					sql="insert into sc (S_no,C_no)  "
							+ "values (?,?)";
					try {
						preparedStatement=(PreparedStatement) getCon().prepareStatement(sql);
						preparedStatement.setString(1, getStuNo());
						preparedStatement.setString(2, table_1.getItem(table_1.getSelectionIndex()).getText(0));
						
						preparedStatement.executeUpdate();
						label_11.setText("选课成功！");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//选课成功 更新选课表
					//sc_course  待修改
					List<GetSutSCfromTC> listsc=new ArrayList<GetSutSCfromTC>();
					sql="select c.C_no,C_name,T_name,D_name,C_time,C_credit from c,t,d,sc,tc " + 
							" where t.T_no=tc.T_no and d.D_no=c.D_no and sc.C_no=c.C_no and sc.C_no=tc.C_no and sc.C_no=c.C_no " + 
							" and sc.S_no='"
							+ getStuNo()+"';";
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
							GetSutSCfromTC sco=new GetSutSCfromTC(rs.getString("c.C_no"),rs.getString("C_name"),rs.getString("T_name"),(rs.getString("D_name")),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
							listsc.add(sco);
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
					tableViewer.setInput(listsc);
				}
				
				
			}
		});
		//双击删除选课
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				sql="delete from sc where C_no='"
						+table.getItem(table.getSelectionIndex()).getText(0) +"';";
				try {
					pr.executeUpdate(sql);
					System.out.println("删除成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//删除后更新表
				//sc_course  待修改
				List<GetSutSCfromTC> listsc=new ArrayList<GetSutSCfromTC>();
				sql="select c.C_no,C_name,T_name,D_name,C_time,C_credit from c,t,d,sc,tc " + 
						" where t.T_no=tc.T_no and d.D_no=c.D_no and sc.C_no=c.C_no and sc.C_no=tc.C_no and sc.C_no=c.C_no " + 
						" and sc.S_no='"
						+ getStuNo()+"';";
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
						GetSutSCfromTC sco=new GetSutSCfromTC(rs.getString("c.C_no"),rs.getString("C_name"),rs.getString("T_name"),(rs.getString("D_name")),Integer.valueOf(rs.getString("C_time")),Integer.valueOf(rs.getString("C_credit")));
						listsc.add(sco);
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
				tableViewer.setInput(listsc);
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

	public Statement getState() {
		return state;
	}

	public void setState(Statement state) {
		this.state = state;
	}

	public String getStuNo() {
		return StuNo;
	}

	public void setStuNo(String stuNo) {
		StuNo = stuNo;
	}
}
