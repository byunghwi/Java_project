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
			// ������ ��
			int row = m1.stockView.stockTable.getSelectedRow();
			
			// ������ �� ���� ���� ������â�� �������ֱ�
			//m1.stockInfoFrame.tf1.setText((String) m1.stockView.tblModel.getValueAt(row, 1));
			
			siv = new StockInfoView((String) m1.stockView.tblModel.getValueAt(row, 0));
			
			m1.stockInfoFrame.add(siv);
			siv.setVisible(true);


		} else {
			JOptionPane.showMessageDialog(null, "[SYSTEM] Ȯ���Ϸ��� ��ǰ�� �������ּ���.", "Ȯ��", JOptionPane.CLOSED_OPTION);
		}

		
		
	}

}
