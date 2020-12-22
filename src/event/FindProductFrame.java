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
		setFont(new Font("나늠 고딕", Font.BOLD, 20));
		setTitle("상품리스트");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1170, 689);
		setVisible(false);
		
		regBtn = new RoundedButton("상품코드입력");
		regBtn.setFont(new Font("나늠 고딕", Font.PLAIN, 13));
		regBtn.setBounds(503, 610, 110, 30);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(cardlayout);		
		centerPanel.add(productView);
		centerPanel.setBounds(0, 0, 1160, 600);

		contentPanel.add(centerPanel);
		contentPanel.add(regBtn);
	}

}
