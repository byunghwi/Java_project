package event.eventAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import common.CheckValid;
import event.Event;
import main.MainFrame;

public class EventRegistFrameAction implements ActionListener {
	public MainFrame mainFrame;
	CheckValid chkValid = new CheckValid();

	public EventRegistFrameAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.eventRegistFrame.regBtn) {
			
			String product_id = mainFrame.eventRegistFrame.tf1.getText();
			String event_type = (String) mainFrame.eventRegistFrame.combo.getSelectedItem();
//			System.out.println("product_id > " + product_id);
//			System.out.println("event_type > " + event_type);
//			System.out.println("dateChooser1 > " + (Object)mainFrame.eventRegistFrame.dateChooser1.getDate());
//			System.out.println("dateChooser2 > " + (Object) mainFrame.eventRegistFrame.dateChooser2.getDate());
//			System.out.println("체크 product_id > " + chkValid.isStrEmpty(product_id));
//			 String a = ((Object)mainFrame.eventRegistFrame.dateChooser1.getDate()==null)?"널임":"아님";
//			 String b = ((Object)mainFrame.eventRegistFrame.dateChooser2.getDate()==null)?"널임":"아님";
//			System.out.println("체크 dateChooser1 > " + a);
//			System.out.println("체크 dateChooser2 > " + b);
//			System.out.println("체크 event_type > " + chkValid.isStrEmpty(event_type));
			
			//유효성 검사
			if ((chkValid.isStrEmpty(product_id) || product_id.equals("상품코드를 입력하세요")) || ((Object)mainFrame.eventRegistFrame.dateChooser1.getDate()==null)
					|| ((Object)mainFrame.eventRegistFrame.dateChooser2.getDate()==null) || chkValid.isStrEmpty(event_type)) {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "[SYSTEM] 모든 항목을 입력해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			} else {
				mainFrame.event = new Event();
				// 시간 설정
				String start_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.eventRegistFrame.dateChooser1.getDate());
				String end_dt = new SimpleDateFormat("yyyy-MM-dd")
						.format(mainFrame.eventRegistFrame.dateChooser2.getDate());

				mainFrame.event.setProduct_id(product_id);
				mainFrame.event.setEvent_type(event_type);
				mainFrame.event.setStart_date(start_dt);
				mainFrame.event.setEnd_date(end_dt);
				mainFrame.event.setWorker_no(mainFrame.mem_id);

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
					mainFrame.eventRegistFrame.dispose();
				} else {
					// 확인 팝업창
					JOptionPane.showMessageDialog(null, "[SYSTEM] 이벤트 등록 중 오류가 발생했습니다.", "확인",
							JOptionPane.CLOSED_OPTION);
				}
			}

		} else if (ob == mainFrame.eventRegistFrame.cancelBtn) {
			mainFrame.eventRegistFrame.resetText();
			mainFrame.eventRegistFrame.dispose();

		} else if (ob == mainFrame.eventRegistFrame.searchBtn) { // 이벤트 등록 프레임 -> 상품 찾기 프레임 오픈 시
			mainFrame.findProductFrame.productView.tblModel.setNumRows(0);
			mainFrame.findProductFrame.productView.addProductLine(mainFrame.pdao.productAll());
			
			mainFrame.findProductFrame.setVisible(true);
		}
	}

}
