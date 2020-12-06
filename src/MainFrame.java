import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProductView;

public class MainFrame extends JFrame implements ActionListener{
	
	ProductView productView = new ProductView();
	
	//오른쪽 버튼들 보여줄 패널
	RightBtnPanel rightBtnPanel = new RightBtnPanel();
	
	public CardLayout cardlayout;
	public CardLayout btn;
	

	public JPanel contentPanel;
	
	public JPanel pView;
	public JPanel pBtnView;
	
	public MainFrame() {
		
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("편의점프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 753);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		pView = new JPanel();
		pView.setBackground(new Color(255, 255, 255));
		pView.setBounds(0, 50, 1157, 552);
		pView.add(productView);
		contentPanel.add(pView);
		pView.setLayout(cardlayout);

		
		pBtnView = new JPanel();
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1156, 50, 164, 675);
		pBtnView.add(rightBtnPanel);
		contentPanel.add(pBtnView);
		pBtnView.setLayout(cardlayout);

		
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
