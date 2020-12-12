package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import stocksub.StockDao;
import stocksub.stockframe.StockInfoFrame;

public class Confirm_Action implements ActionListener {
	StockInfoFrame stockInfoF;
	StockDao sdao = new StockDao();
	
	public Confirm_Action(StockInfoFrame stockInfoF) {
		this.stockInfoF = stockInfoF;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		stockInfoF.dispose();
		
		
	}
	
}
