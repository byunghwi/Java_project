package order;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JButton order_btn, cancel_btn, search_btn, refresh_btn; // 주문, 취소, 검색, 새로고침 버튼
	public JPanel tabel_panel, btn_panel, search_panel;
	
	String[] fieldNames = new String[] {"상품id", "수량", "사용자"};
	String[] textHints = new String[] {"id입력	", "수량입력	", "사용자id입력	"};
	
	public JLabel[] labels;
	public JTextField[] fields;

	public OrderView ov = new OrderView();
	public CardLayout cardlayout;
	
	String[] comboName = {"상품id", "상품명"};
	public JTextField search_jf = new JTextField(20);
	public JComboBox combo = new JComboBox(comboName); // 검색기능
	
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
		//입력칸 편집 못하게
		fields[0].setEditable(false);
		
		order_btn = new JButton("주문");
		cancel_btn = new JButton("취소");
		btn_panel.add(order_btn);
		btn_panel.add(cancel_btn);
		add(btn_panel, BorderLayout.SOUTH);
		
		search_panel = new JPanel();
		search_btn = new JButton("검색");
		refresh_btn = new JButton("새로고침");
		search_panel.add(combo);
		search_panel.add(search_jf);
		search_panel.add(search_btn);
		search_panel.add(refresh_btn);
		add(search_panel, BorderLayout.NORTH);
		
		setTitle("물품목록");
		setResizable(true);
		setBounds(100, 100, 1200, 400);
	}
	
	//필드값 초기화 해주기.
	public void resetText() {
		fields[0].setText("");
		fields[1].setText("");
		fields[2].setText("");
	}
	
}