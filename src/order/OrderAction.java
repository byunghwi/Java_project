package order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.MainFrame;

public class OrderAction implements ActionListener {
	public MainFrame mainFrame;

	public OrderAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		// 승인목록창에서 상품조회버튼 클릭시
		// 주문 주문버튼
		if (ob == mainFrame.orderframe.order_btn) {
			if (mainFrame.orderframe.fields[1].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "수량을 입력해주세요", "확인", JOptionPane.CLOSED_OPTION);
			} else {
				mainFrame.orderDao.moveconfirm(mainFrame.orderframe.fields);
				JOptionPane.showMessageDialog(null, "주문 완료", "확인", JOptionPane.CLOSED_OPTION);
				// 그래프 갱신
				mainFrame.orderConfirmFrame.orderConfirmView.model.setNumRows(0);
				mainFrame.orderConfirmFrame.orderConfirmView.addProductLine(mainFrame.orderConfirmDao.productAll());
				mainFrame.orderframe.resetText();
			}
		} 
		// 주문 검색버튼
		else if (ob == mainFrame.orderframe.search_btn) {
			String fieldName = mainFrame.orderframe.combo.getSelectedItem().toString();
			if (fieldName.equals("상품id")) {
	        	fieldName = "product_id";
	        } else if (fieldName.equals("상품명")) {
	        	fieldName = "product_name";
	        }
			if (mainFrame.orderframe.search_jf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
				mainFrame.orderframe.search_jf.requestFocus();
				mainFrame.orderView.model.setNumRows(0);
				mainFrame.orderView.addProductLine(mainFrame.orderDao.productAll());
				mainFrame.orderframe.resetText();
            } else {// 검색어를 입력했을경우
            	mainFrame.orderDao.getUserSearch(mainFrame.orderView.model, fieldName, mainFrame.orderframe.search_jf.getText());
            }
		}	
		// 주문 취소버튼
		else if (ob == mainFrame.orderframe.cancel_btn) {
			mainFrame.orderframe.dispose();
		}
	}

}
