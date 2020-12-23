package stock.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import stock.stockView.StockInfoView;
import stock.stockView.StockView;
import stock.stockframe.DisposalInfoFrame;

// 폐기 정보에 대응하는 버튼 리스너
// 폐기 정보 프레임을 생성한다
public class DisposalInfoAction implements ActionListener  {
	
	MainFrame sf;
	StockInfoView siv = null;
	StockView stoview = null;
	
	public DisposalInfoAction(MainFrame sf) {
		this.sf = sf;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new DisposalInfoFrame();
		
	}

}
