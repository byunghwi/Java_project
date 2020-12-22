package sale;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.RoundedButton;
import javax.swing.UIManager;


public class SaleBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton saleBtn;
	public JButton saleListBtn;

	public SaleBtnPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		saleBtn = new RoundedButton("판매");
		saleListBtn = new RoundedButton("판매리스트");

		saleBtn.setForeground(Color.WHITE);
		saleBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		saleBtn.setBackground(new Color(204, 206, 206));
		saleBtn.setBounds(0, 10, 140, 120);
		
		saleListBtn.setForeground(Color.WHITE);
		saleListBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		saleListBtn.setBackground(new Color(204, 206, 206));
		saleListBtn.setBounds(0, 150, 140, 120);
		
		add(saleBtn);
		add(saleListBtn);
	}
	
	public void selectedBtn(JButton selectedBtn) {
		for (int i = 0; i < getComponentCount(); i++) {
			getComponent(i).setBackground(new Color(204, 206, 206));
		}
		selectedBtn.setBackground(new Color(0,10,10));
	}

}