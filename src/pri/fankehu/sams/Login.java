package pri.fankehu.sams;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class Login {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text;
	private Text text_1;
	private String login_user;
	private String login_password;
	private Connection con;//����

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
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
		shell = new Shell(SWT.MIN);
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				System.out.println("�رմ���");
				shell.close();
				shell.dispose();
			}
		});
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setSize(373, 249);
		
		
		shell.setText("\u767B\u5F55-\u8FDE\u63A5\u6570\u636E\u5E93");
		shell.setLayout(null);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(144, 38, 162, 23);
		formToolkit.adapt(text, true, true);
		
		
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(144, 78, 162, 23);
		formToolkit.adapt(text_1, true, true);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(49, 38, 89, 23);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("\u5B66\u53F7/\u6559\u5DE5\u53F7\uFF1A");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(49, 15, 257, 17);
		formToolkit.adapt(label, true, true);
		
		
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setBounds(49, 78, 89, 23);
		formToolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("\u5BC6          \u7801\uFF1A");
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton.setBounds(59, 107, 130, 47);
		formToolkit.adapt(btnRadioButton, true, true);
		btnRadioButton.setText("\u5B66\u751F");
		
		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.setBounds(195, 107, 111, 47);
		formToolkit.adapt(btnRadioButton_1, true, true);
		btnRadioButton_1.setText("\u6559\u5E08");
		
		
		
		
		
		Database database=new Database(shell, 0);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//���ø����ڲ��ɲ���
				shell.setEnabled(false);
				database.setDatabaseLink(null);//����Ĭ������
				
				database.open();
				
			}
		});
		btnNewButton_1.setBounds(49, 160, 80, 27);
		formToolkit.adapt(btnNewButton_1, true, true);
		btnNewButton_1.setText("\u9AD8\u7EA7\u9009\u9879");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		//��¼��ť
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//�����¼ʧ�ܣ����ظ���Ϣ
				database.setDatabaseLink(null);
				label.setText(database.getLinkDatabase(null));
				
				setLogin_user("2016001");//Ĭ�ϵ�¼�˺�
				//text.setText(getLogin_user());
				
				//�����¼�ɹ�����ϵͳ����
				if(database.isLinkstate()) {
					setCon(database.getCon());
					//�����ѡѧ����ť
					if(btnRadioButton.getSelection()) {
						label.setText("��ѧ������");
						
						try {
							Student window = new Student();
							window.setCon(getCon());
							window.setStuNo(text.getText());
							window.open();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
					else if(btnRadioButton_1.getSelection()){
						//label.setText("�򿪽�ʦ����");
						try {
							Teacher window = new Teacher();
							window.setCon(getCon());
							window.setTea_no(text.getText());
							window.open();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else {
						label.setText("�빴ѡ��¼��ʽ");
					}
				}
				
			}
		});
		
		

		btnNewButton.setBounds(226, 160, 80, 27);
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("\u767B\u5F55");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				//�����¼ʧ�ܣ����ظ���Ϣ
				database.setDatabaseLink(null);
				label.setText(database.getLinkDatabase(null));
				
				
				//�����¼�ɹ�����ϵͳ����
				if(database.isLinkstate()) {
					setCon(database.getCon());
					
					
						
					try {
						Manager window = new Manager();
						window.setCon(getCon());
						
						window.open();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		button.setBounds(135, 160, 80, 27);
		formToolkit.adapt(button, true, true);
		button.setText("\u7BA1\u7406\u5458\u767B\u5F55");

	}

	public String getLogin_user() {
		return login_user;
	}

	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
