package account.addAccount;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import account.action.Join_Action;

// DB�� ���� ������ �Է��ϴ� Ŭ����(Swing���� ����)
public class Join extends JFrame {
	
	public JTextField[] infos = new JTextField[8]; 
	ButtonGroup gb;
	public JRadioButton rb1, rb2;
	JTextField[] res_infos = new JTextField[2];

	String [] info_names = {"���̵�","�н�����","�̸�","�ֹι�ȣ","��ȭ��ȣ","�ּ�","����","�����ּ�"};
	JLabel[] names = new JLabel[8];
	JButton join = new JButton("JOIN");
	
	public Join() {
		
		 rb1 = new JRadioButton("M");
	     rb2 = new JRadioButton("F");
	     gb = new ButtonGroup();
	     gb.add(rb1);
		 gb.add(rb2);
	    
		for (int i = 0; i<8; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			if(i != 3 && i != 6) {
				infos[i].setBounds(100, 20 + i*50,100,20);
				add(infos[i]);
			}
			
			names[i].setBounds(30, 20 + i*50,100,20);
			add(names[i]);
		}
		
		for (int i = 0; i < 2; i++) {
			res_infos[i] = new JTextField(10);
			res_infos[i].setBounds(100, 20 + i*50,100,20);
		}
		rb1.setBounds(95, 320,50,20);
	    rb2.setBounds(150, 320,50,20);
	    add(rb1);
	    add(rb2);
		
		join.setBounds(110, 420, 90, 20);
		add(join);
		
		join.addActionListener(new Join_Action(this));
		
		setTitle("ȸ�� ����");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(750,100);
		setSize(300, 500);
		setVisible(true);
	
	}
	
}
