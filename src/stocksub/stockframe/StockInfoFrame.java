package stocksub.stockframe;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import stocksub.Stock;
import stocksub.stockView.StockInfoView;

public class StockInfoFrame extends JFrame{
	JButton confirm = new JButton("»Æ¿Œ");
	JButton disposal = new JButton("∆Û±‚");
	StockInfoView stiv = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Stock stock = new Stock();
	
	
	public StockInfoFrame(StockInfoView stiv){
		
		setLayout(null);
		setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		setTitle("¡¶«∞ ªÛºº ¡§∫∏");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(true);
		
		confirm.setBounds(220,330,70,20);
		disposal.setBounds(420,330,70,20);
		stiv.setBounds(12, 10, 700, 350);
		
		
		add(confirm);
		add(disposal);
		add(stiv);

	}
}
