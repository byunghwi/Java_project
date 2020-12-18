package orderConfirm;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderConfirmFrame extends JFrame {
	public OrderConfirmView orderConfirmView = new OrderConfirmView(); // 가운데 들어갈예정
	
	private static final long serialVersionUID = 1L;
	
	// 주문, 승인, 삭제, 취소, 검색, 새로고침 버튼
	public JButton order_btn, confirm_btn, delete_btn, cancel_btn, search_btn;
	public JPanel btn_panel, tabel_panel, search_panel;
	
	String[] fieldNames = new String[] {"발주번호", "상품명", "물품id", "가격", "수량"};
	String[] textHints = new String[] {"번호입력	", "상품명입력	", "id입력	", "가격입력	","수량입력	"};

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
			fields[i] = new HintTextField(textHints[i]);

			btn_panel.add(labels[i]);
			btn_panel.add(fields[i]);
		}
		// 입력칸 편집못하게
		fields[0].setEditable(false);
		fields[1].setEditable(true);
		fields[2].setEditable(false);
		fields[3].setEditable(true);
		fields[4].setEditable(false);
		
		order_btn = new JButton("상품조회");
		confirm_btn = new JButton("승인");
		delete_btn = new JButton("삭제");
		cancel_btn = new JButton("취소");
		
		search_panel = new JPanel();
		search_btn = new JButton("검색");
		search_panel.add(combo);
		search_panel.add(search_jf);
		search_panel.add(search_btn);
		add(search_panel, BorderLayout.NORTH);
		
		btn_panel.add(order_btn);
		btn_panel.add(confirm_btn);
		btn_panel.add(delete_btn);
		btn_panel.add(cancel_btn);
		add(btn_panel, BorderLayout.SOUTH);
		
		setTitle("승인대기창");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 400);
		
	}
	
	//필드값 초기화 해주기.
	public void resetText() {
		fields[0].setText("	");
		fields[1].setText("	");
		fields[2].setText("	");
		fields[3].setText("	");
		fields[4].setText("	");
	}
	
}