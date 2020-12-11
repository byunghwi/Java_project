package stocksub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import account.fr.MainFrame;

public class MoreInfoAction implements ActionListener {
	
	MainFrame m1;
	StockInfoView siv = null;
	
	public MoreInfoAction(MainFrame m1) {
		this.m1 = m1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (m1.stockView.stockTable.getSelectedRow() != -1) {
			m1.stockInfoFrame.setVisible(true);
			// 선택한 행
			int row = m1.stockView.stockTable.getSelectedRow();
			
			// 선택한 행 내용 수정 프레임창에 세팅해주기
			//m1.stockInfoFrame.tf1.setText((String) m1.stockView.tblModel.getValueAt(row, 1));
			
			siv = new StockInfoView((String) m1.stockView.tblModel.getValueAt(row, 0));
			
			m1.stockInfoFrame.add(siv);
			siv.setVisible(true);


		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] 확인하려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
		}

		
		
	}

}
