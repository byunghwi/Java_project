package calc.BtnAction;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import calc.MainCalcFrame.CalcMainFrame;
import calc.MainCalcFrame.Calc_Reference_Btn;
import calc.add.Calc_Add_Date;


public class CalcBtnAction implements ActionListener{

	public CalcMainFrame cmf2=null;
	
	public CalcBtnAction(CalcMainFrame cmf2) {
		this.cmf2=cmf2;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		Object ob = e.getSource();

		if (ob == cmf2.calcBtnPanel.calc_Btn) {
			new Calc_Add_Date();
			JOptionPane.showMessageDialog(null, "[SYSTEM] 금일정산처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			cmf2.calcBtnPanel.calc_Btn.setEnabled(false);
		} 

	}

	
	
	
}
