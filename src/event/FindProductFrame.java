package event;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.RoundedButton;
import product.ProductView;

public class FindProductFrame extends JFrame{
	public JPanel contentPanel;
	public JPanel centerPanel;
	public ProductView productView = new ProductView();
	public CardLayout cardlayout = new CardLayout();
	public JButton regBtn;
	
	public FindProductFrame() {
		setFont(new Font("나늠고딕", Font.BOLD, 20));
		setTitle("상품리스트");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1189, 649);
		setVisible(false);
		
		regBtn = new RoundedButton("상품코드입력");
		regBtn.setFont(new Font("나늠고딕", Font.PLAIN, 13));
		regBtn.setBounds(524, 570, 110, 30);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(cardlayout);		
		centerPanel.add(productView);
		centerPanel.setBounds(12, 0, 1148, 560);

		contentPanel.add(centerPanel);
		contentPanel.add(regBtn);
	}

}
