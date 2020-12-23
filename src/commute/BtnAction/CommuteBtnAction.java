package commute.BtnAction;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import commute.Action.Add_Commute_Off_Time;
import commute.Action.Check_on_Time;
import commute.List.List_Input;

import main.MainFrame;

public class CommuteBtnAction implements ActionListener{

	public MainFrame mainFrame;
	
	public CommuteBtnAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == mainFrame.commuteBtnPanel.on_timeBtn) {
			new Check_on_Time(mainFrame.mem_id);
			mainFrame.commutePanel.tblModel.setNumRows(0);
			mainFrame.commutePanel.addCommuteLine(mainFrame.timedao.commute_Time());
			
		} else if (ob ==  mainFrame.commuteBtnPanel.off_timeBtn) {
			new Add_Commute_Off_Time(mainFrame.mem_id);
			mainFrame.commutePanel.tblModel.setNumRows(0);
			mainFrame.commutePanel.addCommuteLine(mainFrame.timedao.commute_Time());
			JOptionPane.showMessageDialog(null, "[SYSTEM] 퇴근처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
		} else {
			List_Input Li  = new List_Input(mainFrame);
			Li.cv = this.mainFrame.commutePanel;
			
		
		} 
	}
	
}
