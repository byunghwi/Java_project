package account.editAccount;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Cancel_Action;
import account.action.Edit_Action;
import common.RoundedButton;

// 수정할 회원 정보를 받아오는 프레임
public class Edit extends JFrame {
	
	Read_Account ra = null;
	JLabel id_label = null;
	
	
	ImageIcon edit_button = new ImageIcon("src/수정.jpg");
	ImageIcon cancle_button = new ImageIcon("src/취소.jpg");
	public String mem_id;
	public JTextField[] infos = new JTextField[5]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	public JTextField[] res_infos = new JTextField[2];
	public JTextField[] phone_infos = new JTextField[3];
	JLabel minus[] = {new JLabel("-"),new JLabel("-"),new JLabel("-")};
	Font f1 = new Font("나눔고딕", Font.BOLD, 13);
	JPanel pIn;
	JLabel editText = new JLabel("정보 수정");

	String [] info_names = {"비밀번호","비밀번호 확인","이름","주민등록번호","전화번호","주소","성별","메일주소"};
	JLabel[] names = new JLabel[8];
	RoundedButton edit = new RoundedButton("수 정");
	RoundedButton cancel = new RoundedButton("취 소");
	
	
	public Edit(String mem_id) {
		
		this.mem_id = mem_id;
		
		pIn = new JPanel();
		pIn.setBackground(new Color(128, 128, 128));
		editText.setFont(new Font("나눔고딕", Font.BOLD, 17));
		editText.setForeground(new Color(255, 255, 255));
		pIn.setBounds(0, 0, 110, 550);
		add(pIn);
		pIn.add(editText).setBounds(20, 22, 150, 30);
		pIn.setLayout(null);
		pIn.setFocusable(false);
		
		ra = new Read_Account(mem_id);
		id_label = new JLabel(mem_id.toUpperCase() +"님의 회원정보");
		id_label.setFont(f1);
		int pnl = ra.read_info[6].length();
		
		for (int i = 0; i < info_names.length; i++) {
			names[i] = new JLabel(info_names[i]);
			names[i].setBounds(140, 60 + i*50,100,20);
			names[i].setFont(f1);
			add(names[i]);
		}
		
	
		infos[0] = new JPasswordField(ra.read_info[2]);
		infos[0].setBounds(255, 60,100,20);
		add(infos[0]);
		
		infos[1] = new JPasswordField(ra.read_info[2]);
		infos[1].setBounds(255, 110,100,20);
		add(infos[1]);
		
		infos[2] = new JTextField(ra.read_info[3]);
		infos[2].setBounds(255, 160,100,20);
		add(infos[2]);
		
		res_infos[0] = new JTextField(ra.read_info[5].substring(0,6));
		res_infos[0].setBounds(255, 210,48,20);
		add(res_infos[0]);
		
		minus[0].setBounds(302, 210,53,20);
		add(minus[0]);
		
		res_infos[1] = new JTextField(ra.read_info[5].substring(6));
		res_infos[1].setBounds(308, 210,53,20);
		add(res_infos[1]);
		
		phone_infos[0] = new JTextField(ra.read_info[6].substring(0, 3));
		phone_infos[0].setBounds(255, 260,30,20);
		add(phone_infos[0]);
		
		minus[1].setBounds(285, 260,53,20);
		add(minus[1]);
		
		phone_infos[1] = new JTextField(ra.read_info[6].substring(3,pnl-4));
		phone_infos[1].setBounds(290, 260,35,20);
		add(phone_infos[1]);
		
		minus[2].setBounds(325, 260,53,20);
		add(minus[2]);
		
		phone_infos[2] = new JTextField(ra.read_info[6].substring(pnl-4));
		phone_infos[2].setBounds(330, 260,35,20);
		add(phone_infos[2]);
		
		infos[3] = new JTextField(ra.read_info[7]);
		infos[3].setBounds(255, 310,100,20);
		add(infos[3]);
		
		rb1 = new JRadioButton("M",ra.read_info[8].equals("M"));
		rb1.setBounds(255, 360,50,20);
		rb1.setBackground(Color.white);
		add(rb1);
		
		rb2 = new JRadioButton("F",ra.read_info[8].equals("F"));
		rb2.setBounds(315, 360,50,20);
		rb2.setBackground(Color.white);
		add(rb2);
		
		gb = new ButtonGroup();
	    gb.add(rb1);
		gb.add(rb2);
	    
		
		infos[4] = new JTextField(ra.read_info[9]);
		infos[4].setBounds(255, 410,100,20);
		add(infos[4]);
		
		id_label.setBounds(190, 0, 130, 40);
		edit.setBounds(145, 470, 80, 20);
		cancel.setBounds(265, 470, 80, 20);
		
		add(edit);
		add(cancel);
		add(id_label);
		
		edit.addActionListener(new Edit_Action(this));
		cancel.addActionListener(new Cancel_Action(this));
		
		edit.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		this.getContentPane().setBackground(Color.white);
		setTitle("회원 정보 수정");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(800,100);
		setSize(400, 550);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new Edit("admin1");
	}
}
