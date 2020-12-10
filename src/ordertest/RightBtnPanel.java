package ordertest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import product.HintTextField;
import product.ProdRegistFrame;

public class RightBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton registProdBtn;
	public JButton delProdBtn;
	public JButton orderProdBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		registProdBtn = new JButton("상품등록");
		delProdBtn = new JButton("상품삭제");
		orderProdBtn = new JButton("상품발주");
		registProdBtn.setBounds(0, 0, 164, 120);
		delProdBtn.setBounds(0, 120, 164, 120);
		orderProdBtn.setBounds(0, 240, 164, 120);
		add(registProdBtn);
		add(delProdBtn);
		add(orderProdBtn);
		
		registProdBtn.setForeground(Color.WHITE);
		registProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registProdBtn.setBackground(new Color(204, 204, 204));

		
		delProdBtn.setForeground(Color.WHITE);
		delProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		delProdBtn.setBackground(new Color(153, 153, 153));
		
		orderProdBtn.setForeground(Color.WHITE);
		orderProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderProdBtn.setBackground(new Color(153, 153, 153));
	
	}

}