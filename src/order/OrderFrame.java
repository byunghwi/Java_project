package order;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JButton order_btn, cancel_btn; // 주문, 취소 버튼
	public JPanel tabel_panel, btn_panel;
	
	String[] fieldNames = new String[] {"상품id", "수량", "사용자"};
	String[] textHints = new String[] {"id입력",  "수량입력" , "사용자id입력"};
	
	public JLabel[] labels;
	public JTextField[] fields;

	OrderView ov = new OrderView();
	public CardLayout cardlayout;
	
	public OrderFrame() {
		cardlayout = new CardLayout();
		
		tabel_panel = new JPanel();
		tabel_panel.add(ov, BorderLayout.CENTER);
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
		cancel_btn = new JButton("취소");
		btn_panel.add(order_btn);
		btn_panel.add(cancel_btn);
		add(btn_panel, BorderLayout.SOUTH);
		
		setTitle("물품목록");
		setResizable(true);
		setBounds(100, 100, 1200, 400);
	}
	
}