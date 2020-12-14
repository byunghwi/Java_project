package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import stocksub.StockDao;
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
			
			agree =  JOptionPane.showConfirmDialog(null,"     정말 폐기하시겠습니까?","확인",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

			int row = stockInfoF.stockInfoView.stockTable.getSelectedRow();
			String product_id = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 0));
			String quantity = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 2));
			String manu_date = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 3));
			String dis_date = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 4));
			System.out.println(manu_date);
			
			
			if (agree == JOptionPane.YES_OPTION) {
				sdao.send_disposal_table(product_id,manu_date,dis_date,quantity);
				
				
				sdao.disposal_product(product_id, dis_date);
				
				stockInfoF.stockInfoView.tblModel.setNumRows(0);
				stockInfoF.stockInfoView.addStockLine(sdao.stockInfos(stockInfoF.stockInfoView.product_id));
				
				stockInfoF.stoview.tblModel.setNumRows(0);
				stockInfoF.stoview.addStockLine(sdao.stockAll());
			} else {
				
			}
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
		}
		
	}

}


