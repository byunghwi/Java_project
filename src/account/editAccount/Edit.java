package account.editAccount;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Cancel_Action;
import account.action.Edit_Action;

public class Edit extends JFrame {
	
	Read_Account ra = null;
	JLabel id_label = null;
	
	public String mem_id;
	public JTextField[] infos = new JTextField[5]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	public JTextField[] res_infos = new JTextField[2];
	public JTextField[] phone_infos = new JTextField[3];
	JLabel minus[] = {new JLabel("-"),new JLabel("-"),new JLabel("-")};

	String [] info_names = {"패스워드","패스워드 확인","이름","주민등록번호","전화번호","주소","성별","메일주소"};
	JLabel[] names = new JLabel[8];
	JButton edit = new JButton("수정");
	JButton cancel = new JButton("취소");
	
	
	public Edit(String mem_id) {
		
		this.mem_id = mem_id;
		
		ra = new Read_Account(mem_id);
		id_label = new JLabel(mem_id.toUpperCase() +" 님의 회원정보");
		int pnl = ra.read_info[6].length();
		
		for (int i = 0; i < info_names.length; i++) {
			names[i] = new JLabel(info_names[i]);
			names[i].setBounds(30, 60 + i*50,100,20);
			add(names[i]);
		}
		
	
		infos[0] = new JPasswordField(ra.read_info[2]);
		infos[0].setBounds(145, 60,100,20);
		add(infos[0]);
		
		infos[1] = new JPasswordField(ra.read_info[2]);
		infos[1].setBounds(145, 110,100,20);
		add(infos[1]);
		
		infos[2] = new JTextField(ra.read_info[3]);
		infos[2].setBounds(145, 160,100,20);
		add(infos[2]);
		
		res_infos[0] = new JTextField(ra.read_info[5].substring(0,6));
		res_infos[0].setBounds(145, 210,48,20);
		add(res_infos[0]);
		
		minus[0].setBounds(192, 210,53,20);
		add(minus[0]);
		
		res_infos[1] = new JTextField(ra.read_info[5].substring(6));
		res_infos[1].setBounds(198, 210,53,20);
		add(res_infos[1]);
		
		phone_infos[0] = new JTextField(ra.read_info[6].substring(0, 3));
		phone_infos[0].setBounds(145, 260,30,20);
		add(phone_infos[0]);
		
		minus[1].setBounds(175, 260,53,20);
		add(minus[1]);
		
		phone_infos[1] = new JTextField(ra.read_info[6].substring(3,pnl-4));
		phone_infos[1].setBounds(180, 260,35,20);
		add(phone_infos[1]);
		
		minus[2].setBounds(215, 260,53,20);
		add(minus[2]);
		
		phone_infos[2] = new JTextField(ra.read_info[6].substring(pnl-4));
		phone_infos[2].setBounds(220, 260,35,20);
		add(phone_infos[2]);
		
		infos[3] = new JTextField(ra.read_info[7]);
		infos[3].setBounds(145, 310,100,20);
		add(infos[3]);
		
		rb1 = new JRadioButton("M",ra.read_info[8].equals("M"));
		rb1.setBounds(145, 360,50,20);
		add(rb1);
		
		rb2 = new JRadioButton("F",ra.read_info[8].equals("F"));
		rb2.setBounds(205, 360,50,20);
		add(rb2);
		
		gb = new ButtonGroup();
	    gb.add(rb1);
		gb.add(rb2);
	    
		
		infos[4] = new JTextField(ra.read_info[9]);
		infos[4].setBounds(145, 410,100,20);
		add(infos[4]);
		
		id_label.setBounds(90, 0, 130, 40);
		edit.setBounds(30, 470, 110, 20);
		cancel.setBounds(160, 470, 110, 20);
		
		add(edit);
		add(cancel);
		add(id_label);
		
		edit.addActionListener(new Edit_Action(this));
		cancel.addActionListener(new Cancel_Action(this));
		
		setTitle("회원 정보 수정");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(800,100);
		setSize(310, 550);
		setVisible(true);
	
	}

	
}
