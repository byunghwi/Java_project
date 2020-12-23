package calc.BtnAction;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import calc.Calc;
import calc.CalcDao;
import calc.MainCalcFrame.CalcMainFrame;

import calc.add.Calc_Add_Date;
import calc.add.check_Calc;
import main.MainFrame;


public class CalcBtnAction implements ActionListener{

	public MainFrame mainFrame;
	
	public ArrayList<Calc> cl = null;
	
	SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
	
	Date date=new Date();
	

	
	
	public CalcBtnAction(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		Object ob = e.getSource();
		
		if (ob == mainFrame.calcBtnPanel.calc_Btn) {
			new check_Calc(mainFrame.mem_id);
			mainFrame.calcPanel.CalcModel.setNumRows(0);
			cl = new CalcDao(dcn.format(date),dcn.format(date)).calclist();
			mainFrame.calcPanel.addCalcLine(cl);
			//mainFrame.calcBtnPanel.calc_Btn.setEnabled(false);
			
		} 

	}

	
	
	
}
