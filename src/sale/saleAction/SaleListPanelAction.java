package sale.saleAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import main.MainFrame;

public class SaleListPanelAction implements ActionListener{
	
	public MainFrame mainFrame;
	
	public SaleListPanelAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		//날짜로 검색할 때
		if(ob == mainFrame.saleListPanel.searchBtn) {
	
			if( mainFrame.saleListPanel.dateChooser1.getDate() == null
					|| mainFrame.saleListPanel.dateChooser2.getDate() == null) {

				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "[SYSTEM] 날짜를 지정해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}else {
				//초기화 해주기
				mainFrame.saleListPanel.tblModel.setNumRows(0);
				
				// 시간 설정
				String start_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.saleListPanel.dateChooser1.getDate());
				String end_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.saleListPanel.dateChooser2.getDate());
				
				//날짜로 검색
				mainFrame.saleListPanel.addSaleLine(mainFrame.sdao.salesList(start_dt, end_dt));

			}
			
			
		}
		
	}

}
