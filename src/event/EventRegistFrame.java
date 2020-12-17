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

import product.HintTextField;
import product.Product;

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
		
		combo = new JComboBox<String>(EventType.getValArr()); 

			
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("[ 이벤트등록 ]");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 420);
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		
		ein = new JPanel();
		ein.setBounds(5, 5, 310, 400);
		contentPanel.add(ein);
		ein.setLayout(null);
		ein.setFocusable(false);
		
		labels = new JLabel[fieldNames.length];
		
		//상품코드
		tf1 = new HintTextField(textHints[0]);
		tf1.setBounds(110, 50, 130 , 30);
		
		searchBtn = new JButton("찾기");
		searchBtn.setBounds(242, 50, 60 , 30);
		
		//이벤트타입
		combo.setBounds(110, 100, 170 , 30);
			
		//시작일
		dateChooser1.setBounds(110, 150, 170 , 30);
		
		//종료일
		dateChooser2.setBounds(110, 200, 170 , 30);
		
		for (int j = 0; j < fieldNames.length; j++) {
			labels[j] = new JLabel(fieldNames[j]);
			labels[j].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			labels[j].setBounds(20, (j+1)*50, 60 , 30);
			ein.add(labels[j]);
		}
		
		ein.add(tf1);
		ein.add(combo);
		ein.add(dateChooser1);
		ein.add(dateChooser2);
		ein.add(searchBtn);

		regBtn = new JButton("등록");
		regBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		regBtn.setBounds(90, 320, 70, 30);

		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cancelBtn.setBounds(190, 320, 70, 30);
		
		ein.add(regBtn, BorderLayout.SOUTH);
		ein.add(cancelBtn, BorderLayout.SOUTH);

	}
	
	//필드값 초기화 해주기.
	public void resetText() {
		tf1.setText("");
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);
	}

}
