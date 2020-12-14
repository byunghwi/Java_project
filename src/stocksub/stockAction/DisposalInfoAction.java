package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import stocksub.stockView.StockInfoView;
import stocksub.stockView.StockView;
import stocksub.stockframe.DisposalInfoFrame;
import stocksub.stockframe.StockFrame;

public class DisposalInfoAction implements ActionListener  {
	
	StockFrame sf;
	StockInfoView siv = null;
	StockView stoview = null;
	
	public DisposalInfoAction(StockFrame sf) {
		this.sf = sf;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new DisposalInfoFrame();
		
	}

}
