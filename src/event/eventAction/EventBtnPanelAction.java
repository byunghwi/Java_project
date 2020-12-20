package event.eventAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.MainFrame;

public class EventBtnPanelAction implements ActionListener {
	public MainFrame mainFrame;

	public EventBtnPanelAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.eventBtnPanel.eventRegBtn) { // 이벤트 등록 버튼 클릭시
			mainFrame.eventRegistFrame.resetText();
			mainFrame.eventRegistFrame.setVisible(true);
		}else if(ob == mainFrame.eventBtnPanel.eventDelBtn) {
			int row = mainFrame.eventPanel.eventTable.getSelectedRow();
	
			if(row != -1) {
				int rs = JOptionPane.showConfirmDialog(null, "\t[SYSTEM] 정말 삭제하시겠습니까?", null, JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE, null);
				
				if (rs == 0) {
					String event_no = String.valueOf(mainFrame.eventPanel.eventTable.getValueAt(row, 0));
					mainFrame.eventdao.eventDel(event_no);
					// 이벤트목록 화면테이블 초기화 해주기.
					mainFrame.eventPanel.tblModel.setNumRows(0);
					mainFrame.eventPanel.addEventLine(mainFrame.eventdao.eventAll());
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제하시려는 행을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}
			
		}

	}

}