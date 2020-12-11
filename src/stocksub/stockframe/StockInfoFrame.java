package stocksub.stockframe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import stocksub.Stock;
import stocksub.stockAction.Confirm_Action;
import stocksub.stockAction.Disposal_Action;
import stocksub.stockView.StockInfoView;

public class StockInfoFrame extends JFrame{
	JButton confirm = new JButton("»Æ¿Œ");
	JButton disposal = new JButton("∆Û±‚");
	public StockInfoView stockInfoView = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public StockInfoFrame(StockInfoView stockInfoView){
		
		this.stockInfoView = stockInfoView;
		
		setLayout(null);
		setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		setTitle("¡¶«∞ ªÛºº ¡§∫∏");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(true);
		
		confirm.setBounds(220,330,70,20);
		disposal.setBounds(420,330,70,20);
		stockInfoView.setBounds(12, 10, 700, 350);
		
		
		add(confirm);
		add(disposal);
		add(stockInfoView);
		
		confirm.addActionListener(new Confirm_Action(this));
		disposal.addActionListener(new Disposal_Action(this));
		
		
	}
}
