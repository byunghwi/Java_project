import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import product.ProductView;

public class MainFrame extends JFrame implements ActionListener{
	ProductView productView = new ProductView();
	CardLayout cardlayout;
	
	public JPanel pView;
	
	public MainFrame() {
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("편의점프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		

		pView = new JPanel();
		cardlayout = new CardLayout();
		pView.setBackground(new Color(255, 255, 255));
		pView.add(productView);
		pView.setLayout(cardlayout);
		
		add(pView);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
