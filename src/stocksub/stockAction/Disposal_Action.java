package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import stocksub.StockDao;
import stocksub.stockView.StockInfoView;
import stocksub.stockframe.StockInfoFrame;

public class Disposal_Action implements ActionListener{
	
	StockDao sdao =  new StockDao();
	StockInfoFrame stockInfoF;
	static int agree;
	
	public Disposal_Action(StockInfoFrame stockInfoF) {
		this.stockInfoF = stockInfoF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (stockInfoF.stockInfoView.stockTable.getSelectedRow() != -1) {
			
			// ������ ��
			int row = stockInfoF.stockInfoView.stockTable.getSelectedRow();
			String product_id = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 0));
			String dis_date = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 4));
			
			
			//JOptionPane.showConfirmDialog(null,"[SYSTEM] ���� ����Ͻðڽ��ϱ�?." )
			//JOptionPane.showMessageDialog(null, "[SYSTEM] ���� ����Ͻðڽ��ϱ�?.", "Ȯ��", JOptionPane.CLOSED_OPTION);
			
			sdao.Disposal_product(product_id, dis_date);
			stockInfoF.stockInfoView.tblModel.setNumRows(0);
			stockInfoF.stockInfoView.addStockLine(sdao.stockInfos(stockInfoF.stockInfoView.product_id));
			
			stockInfoF.stoview.tblModel.setNumRows(0);
			stockInfoF.stoview.addStockLine(sdao.stockAll());
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] ����Ϸ��� ��ǰ�� �������ּ���.", "Ȯ��", JOptionPane.CLOSED_OPTION);
		}
		
	}

}
