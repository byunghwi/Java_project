package account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import account.action.Join_Action;

public class Join extends JFrame {
	
	public JTextField[] infos = new JTextField[8]; 
	String [] info_names = {"ID","PW","NAME","RES_NO","PHONE","ADDRESS","SEX","MAIL_ADD"};
	String [] info_data = new String[8];
	JLabel[] names = new JLabel[8];
	JButton join = new JButton("JOIN");
	
	
	public Join() {
		
		
		for (int i = 0; i<8; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			infos[i].setBounds(100, 20 + i*50,100,20);
			names[i].setBounds(30, 20 + i*50,100,20);
			add(infos[i]);
			add(names[i]);
		}
		
		join.setBounds(110, 420, 90, 20);
		add(join);
		
		join.addActionListener(new Join_Action(this));
		
		setTitle("회원 가입");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(750,100);
		setSize(300, 500);
		setVisible(true);
	}
	
}
