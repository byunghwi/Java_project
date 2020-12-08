package account;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import account.action.Login_Action;



public class Login extends JFrame {
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_names = {"ID","PW"};
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	JButton login = new JButton("LOGIN");
	
	public Login() {

		for (int i = 0; i<2; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			infos[i].setBounds(100, 20 + i*30,100,20);
			names[i].setBounds(30, 20 + i*30,100,20);
			add(infos[i]);
			add(names[i]);
		}
		
		login.setBounds(110, 90, 90, 20);
		add(login);
		
		login.addActionListener(new Login_Action(this));
		
		setTitle("�α���");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,80);
		setSize(250, 180);
		setVisible(true);
	}

}