package commute.BtnAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import commute.Action.Add_Commute_Off_Time;
import commute.Action.Check_on_Time;
import commute.List.List_Input;
import commute.MainCommuteFrame.CommuteMainFrame;

public class CommuteBtnAction implements ActionListener{

	public CommuteMainFrame cmf1=null;
	
	public CommuteBtnAction(CommuteMainFrame cmf1) {
		this.cmf1=cmf1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == cmf1.rightBtnPanel.on_timeBtn) {
			new Check_on_Time();
			cmf1.tv.tblModel.setNumRows(0);
			cmf1.tv.addCommuteLine(cmf1.tdao.commute_Time());
			JOptionPane.showMessageDialog(null, "[SYSTEM] 출근처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
		} else if (ob ==  cmf1.rightBtnPanel.off_timeBtn) {
			new Add_Commute_Off_Time();
			cmf1.tv.tblModel.setNumRows(0);
			cmf1.tv.addCommuteLine(cmf1.tdao.commute_Time());
			JOptionPane.showMessageDialog(null, "[SYSTEM] 퇴근처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
		} else {
			List_Input Li  = new List_Input();
			Li.cv = this.cmf1.tv;
			
		
		} 
	}
	
}
