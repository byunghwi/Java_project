package account.delAccount;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import account.action.Delete_Action;
import common.RoundedButton;
import main.MainFrame;


// 회원 탈퇴 정보를 받아오는 프레임
public class Secession extends JFrame{
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_names = {"ID","PW"};
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	RoundedButton secession = new RoundedButton("회 원 탈 퇴");
	Font f1 = new Font("나눔고딕", Font.BOLD, 13);
	JPanel pIn;
	JLabel secessionText = new JLabel("회원 탈퇴");
	public MainFrame m1 = null;
	
	public Secession(String mem_id) {
		
		
		secessionText.setFont(f1);
		
		secessionText.setForeground(new Color(255, 255, 255));
		pIn = new JPanel();
		pIn.setBackground(new Color(128, 128, 128));
		pIn.setBounds(0, 0, 70, 550);
		add(pIn);
		pIn.add(secessionText).setBounds(8, 0, 55, 40);
		
		
		pIn.setLayout(null);
		pIn.setFocusable(false);
		
		for (int i = 0; i<2; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			names[i].setFont(f1);
			
			infos[i].setBounds(155, 20 + i*30,100,20);
			names[i].setBounds(85, 20 + i*30,100,20);
			add(infos[i]);
			add(names[i]);
		}
		
		infos[0].setText(mem_id);
		infos[0].disable();
	
		secession.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		secession.setBounds(165, 85, 90, 20);
		secession.setFont(f1);
		add(secession);
		
		secession.addActionListener(new Delete_Action(this));
		
		this.getContentPane().setBackground(Color.WHITE);
		
		setTitle("회원 탈퇴");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(400,80);
		setSize(290, 160);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Secession(null);
	}
}
