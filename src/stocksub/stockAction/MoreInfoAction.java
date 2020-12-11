package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import stocksub.StockInfoFrame;
import stocksub.stockView.StockInfoView;
import stocksub.stockframe.MainFrame;

public class MoreInfoAction implements ActionListener {
	
	MainFrame m1;
	StockInfoView siv = null;
	
	public MoreInfoAction(MainFrame m1) {
		this.m1 = m1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (m1.stockView.stockTable.getSelectedRow() != -1) {
			
			// ������ ��
			int row = m1.stockView.stockTable.getSelectedRow();
			
			siv = new StockInfoView((String) m1.stockView.tblModel.getValueAt(row, 0));
			
			StockInfoFrame stif = new StockInfoFrame(siv);
			
			

		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] Ȯ���Ϸ��� ��ǰ�� �������ּ���.", "Ȯ��", JOptionPane.CLOSED_OPTION);
		}

		
		
	}

}
