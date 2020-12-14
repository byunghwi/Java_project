package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import stocksub.stockView.StockInfoView;
import stocksub.stockView.StockView;
import stocksub.stockframe.StockFrame;
import stocksub.stockframe.StockInfoFrame;

// 상세정보에 대응하는 액션 리스너
public class MoreInfoAction implements ActionListener {
	
	StockFrame sf;
	StockInfoView siv = null;
	StockView stoview = null;
	
	public MoreInfoAction(StockFrame sf) {
		this.sf = sf;
	}
	
	// 선택된 행이 존재할때만 작동한다
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (sf.stockView.stockTable.getSelectedRow() != -1) {
			stoview = sf.stockView;

			
			int row = sf.stockView.stockTable.getSelectedRow();
			
			// 행에 대한 정보를 받아 상세정보 프레임을 생성한다
			siv = new StockInfoView((String) sf.stockView.tblModel.getValueAt(row, 0));
			
			StockInfoFrame stif = new StockInfoFrame(siv);
			stif.stoview = this.stoview;
			
			
		
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
		}

		
	}

}
