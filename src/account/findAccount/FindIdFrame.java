package account.findAccount;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.RoundedButton;

public class FindIdFrame extends JFrame {
	
	RoundedButton find = new RoundedButton("확인",68,68,68);
	 Read_Account_NAP nap = null;
	
	public FindIdFrame() {
		
		Font f1 = new Font("나눔고딕", Font.BOLD, 15);
		JLabel name = new JLabel("이름");
		JLabel phone_number = new JLabel("전화번호");
		JTextField name_text = new JTextField(10);
		JTextField phone_text = new JTextField(10);
		JPanel pIn;
		JLabel findIDText = new JLabel("ID 찾기");
		findIDText.setFont(f1);
		
		findIDText.setForeground(new Color(255, 255, 255));
		pIn = new JPanel();
		pIn.setBackground(new Color(68, 68, 68));
		pIn.setBounds(0, 0, 80, 550);
		add(pIn);
		pIn.add(findIDText).setBounds(17, 0, 47, 40);
		
		
		pIn.setLayout(null);
		pIn.setFocusable(false);
		
		name.setFont(new Font("나눔고딕", Font.BOLD, 15));
		phone_number.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		add(name).setBounds(90, 25, 40, 20);
		add(phone_number).setBounds(90, 70, 100, 20);
		
		add(name_text).setBounds(175, 25, 100, 20);
		add(phone_text).setBounds(175, 70, 100, 20);
		
		
		find.setFont(new Font("나눔고딕", Font.BOLD, 15));
		add(find).setBounds(182, 110, 90, 30);
		find.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JFrame j1 = this;
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nap = new Read_Account_NAP(name_text.getText(),phone_text.getText());
				
				if (nap.check) {
					JOptionPane.showMessageDialog(null, "당신의  ID는  '" +nap.read_info[1] +  "'  입니다." );
					j1.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 정보입니다." );
				}
				
			}
		});
		
		setTitle("ID 찾기");
		setLayout(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(600,400);
		setSize(320, 200);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new FindIdFrame();
	}
}
