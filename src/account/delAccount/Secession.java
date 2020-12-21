package account.delAccount;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import account.action.Delete_Action;


// 회원 탈퇴 정보를 받아오는 프레임
public class Secession extends JFrame{
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_names = {"ID","PW"};
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	JButton delete = new JButton("회원탈퇴");
	Font f1 = new Font("나눔고딕", Font.BOLD, 13);
	
	public Secession(String mem_id) {
		
		
		for (int i = 0; i<2; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			names[i].setFont(f1);
			
			infos[i].setBounds(100, 20 + i*30,100,20);
			names[i].setBounds(30, 20 + i*30,100,20);
			add(infos[i]);
			add(names[i]);
		}
		
		infos[0].setText(mem_id);
	
		
		delete.setBounds(70, 100, 90, 20);
		add(delete);
		
		delete.addActionListener(new Delete_Action(this));
		
		this.getContentPane().setBackground(Color.WHITE);
		
		setTitle("회원 탈퇴");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(400,80);
		setSize(250, 180);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Secession(null);
	}
}
