package stock.stockframe;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.RoundedButton;

// 메인 프레임의 우측 버튼목록에 대한 패널
public class StockRightBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton productMoreInfoBtn;
	public JButton disposalInfoBtn;
	public JButton orderConfirmBtn;

	public StockRightBtnPanel() {

		setLayout(null);
		productMoreInfoBtn = new RoundedButton("상품정보");
		

		productMoreInfoBtn.setForeground(Color.WHITE);
		productMoreInfoBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		productMoreInfoBtn.setBackground(new Color(204, 206, 206));
		productMoreInfoBtn.setBounds(0, 10, 140, 120);
		
		add(productMoreInfoBtn);
		
		disposalInfoBtn = new RoundedButton("폐기정보");
		disposalInfoBtn.setForeground(Color.WHITE);
		disposalInfoBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		disposalInfoBtn.setBackground(new Color(204, 206, 206));
		disposalInfoBtn.setBounds(0, 150, 140, 120);
		
		add(disposalInfoBtn);
		
		orderConfirmBtn = new RoundedButton("발주");
		orderConfirmBtn.setForeground(Color.WHITE);
		orderConfirmBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		orderConfirmBtn.setBackground(new Color(204, 206, 206));
		orderConfirmBtn.setBounds(0, 300, 140, 120);
		
		add(orderConfirmBtn);
		
	}

}