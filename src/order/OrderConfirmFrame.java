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
	
	public JButton order_btn, confirm_btn, delete_btn, cancel_btn; // 주문, 승인, 삭제, 취소 버튼
	JPanel btn_panel, tabel_panel;
	
	String[] fieldNames = new String[] {"물품id", "수량"};
	String[] textHints = new String[] {"id입력", "수량입력"};

	public JLabel[] labels;
	public JTextField[] fields;
	
	OrderConfirmView ocv = new OrderConfirmView(); // 가운데 들어갈예정
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
	
}
