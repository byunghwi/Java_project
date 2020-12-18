package account.findAccount;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import account.action.Find_Id_Action;
import account.action.Find_Pw_Action;

public class FindSelectFrame extends JFrame{
	
	ImageIcon id_find_button = new ImageIcon("src/아이디찾기.jpg");
	ImageIcon pw_find_button = new ImageIcon("src/비밀번호찾기.jpg");
	JButton id_find = new JButton(id_find_button);
	JButton pw_find = new JButton(pw_find_button);
	
	public FindSelectFrame() {
		
		
		
		add(id_find).setBounds(20,15,150,65);
		id_find.setSize(150, 50);
		add(pw_find).setBounds(195,15,150,65);
		pw_find.setSize(150, 50);
		
		id_find.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw_find.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		id_find.addActionListener(new Find_Id_Action(this));
		pw_find.addActionListener(new Find_Pw_Action(this));
		
		setTitle("회원 정보 찾기");
		setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(600,400);
		setSize(380, 120);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new FindSelectFrame();
	}
}
