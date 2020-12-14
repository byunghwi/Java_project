package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import stocksub.StockDao;
import stocksub.stockframe.StockInfoFrame;

// 폐기에 대응하는 액션 리스너
public class Disposal_Action implements ActionListener{
	
	StockDao sdao =  new StockDao();
	StockInfoFrame stockInfoF;
	static int agree;
	
	public Disposal_Action(StockInfoFrame stockInfoF) {
		this.stockInfoF = stockInfoF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 선택한 로우가 존재할때만 작동한다
		if (stockInfoF.stockInfoView.stockTable.getSelectedRow() != -1) {
			
			// 폐기를 하기 전 확인을 받는다
			agree =  JOptionPane.showConfirmDialog(null,"     정말 폐기하시겠습니까?","확인",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			
			// 선택한 로우의 정보를 받아온다
			int row = stockInfoF.stockInfoView.stockTable.getSelectedRow();
			String product_id = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 0));
			String quantity = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 2));
			String manu_date = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 3));
			String dis_date = ((String) stockInfoF.stockInfoView.tblModel.getValueAt(row, 4));
			System.out.println(manu_date);
			
			// 폐기에 동의하면 폐기가 진행된다
			if (agree == JOptionPane.YES_OPTION) {
				sdao.send_disposal_table(product_id,manu_date,dis_date,quantity);
				
				
				sdao.disposal_product(product_id, dis_date);
				
				// 폐기가 완료되면 테이블을 갱신한다
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


