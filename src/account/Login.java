package account;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import account.action.Login_Action;

// 로그인 관련 정보를 받아올 프레임
public class Login extends JFrame {
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_names = {"ID","PW"};
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	JButton login = new JButton("LOGIN");
	Font f1 = new Font("나눔고딕", Font.BOLD, 13);
	
	public Login() {

		
		infos[0] = new JTextField(10);
		names[0] = new JLabel(info_names[0]);
		
		
		
		infos[0].setBounds(100, 20 ,100,20);
		names[0].setBounds(30, 20 ,100,20);
		names[0].setFont(f1);
		add(infos[0]);
		add(names[0]);
		
		
		
		infos[1] = new JPasswordField(10);
		names[1] = new JLabel(info_names[1]);

		
		infos[1].setBounds(100, 50, 100, 20);
		names[1].setBounds(30, 50, 100, 20);
		
		add(infos[1]);
		add(names[1]);
		
		names[1].setFont(f1);
	
			
		login.setBounds(110, 90, 90, 20);
		add(login);
		
	//	login.addActionListener(new Login_Action(this));
		
		
		setTitle("로그인");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,80);
		setSize(250, 180);
		setVisible(true);
	}
	
}