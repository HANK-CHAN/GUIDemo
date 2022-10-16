package GUI;

import javax.swing.*;
import java.awt.event.*; // 畫面中抓event的

import DB.TrainSQL;

public class Login extends JFrame implements ActionListener{
	
	public static String userAcc;
	
	private JLabel txtId = new JLabel("帳號: " );
	private JLabel txtPass = new JLabel("密碼: ");
	
	private JTextField inputId = new JTextField();
	private JPasswordField inputPass = new JPasswordField();
	private JButton btnLogin = new JButton("登入");
	private JButton btnCancel = new JButton("取消");

	public Login() {
		super("資源系統");
		txtId.setBounds(50,50,50,20); // x、y、寬、高
		add(txtId);
		txtPass.setBounds(50,80,50,20);
		add(txtPass);
		inputId.setBounds(110, 50, 100, 20);
		add(inputId);
		inputPass.setBounds(110, 80, 100, 20);
		add(inputPass);
		
		
		btnLogin.setBounds(70, 120, 75, 20);
		btnLogin.addActionListener(this);
		add(btnLogin);
		
		btnCancel.setBounds(155, 120, 75, 20);
		btnCancel.addActionListener(this);
		add(btnCancel);
		
		setLayout(null);
		setBounds(100,100,300,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	// 實作事件發生，要如何處理
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnLogin) {
			
			String acc = inputId.getText();
			String pwd = String.valueOf(inputPass.getPassword());

			boolean isCheck = false; 
			try {
				TrainSQL tsql = new TrainSQL();
				isCheck = tsql.Login(acc,pwd);
			}catch(Exception e) {
				e.printStackTrace();
			}
//			if(acc.equals("hank") && pwd.equals("123456"))
			if(isCheck){
				userAcc = acc;
				new MainContent();
				setVisible(false); // 將此login 畫面不顯示
				
			}else {
				JOptionPane.showMessageDialog(null, "帳密錯誤","登入資訊",JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		
		if(event.getSource() == btnCancel) {
			
			inputId.setText("");
			inputPass.setText("");
		}
	}

}
