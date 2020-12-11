package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import stocksub.stockView.StockInfoView;
import stocksub.stockframe.StockFrame;
import stocksub.stockframe.StockInfoFrame;

public class MoreInfoAction implements ActionListener {
	
	StockFrame sf;
	StockInfoView siv = null;
	
	public MoreInfoAction(StockFrame sf) {
		this.sf = sf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (sf.stockView.stockTable.getSelectedRow() != -1) {
			
			// ������ ��
			int row = sf.stockView.stockTable.getSelectedRow();
			
			siv = new StockInfoView((String) sf.stockView.tblModel.getValueAt(row, 0));
			
			StockInfoFrame stif = new StockInfoFrame(siv);
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] Ȯ���Ϸ��� ��ǰ�� �������ּ���.", "Ȯ��", JOptionPane.CLOSED_OPTION);
		}

		
	}

}
