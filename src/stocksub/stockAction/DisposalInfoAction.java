package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import stocksub.stockView.StockInfoView;
import stocksub.stockView.StockView;
import stocksub.stockframe.DisposalInfoFrame;
import stocksub.stockframe.StockFrame;

// 폐기 정보에 대응하는 버튼 리스너
// 폐기 정보 프레임을 생성한다
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
