package calc.BtnAction;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import calc.MainCalcFrame.CalcMainFrame;

import calc.add.Calc_Add_Date;
import main.MainFrame;


public class CalcBtnAction implements ActionListener{

	public MainFrame mainFrame;
	
	public CalcBtnAction(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		Object ob = e.getSource();

		if (ob == mainFrame.calcBtnPanel.calc_Btn) {
			new Calc_Add_Date(mainFrame.mem_id);
			JOptionPane.showMessageDialog(null, "[SYSTEM] 금일정산처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			mainFrame.calcBtnPanel.calc_Btn.setEnabled(false);
		} 

	}

	
	
	
}
