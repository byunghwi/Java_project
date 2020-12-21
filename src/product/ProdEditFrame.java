package product;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import common.RoundedButton;

import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class ProdEditFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton compEditBtn;
	public JButton cancelEidtBtn;
	JPanel contentPanel;
	JPanel pIn;
	
	//String[] fieldNames = new String[]{"상품명", "제조일", "폐기일", "수량", "가격"};
	String[] fieldNames = new String[]{"상품명", "가격"};
	
	public JLabel[] labels;
	public JLabel titleLabel;
	public Product product = new Product();
	
	public JTextField tf1;
	public JTextField tf2;
	public JTextField tf3;
	
	public JDateChooser dateChooser1 = new JDateChooser();
	public JDateChooser dateChooser2 = new JDateChooser();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	
	public ProdEditFrame(){
		
		
		titleLabel = new JLabel("[ 상품 수정 ]");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleLabel.setBounds(0,20, 100, 50);
		
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("상품 수정");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 317);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		
		pIn = new JPanel();
		pIn.setBackground(new Color(255, 255, 255));
		pIn.setBounds(0, 0, 285, 288);
		contentPanel.add(pIn);
		
		labels = new JLabel[fieldNames.length];
	
//		for (int i = 0; i < fieldNames.length; i++) {
//			//System.out.println(fieldNames[i]);
//			labels[i] = new JLabel(fieldNames[i]);
//			labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
//			labels[i].setBounds(30, (i+1)*50, 50 , 30);
//	
//			pIn.add(labels[i]);
//		}
//		
		//상품명
		tf1 = new JTextField();
		tf1.setBounds(130, 50, 132, 30);
		
//		//제조일
//		dateChooser1.setBounds(130, 100, 170 , 30);
//		
//		//폐기일
//		dateChooser2.setBounds(130, 150, 170 , 30);
//		
//		//수량
//		tf2 = new JTextField();
//		tf2.setBounds(130, 200, 170 , 30);
		
		//가격
		tf2 = new JTextField();
		tf2.setBounds(130, 147, 132, 30);
		pIn.setLayout(null);
		
		pIn.add(tf1);
//		pIn.add(dateChooser1);
//		pIn.add(dateChooser2);
		pIn.add(tf2);
//		pIn.add(tf3);
		
		compEditBtn = new RoundedButton("수정");
		compEditBtn.setBounds(130, 230, 57, 30);

		cancelEidtBtn = new RoundedButton("취소");
		cancelEidtBtn.setBounds(205, 230, 57, 30);
	
		pIn.add(compEditBtn);
		pIn.add(cancelEidtBtn);
		
		lblNewLabel = new JLabel("상품명");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		lblNewLabel.setBounds(135, 22, 57, 15);
		pIn.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("상품가격");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		lblNewLabel_1.setBounds(135, 122, 57, 15);
		pIn.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setForeground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 109, 288);
		pIn.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("상품 수정");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 20, 109, 30);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 21));
		panel.add(lblNewLabel_2);

	}
	
	//텍스트필드 초기화 해주기.
	public void resetText() {
		tf1.setText("");
		tf2.setText("");
//		tf3.setText("");
//		dateChooser1.setDate(null);
//		dateChooser2.setDate(null);
	}
}
