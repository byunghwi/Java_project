import javax.swing.JFrame;
import javax.swing.JTextField;

import account.util.JTextFieldLimit;

public class testad extends JFrame {
	
	public testad() {
		JTextField test = new JTextField(10);
		
		test.setDocument(new JTextFieldLimit(10));
		
		test.setBounds(100, 100, 100, 100);
		add(test);
		
		setTitle("회원 가입");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(800,100);
		setSize(310, 450);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new testad();
	}
}
