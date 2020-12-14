package account.delAccount;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import account.action.Delete_Action;


// ������ ������ ������ �޾ƿ��� Ŭ����(Swing ����)
public class Secession extends JFrame{
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_names = {"ID","PW"};
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	JButton delete = new JButton("DELETE");
	
	public Secession() {
		
		
		for (int i = 0; i<2; i++) {
			infos[i] = new JTextField(10);
			names[i] = new JLabel(info_names[i]);
			
			infos[i].setBounds(100, 20 + i*30,100,20);
			names[i].setBounds(30, 20 + i*30,100,20);
			add(infos[i]);
			add(names[i]);
		}
		
		delete.setBounds(110, 90, 90, 20);
		add(delete);
		
		delete.addActionListener(new Delete_Action(this));
		
		setTitle("회원 탈퇴");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,80);
		setSize(250, 180);
		setVisible(true);
	}

}
