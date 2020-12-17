package event.eventAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import event.Event;
import main.MainFrame;

public class eventRegistFrameAction implements ActionListener {
	public MainFrame mainFrame;

	public eventRegistFrameAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.eventRegistFrame.regBtn) {

			if (mainFrame.eventRegistFrame.tf1.getText().equals("")
					|| mainFrame.eventRegistFrame.dateChooser1.toString().equals("")
					|| mainFrame.eventRegistFrame.dateChooser2.toString().equals("")) {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "[SYSTEM] 모든 항목을 입력해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			} else {
				mainFrame.event = new Event();

				// 시간 설정
				String start_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.eventRegistFrame.dateChooser1.getDate());
				String end_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.eventRegistFrame.dateChooser2.getDate());

				mainFrame.event.setProduct_id(mainFrame.eventRegistFrame.tf1.getText());
				mainFrame.event.setEvent_type((String) mainFrame.eventRegistFrame.combo.getSelectedItem());
				mainFrame.event.setStart_date(start_dt);
				mainFrame.event.setEnd_date(end_dt);
				mainFrame.event.setWorker_no("TEST");

				if (mainFrame.eventdao.eventAdd(mainFrame.event)) {
					// 이벤트목록 화면테이블 초기화 해주기.
					mainFrame.eventPanel.tblModel.setNumRows(0);

					// 이벤트목록 화면테이블 새로 채우기
					mainFrame.eventPanel.addEventLine(mainFrame.eventdao.eventAll());

					// 텍스트 필드에 채워진 값 초기화 해주기.
					mainFrame.eventRegistFrame.resetText();

					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "[SYSTEM] 이벤트 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

					// 창 안보이게
					mainFrame.eventRegistFrame.setVisible(false);
				} else {
					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "[SYSTEM] 이벤트 등록 중 오류가 발생했습니다.", "확인",
							JOptionPane.CLOSED_OPTION);
				}
			}

		} else if (ob == mainFrame.eventRegistFrame.cancelBtn) {
			mainFrame.eventRegistFrame.resetText();
			mainFrame.eventRegistFrame.setVisible(false);
		} else if (ob == mainFrame.eventRegistFrame.searchBtn) { // 이벤트 등록 프레임 -> 상품 찾기 프레임 오픈 시
			mainFrame.findProductFrame.setVisible(true);

		}
	}

}
