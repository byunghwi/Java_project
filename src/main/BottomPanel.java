package main;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.RoundedButton;
import java.awt.SystemColor;



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
			setBackground(SystemColor.control);
			productBtn = new RoundedButton("상품");
			productBtn.setBounds(58, 0, 130, 98);
			saleBtn = new RoundedButton("판매");
			saleBtn.setBounds(228, 0, 130, 98);
			stockBtn = new RoundedButton("재고");
			stockBtn.setBounds(398, 0, 130, 98);
			eventBtn = new RoundedButton("이벤트");
			eventBtn.setBounds(570, 0, 130, 98);
			commuteBtn = new RoundedButton("근태");
			commuteBtn.setBounds(741, 0, 130, 98);
			calcBtn = new RoundedButton("정산");
			calcBtn.setBounds(907, 0, 130, 98);
			
			//productBtn.setForeground(Color.WHITE);
			productBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));

			//saleBtn.setForeground(Color.WHITE);
			saleBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			
			//stockBtn.setForeground(Color.WHITE);
			stockBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			
			
			//eventBtn.setForeground(Color.WHITE);
			eventBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			
			
			//commuteBtn.setForeground(Color.WHITE);
			commuteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			
			//calcBtn.setForeground(Color.WHITE);
			calcBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
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
