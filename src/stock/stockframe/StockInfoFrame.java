package stock.stockframe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import common.RoundedButton;
import stock.stockAction.Confirm_Action;
import stock.stockAction.Disposal_Action;
import stock.stockView.StockInfoView;
import stock.stockView.StockView;

// 상품 상세 정보에 대한 프레임
public class StockInfoFrame extends JFrame{
	RoundedButton confirm = new RoundedButton("확인");
	RoundedButton disposal = new RoundedButton("폐기");
	public StockInfoView stockInfoView = null;
	public StockView stoview;


	private static final long serialVersionUID = 1L;

	
	
	public StockInfoFrame(StockInfoView stockInfoView){
		
		
		
		this.stockInfoView = stockInfoView;
		
		setLayout(null);
		setFont(new Font("나눔고딕", Font.BOLD, 20));
		setTitle("상품 정보");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(true);
		
		confirm.setBounds(200,325,80,30);
		disposal.setBounds(400,325,80,30);
		stockInfoView.setBounds(12, 10, 700, 350);
		
		
		add(confirm);
		add(disposal);
		add(stockInfoView);
		
		confirm.addActionListener(new Confirm_Action(this));
		disposal.addActionListener(new Disposal_Action(this));
		
		
		
		
	}
	
}
