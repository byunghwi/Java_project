package account.addAccount;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Join_Action;

// 회원 가입을 정보를 받아올 프레임 클래스
public class Join extends JFrame {
	
	public JTextField[] infos = new JTextField[8]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	public JTextField[] res_infos = new JTextField[2];
	public JTextField[] phone_infos = new JTextField[3];
	JLabel minus[] = {new JLabel("-"),new JLabel("-"),new JLabel("-")};

	String [] info_names = {"아이디","비밀번호","이름","주민등록번호","전화번호","주소","성별","메일주소"};
	JLabel[] names = new JLabel[8];
	JButton join = new JButton("회원 가입");
	
	
	public Join() {
		
		 rb1 = new JRadioButton("M");
	     rb2 = new JRadioButton("F");
	     gb = new ButtonGroup();
	     gb.add(rb1);
		 gb.add(rb2);
	    
		for (int i = 0; i<8; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			if(i != 3 && i != 4 && i != 6) {
				infos[i].setBounds(120, 20 + i*45,130,20);
				add(infos[i]);
			}
			
			names[i].setBounds(30, 20 + i*45,100,20);
			add(names[i]);
		}
		
		for (int i = 0; i < 2; i++) {
			res_infos[i] = new JTextField(10);
			res_infos[i].setBounds(120 + i*70, 155,60,20);
			add(res_infos[i]);
		}
		minus[0].setBounds(182, 162, 5, 5);
		add(minus[0]);
		
		for (int i = 0; i < 3; i++) {
			phone_infos[i] = new JTextField(10);
			phone_infos[i].setBounds(120 + i*46, 200,40,20);
			add(phone_infos[i]);
		}
		
		minus[1].setBounds(160, 207, 5, 5);
		add(minus[1]);
		
		minus[2].setBounds(206, 207, 5, 5);
		add(minus[2]);
	
		rb1.setBounds(115, 290,50,20);
	    rb2.setBounds(180, 290,50,20);
	    add(rb1);
	    add(rb2);
		
		join.setBounds(100, 370, 110, 20);
		add(join);
		
		join.addActionListener(new Join_Action(this));

		
		setTitle("회원 가입");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(1050,300);
		setSize(310, 450);
		setVisible(true);
	
	}
	
}
