package pri.fankehu.sams;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Database extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	
	private String host;
	private String user;
	private String password;
	private String database;
	private int port;
	private Connection con;//连接
	private boolean linkstate;//连接状态

	//错误提示字符串
	private String stringee;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Database(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	/**
	 * 设置默认数据库连接选项
	 */
	private void setDatabaseLink() {
		setHost("localhost");
		setUser("root");
		setPassword("root");
		setDatabase("sams");
		setPort(3306);
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.TITLE);
		shell.setSize(337, 384);
		shell.setText("\u6570\u636E\u5E93\u914D\u7F6E");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(118, 27, 141, 23);
		text.setText(getHost());
		
		Label lblHost = new Label(shell, SWT.NONE);
		lblHost.setBounds(51, 33, 61, 17);
		lblHost.setText("host");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(118, 81, 141, 23);
		text_1.setText(getDatabase());
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(51, 81, 61, 17);
		label.setText("\u6570\u636E\u5E93\u540D");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(51, 136, 61, 17);
		label_1.setText("\u7AEF\u53E3\u53F7");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(51, 189, 61, 17);
		label_2.setText("\u7528\u6237\u540D");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(51, 251, 61, 17);
		label_3.setText("\u5BC6\u7801");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(118, 136, 141, 23);
		text_2.setText(String.valueOf(getPort()));
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(118, 189, 141, 23);
		text_3.setText(getUser());
		
		
		text_4 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_4.setBounds(118, 245, 141, 23);
		text_4.setText(getPassword());
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setHost(text.getText());
				setDatabase(text_1.getText());
				setPort(Integer.valueOf(text_2.getText()));
				setUser(text_3.getText());
				setPassword(text_4.getText());
				shell.setVisible(false);
				//shell.dispose();
				
				shell.getParent().setEnabled(true);
			}
		});
		btnNewButton.setBounds(179, 294, 80, 27);
		btnNewButton.setText("\u786E\u8BA4");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setDatabaseLink();
				text.setText(getHost());
				text_1.setText(getDatabase());
				text_2.setText(String.valueOf(getPort()));
				text_3.setText(getUser());
				text_4.setText(getPassword());
			}
		});
		btnNewButton_1.setBounds(51, 294, 80, 27);
		btnNewButton_1.setText("\u6062\u590D\u9ED8\u8BA4");

	}
	
	/**
	 * 连接数据库
	 * @return
	 */
	private String LinkDatabase() {
		String driver="com.mysql.jdbc.Driver";
	       String url="jdbc:mysql://"+getHost()+":"+getPort()+"/"+getDatabase();
	       try{
	           Class.forName(driver);
	           con=DriverManager.getConnection(url,getUser(),getPassword());
	       } catch (ClassNotFoundException e) {
	           //e.printStackTrace();
	           System.out.println("数据库连接失败");
	           System.out.println("未安装数据库驱动");
	           setStringee("未安装数据库驱动");
	          
	           setLinkstate(false);
	           return getStringee();
	           
	           
	           
	       }catch (SQLException e){
	           //System.out.println("数据库连接失败");
	           setStringee("数据库连接失败");
	           setLinkstate(false);
	           return getStringee();
	       }
	       setLinkstate(true);
	       setCon(con);
		return "连接成功";
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void setDatabaseLink(Object object) {
		// TODO Auto-generated method stub
		setDatabaseLink();
	}
	public String getLinkDatabase(Object object) {
		//连接数据库
		return LinkDatabase();
	}

	public String getStringee() {
		return stringee;
	}

	public void setStringee(String stringee) {
		this.stringee = stringee;
	}

	public boolean isLinkstate() {
		return linkstate;
	}

	public void setLinkstate(boolean linkstate) {
		this.linkstate = linkstate;
	}
}
