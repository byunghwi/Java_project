package orderConfirm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.RoundedButton;

public class OrderConfirmFrame extends JFrame {
	public OrderConfirmView orderConfirmView = new OrderConfirmView(); // 가운데 들어갈예정
	
	private static final long serialVersionUID = 1L;
	
	// 주문, 승인, 삭제, 취소, 검색, 새로고침 버튼
	public JButton order_btn, confirm_btn, delete_btn, cancel_btn, search_btn;
	public JPanel btn_panel, tabel_panel, search_panel;
	
	String[] fieldNames = new String[] {"발주번호", "상품명", "물품id", "가격", "수량"};

	public JLabel[] labels;
	public JTextField[] fields;
	
	public CardLayout cardlayout;
	
	String[] comboName = {"상품id", "상품명"};
	public JTextField search_jf = new JTextField(20);
	public JComboBox combo = new JComboBox(comboName); // 검색기능
	
	public OrderConfirmFrame() {
		cardlayout = new CardLayout();
		
		tabel_panel = new JPanel();
		tabel_panel.add(orderConfirmView, BorderLayout.CENTER);
		tabel_panel.setLayout(cardlayout);
		add(tabel_panel);
		
		labels = new JLabel[fieldNames.length];
		fields = new JTextField[fieldNames.length];
		
		btn_panel = new JPanel();
		for (int i = 0; i < fieldNames.length; i++) {
			labels[i] = new JLabel(fieldNames[i]);
			labels[i].setForeground(Color.WHITE);
			fields[i] = new JTextField(10);

			btn_panel.add(labels[i]);
			btn_panel.add(fields[i]);
		}
		// 입력칸 편집못하게
		fields[0].setEditable(false);
		fields[1].setEditable(true);
		fields[2].setEditable(false);
		fields[3].setEditable(false);
		fields[4].setEditable(true);
		
		order_btn = new RoundedButton("상품조회");
		confirm_btn = new RoundedButton("승인");
		delete_btn = new RoundedButton("삭제");
		cancel_btn = new RoundedButton("취소");
		
		order_btn.setBorderPainted(false);
		confirm_btn.setBorderPainted(false);
		delete_btn.setBorderPainted(false);
		cancel_btn.setBorderPainted(false);
		
		search_panel = new JPanel();
		search_panel.setBackground(Color.LIGHT_GRAY);
		search_btn = new RoundedButton("검색");
		search_panel.add(combo);
		search_panel.add(search_jf);
		search_panel.add(search_btn);
		add(search_panel, BorderLayout.NORTH);
		
		btn_panel.setBackground(Color.LIGHT_GRAY);
		btn_panel.add(order_btn);
		btn_panel.add(confirm_btn);
		btn_panel.add(delete_btn);
		btn_panel.add(cancel_btn);
		add(btn_panel, BorderLayout.SOUTH);
		
		setTitle("승인대기창");
		setResizable(false); // 창크기 수정못하게
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