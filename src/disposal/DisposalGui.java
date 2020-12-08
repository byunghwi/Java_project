package disposal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DisposalGui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTable table;
	DefaultTableModel model;
	JButton disposal_btn, cancle_btn; // 폐기등록, 취소 버튼
	JLabel dis_date, product_label; // 일자,물품id 라벨
	JTextField product_text; // 물품id검색 텍스트필드
	JPanel panel;
	
	public DisposalGui() {
		super("폐기관리");
		panel = new JPanel();
		
		product_text = new JTextField(20);
		
		dis_date = new JLabel("폐기일자");
		product_label = new JLabel("물품id");
		
		disposal_btn = new JButton("폐기등록");
		cancle_btn = new JButton("취소");
		
		disposal_btn.addActionListener(new ActionListener() { // 폐기등록버튼 실행
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		cancle_btn.addActionListener(new ActionListener() { // 취소버튼 실행
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 폐기일자, 물품id(label, text), (폐기등록,취소)버튼 add
		panel.add(product_label);
		panel.add(product_text);
		panel.add(disposal_btn);
		panel.add(cancle_btn);
		
		Container c = getContentPane();

		c.add(new JLabel("폐기일자", JLabel.LEFT),"North");
		c.add(panel, BorderLayout.SOUTH);
	}
	
}














