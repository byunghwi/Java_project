package main;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.RoundedButton;
import java.awt.SystemColor;
import javax.swing.UIManager;



public class BottomPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton productBtn;
	public JButton saleBtn;
	public JButton stockBtn;
	public JButton eventBtn;
	public JButton commuteBtn;
	public JButton calcBtn;
	
	public BottomPanel() {

			//setBackground(UIManager.getColor("Button.background"));
			productBtn = new RoundedButton("상품");
			productBtn.setBounds(26, 3, 140, 120);
			saleBtn = new RoundedButton("판매");
			saleBtn.setBounds(220, 3, 140, 120);
			stockBtn = new RoundedButton("재고");
			stockBtn.setBounds(411, 3, 140, 120);
			eventBtn = new RoundedButton("이벤트");
			eventBtn.setBounds(602, 3, 140, 120);
			commuteBtn = new RoundedButton("근태");
			commuteBtn.setBounds(793, 3, 140, 120);
			calcBtn = new RoundedButton("매출");
			calcBtn.setBounds(981, 2, 140, 120);
			
			//productBtn.setForeground(Color.WHITE);
			productBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));

			//saleBtn.setForeground(Color.WHITE);
			saleBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));
			
			//stockBtn.setForeground(Color.WHITE);
			stockBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));
			
			
			//eventBtn.setForeground(Color.WHITE);
			eventBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));
			
			
			//commuteBtn.setForeground(Color.WHITE);
			commuteBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));
			
			//calcBtn.setForeground(Color.WHITE);
			calcBtn.setFont(new Font("나눔고딕", Font.BOLD, 21));
			setLayout(null);

			add(productBtn);
			add(saleBtn);
			add(stockBtn);
			add(eventBtn);
			add(commuteBtn);
			add(calcBtn);
	}
	
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}
}
