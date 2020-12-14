package order;

import java.awt.BorderLayout;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderConfirmFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JButton order_btn; // 주문, 승인, 삭제, 취소 버튼

	public JButton confirm_btn;

	public JButton delete_btn;

	public JButton cancel_btn;
	public JPanel btn_panel;

	public JPanel tabel_panel;
	
	String[] fieldNames = new String[] {"발주번호", "상품명", "물품id", "가격", "수량"};
	String[] textHints = new String[] {"번호입력", "상품명 입력", "id 입력", "가격 입력","수량 입력"};

	public JLabel[] labels;
	public JTextField[] fields;
	
	public OrderConfirmView ocv = new OrderConfirmView(); // 가운데 들어갈예정
	public CardLayout cardlayout;
	
	public OrderConfirmFrame() {
		cardlayout = new CardLayout();
		
		tabel_panel = new JPanel();
		tabel_panel.add(ocv, BorderLayout.CENTER);
		tabel_panel.setLayout(cardlayout);
		add(tabel_panel);
		
		labels = new JLabel[fieldNames.length];
		fields = new JTextField[fieldNames.length];
		
		btn_panel = new JPanel();
		for (int i = 0; i < fieldNames.length; i++) {
			labels[i] = new JLabel(fieldNames[i]);
			fields[i] = new HintTextField(textHints[i]);

			btn_panel.add(labels[i]);
			btn_panel.add(fields[i]);
		}
		
		
		
		order_btn = new JButton("주문");
		confirm_btn = new JButton("승인");
		delete_btn = new JButton("삭제");
		cancel_btn = new JButton("취소");
		
		btn_panel.add(order_btn);
		btn_panel.add(confirm_btn);
		btn_panel.add(delete_btn);
		btn_panel.add(cancel_btn);
		add(btn_panel, BorderLayout.SOUTH);
		
		setTitle("승인대기창");
		setResizable(true);
		setBounds(100, 100, 1200, 400);
	}
	
	//필드값 초기화 해주기.
	public void resetText() {
		fields[0].setText("");
		fields[1].setText("");
		fields[2].setText("");
		fields[3].setText("");
		fields[4].setText("");
	}
	
}
