package event.eventAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}

	}

}