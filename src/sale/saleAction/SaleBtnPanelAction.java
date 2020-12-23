package sale.saleAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;

public class SaleBtnPanelAction implements ActionListener{
	
	public MainFrame mainFrame;

	public SaleBtnPanelAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == mainFrame.saleBtnPanel.saleBtn) {
			// 필드 초기화 먼저.
			mainFrame.salePanel.prodnameTf.setText("");
			mainFrame.salePanel.prodQt.setText("");
			//재고화면 장바구니화면 초기화
			mainFrame.salePanel.bucketTblModel.setNumRows(0);
			mainFrame.salePanel.stockTblModel.setNumRows(0);
			
			//재고화면 로우 새로 받아오기.
			mainFrame.salePanel.addStockLine(mainFrame.stockdao.stockAll());
			
			mainFrame.cardlayout.show(mainFrame.centerView, "salePanel"); // 가운데 화면 변경
		}
		else if(ob == mainFrame.saleBtnPanel.saleListBtn) { // 판매리스트 버튼 눌렀을 때
			mainFrame.saleListPanel.tblModel.setNumRows(0);
	        mainFrame.saleListPanel.addSaleLine(mainFrame.sdao.salesList(null, null));
	        
			mainFrame.cardlayout.show(mainFrame.centerView, "saleListPanel");	// 가운데 화면 변경
	
		}
		
	}

}
