package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import stocksub.stockView.StockInfoView;
import stocksub.stockView.StockView;
import stocksub.stockframe.StockFrame;
import stocksub.stockframe.StockInfoFrame;

public class MoreInfoAction implements ActionListener {
	
	StockFrame sf;
	StockInfoView siv = null;
	StockView stoview = null;
	
	public MoreInfoAction(StockFrame sf) {
		this.sf = sf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (sf.stockView.stockTable.getSelectedRow() != -1) {
			stoview = sf.stockView;

			
			int row = sf.stockView.stockTable.getSelectedRow();
			
			siv = new StockInfoView((String) sf.stockView.tblModel.getValueAt(row, 0));
			
			StockInfoFrame stif = new StockInfoFrame(siv);
			stif.stoview = this.stoview;
			
			
		
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
		}

		
	}

}
