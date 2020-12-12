package stocksub.stockframe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import stocksub.Stock;
import stocksub.stockAction.Confirm_Action;
import stocksub.stockAction.Disposal_Action;
import stocksub.stockView.StockInfoView;
import stocksub.stockView.StockView;

public class StockInfoFrame extends JFrame{
	JButton confirm = new JButton("확인");
	JButton disposal = new JButton("폐기");
	public StockInfoView stockInfoView = null;
	public StockView stoview;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public StockInfoFrame(StockInfoView stockInfoView){
		
		this.stockInfoView = stockInfoView;
		
		setLayout(null);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("상품 정보");		
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
