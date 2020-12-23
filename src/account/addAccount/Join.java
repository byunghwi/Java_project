package account.addAccount;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Join_Action;
import account.util.JTextFieldLimit;
import common.RoundedButton;

// 회원 가입을 정보를 받아올 프레임 클래스
public class Join extends JFrame {
	
	public JTextField[] infos = new JTextField[8]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	public JTextField[] res_infos = new JTextField[2];
	public JTextField[] phone_infos = new JTextField[3];
	JLabel minus[] = {new JLabel("-"),new JLabel("-"),new JLabel("-")};
	ImageIcon join_Action_Button = new ImageIcon("src/회원가입버튼.jpg");
	JPanel pIn;
	JLabel joinText = new JLabel("회원 가입");

	String [] info_names = {"* 아이디","* 비밀번호","* 이름","* 주민등록번호","* 전화번호","주소","성별","메일주소"};
	JLabel[] names = new JLabel[8];
	RoundedButton join = new RoundedButton("회 원 가 입",68,68,68);
	
	Font f1 = new Font("나눔고딕", Font.BOLD, 13);
	Font f2 = new Font("나눔고딕", Font.PLAIN, 23);

	public Join() {
		
		 rb1 = new JRadioButton("M");
	     rb2 = new JRadioButton("F");
	     gb = new ButtonGroup();
	     gb.add(rb1);
	     gb.add(rb2);
		 
	    joinText.setFont(f2);
	    joinText.setForeground(new Color(255, 255, 255));
	 	pIn = new JPanel();
		pIn.setBackground(new Color(68, 68, 68));
		pIn.setBounds(0, 0, 140, 550);
		add(pIn);
		pIn.add(joinText).setBounds(22, 27, 150, 40);
		pIn.setLayout(null);
		pIn.setFocusable(false);
		 
		for (int i = 0; i<8; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			if(i != 3 && i != 4 && i != 6) {
				infos[i].setBounds(280, 35 + i*55,130,20);
				add(infos[i]);
			}
			
			names[i].setFont(f1);
			names[i].setForeground(Color.gray);
			names[i].setBounds(160, 35 + i*55,100,20);
			add(names[i]);
		}

		for (int i = 0; i < 2; i++) {	
			res_infos[i] = new JTextField(10);
			res_infos[i].setBounds(280 + i*70, 200,60,20);
			add(res_infos[i]);
		}
		res_infos[0].setDocument(new JTextFieldLimit(6));
		res_infos[1].setDocument(new JTextFieldLimit(7));
		
		minus[0].setBounds(342, 205, 5, 5);
		add(minus[0]);
		
		for (int i = 0; i < 3; i++) {
			phone_infos[i] = new JTextField(10);
			phone_infos[i].setBounds(280 + i*46, 255,40,20);
			add(phone_infos[i]);
		}
		phone_infos[0].setDocument(new JTextFieldLimit(3));
		phone_infos[1].setDocument(new JTextFieldLimit(4));
		phone_infos[2].setDocument(new JTextFieldLimit(4));
		
		minus[1].setBounds(330, 260, 5, 5);
		add(minus[1]);
		
		minus[2].setBounds(366, 260, 5, 5);
		add(minus[2]);
	
		rb1.setBounds(280, 365,50,20);
	    rb2.setBounds(355, 365,50,20);
	    rb1.setBackground(Color.WHITE);
	    rb2.setBackground(Color.WHITE);
	    add(rb1);
	    add(rb2);
	    rb1.setSelected(true);
		
	    join.setFont(f1);
		join.setBounds(318, 466, 90, 30);
		join.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(join);
		
		join.addActionListener(new Join_Action(this));
		
		this.getContentPane().setBackground(Color.WHITE);
		
		
		setTitle("회원 가입");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(1050,300);
		setSize(450, 550);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new Join();
	}
	
}
