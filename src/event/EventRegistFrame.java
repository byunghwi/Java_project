package event;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import common.HintTextField;
import common.RoundedButton;
import product.Product;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EventRegistFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EventType eventType;
	public JComboBox<String> combo;
	public JButton regBtn;
	public JButton cancelBtn;
	public JButton searchBtn;
	JPanel contentPanel;
	JPanel ein;
	
	String[] fieldNames = new String[]{"상품코드", "이벤트타입", "시작일", "종료일"};
	String[] textHints = new String[] {"상품코드를 입력하세요.",  "상품명을 입력하세요.", "가격을 입력하세요"};
	
	public JLabel[] labels;
	public JLabel titleLabel;
	public Product product = new Product();
	
	public JTextField tf1;

	public JDateChooser dateChooser1 = new JDateChooser();
	public JDateChooser dateChooser2 = new JDateChooser();
	
	public EventRegistFrame(){
		
		//combo = new JComboBox<String>(EventType.getValArr()); 

			
		setFont(new Font("나눔 고딕", Font.BOLD, 20));
		setTitle("[ 이벤트등록 ]");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 506);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		
		ein = new JPanel();
		ein.setBackground(new Color(255, 255, 255));
		ein.setBounds(0, 0, 439, 478);
		contentPanel.add(ein);
		ein.setLayout(null);
		ein.setFocusable(false);
	
		//상품코드
		tf1 = new HintTextField(textHints[0]);
		tf1.setBounds(202, 88, 134 , 30);
		
		searchBtn = new RoundedButton("찾기");
		searchBtn.setFont(new Font("나눔 고딕", Font.PLAIN, 13));
		searchBtn.setBounds(345, 88, 60 , 30);
		
		//이벤트타입
		//combo.setBounds(110, 100, 170 , 30);
			
		//시작일
		dateChooser1.setBounds(202, 193, 203 , 30);
		
		//종료일
		dateChooser2.setBounds(202, 305, 203 , 30);
		
		ein.add(tf1);
		//ein.add(combo);
		ein.add(dateChooser1);
		ein.add(dateChooser2);
		ein.add(searchBtn);

		regBtn = new RoundedButton("등록");
		regBtn.setFont(new Font("나눔 고딕", Font.PLAIN, 13));
		regBtn.setBounds(221, 404, 70, 30);

		cancelBtn = new RoundedButton("취소");
		cancelBtn.setFont(new Font("나눔 고딕", Font.PLAIN, 13));
		cancelBtn.setBounds(316, 404, 70, 30);
		
		ein.add(regBtn, BorderLayout.SOUTH);
		ein.add(cancelBtn, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 167, 478);
		ein.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("이벤트 등록");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.BOLD, 21));
		lblNewLabel_3.setBounds(12, 10, 143, 60);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("상품코드");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(202, 54, 70, 24);
		ein.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이벤트 시작일");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel_1.setBounds(202, 159, 106, 24);
		ein.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이벤트 종료일");
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel_2.setBounds(202, 265, 87, 30);
		ein.add(lblNewLabel_2);

	}
	
	//필드값 초기화 해주기.
	public void resetText() {
		tf1.setText("");
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);
	}
}
