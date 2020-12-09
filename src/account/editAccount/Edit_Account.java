package account.editAccount;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Join_Action;

public class Edit_Account extends JFrame {
	
	String mem_id;
	public JTextField[] infos = new JTextField[8]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	public JTextField[] res_infos = new JTextField[2];
	public JTextField[] phone_infos = new JTextField[3];
	JLabel minus[] = {new JLabel("-"),new JLabel("-"),new JLabel("-")};

	String [] info_names = {"���̵�","�н�����","�̸�","�ֹε�Ϲ�ȣ","��ȭ��ȣ","�ּ�","����","�����ּ�"};
	JLabel[] names = new JLabel[8];
	JButton edit = new JButton("����");
	JButton cancel = new JButton("���");
	
	Read_Account ra = null;
	JLabel id_label = null;
	
	public Edit_Account(String mem_id) {
		
		this.mem_id = mem_id;
		
		ra = new Read_Account(mem_id);
		id_label = new JLabel(mem_id.toUpperCase() +" ���� ȸ������");
		
		
		
		
		
		id_label.setBounds(90, 0, 130, 40);
		edit.setBounds(30, 370, 110, 20);
		cancel.setBounds(160, 370, 110, 20);
		add(edit);
		add(cancel);
		add(id_label);
		
		setTitle("ȸ�� ���� ����");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(800,100);
		setSize(310, 450);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new Edit_Account("admin");
		
	}
	
}
