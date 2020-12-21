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
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
	
	public ProdEditFrame(){
		
		
		titleLabel = new JLabel("[ 상품 수정 ]");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleLabel.setBounds(0,20, 100, 50);
		
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("상품 수정");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 400);
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		
		pIn = new JPanel();
		pIn.setBounds(5, 5, 300, 400);
		contentPanel.add(pIn);
		pIn.setLayout(null);
		
		labels = new JLabel[fieldNames.length];
	
		for (int i = 0; i < fieldNames.length; i++) {
			//System.out.println(fieldNames[i]);
			labels[i] = new JLabel(fieldNames[i]);
			labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			labels[i].setBounds(30, (i+1)*50, 50 , 30);
	
			pIn.add(labels[i]);
		}
		
		//상품명
		tf1 = new JTextField();
		tf1.setBounds(130, 50, 170 , 30);
		
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
		tf2.setBounds(130, 100, 170 , 30);
		
		pIn.add(tf1);
//		pIn.add(dateChooser1);
//		pIn.add(dateChooser2);
		pIn.add(tf2);
//		pIn.add(tf3);
		
		compEditBtn = new JButton("수정");
		compEditBtn.setForeground(Color.WHITE);
		compEditBtn.setBackground(Color.DARK_GRAY);
		compEditBtn.setBorder(null);
		compEditBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		compEditBtn.setBounds(90, 320, 70, 30);

		cancelEidtBtn = new JButton("취소");
		cancelEidtBtn.setBorder(null);
		cancelEidtBtn.setBackground(Color.DARK_GRAY);
		cancelEidtBtn.setForeground(Color.WHITE);
		cancelEidtBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cancelEidtBtn.setBounds(190, 320, 70, 30);
		
		pIn.add(compEditBtn, BorderLayout.SOUTH);
		pIn.add(cancelEidtBtn, BorderLayout.SOUTH);

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
