package account.findAccount;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.RoundedButton;

public class FindPwFrame extends JFrame {
	
	RoundedButton find = new RoundedButton("확인",68,68,68);
	Read_Account_NAP nap = null;
	
	public FindPwFrame() {
		
		Font f1 = new Font("나눔고딕", Font.BOLD, 15);
		JPanel pIn;
		JLabel findPWText = new JLabel("PW 찾기");
		findPWText.setFont(f1);
		JLabel id = new JLabel("아이디");
		JLabel name = new JLabel("이름");
		JLabel phone_number = new JLabel("전화번호");
		JTextField id_text = new JTextField(10);
		JTextField name_text = new JTextField(10);
		JTextField phone_text = new JTextField(10);
		
		findPWText.setForeground(new Color(255, 255, 255));
		pIn = new JPanel();
		pIn.setLayout(null);
		pIn.setBackground(new Color(68, 68, 68));
		pIn.setBounds(0, 0, 80, 550);
		add(pIn);
		pIn.add(findPWText).setBounds(12, 7, 60, 40);
		
		id.setFont(new Font("나눔고딕", Font.BOLD, 15));
		name.setFont(new Font("나눔고딕", Font.BOLD, 15));
		phone_number.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		add(id).setBounds(90, 25, 100, 20);
		add(name).setBounds(90, 70, 100, 20);
		add(phone_number).setBounds(90, 115, 100, 20);
		
		
		add(id_text).setBounds(180, 25, 100, 20);
		add(name_text).setBounds(180, 70, 100, 20);
		add(phone_text).setBounds(180, 115, 100, 20);
		
		
		find.setFont(new Font("나눔고딕", Font.BOLD, 15));
		add(find).setBounds(187, 150, 90, 30);
		find.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JFrame j1 = this;
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nap = new Read_Account_NAP(id_text.getText(),name_text.getText(),phone_text.getText());
				
				if (nap.check) {
					nap.reset_pw(id_text.getText());
					JOptionPane.showMessageDialog(null, "비밀번호가 기본값으로 변경되었습니다.(ID와 동일)" );
					j1.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 정보입니다." );
				}
				
			}
		});
		
		setTitle("PW 찾기");
		setLayout(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(600,400);
		setSize(320, 230);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new FindPwFrame();
	}
}