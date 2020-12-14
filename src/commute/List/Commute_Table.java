package commute.List;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProductView;

public class Commute_Table extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Commute_ListView cv = null;
	
	public CardLayout cardlayout;
	public CardLayout btn;

	public JPanel contentPanel;

	public JPanel pView;
	public JPanel pBtnView;
	public JPanel topView;
	
	
	public Commute_Table(String start_date,String end_date,String mem_name) {
		
	
		cv = new Commute_ListView(start_date, end_date, mem_name);
		
		cardlayout = new CardLayout();

		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("근태목록");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 753);
		setVisible(true);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);


		// 가운데 패널부분
		pView = new JPanel();
		pView.add(cv, "Commute_View");
		pView.setBackground(Color.WHITE);
		pView.setBounds(0, 50, 1157, 552);
		pView.setLayout(cardlayout);
		contentPanel.add(pView);


		
	}

}
