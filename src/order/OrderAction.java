package order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import orderConfirm.OrderConfirmDao;
import orderConfirm.OrderConfirmFrame;
import orderConfirm.OrderConfirmView;

public class OrderAction implements ActionListener {
	
	OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
	OrderFrame orderframe = new OrderFrame();
	OrderConfirmDao orderConfirmDao = new OrderConfirmDao();
	OrderConfirmView orderConfirmView = new OrderConfirmView();
	OrderDao orderDao = new OrderDao();
	OrderView orderView = new OrderView();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		// 승인목록창에서 상품조회버튼 클릭시
		// 주문 주문버튼
		if (ob == orderframe.order_btn) {
			orderDao.moveconfirm(orderframe.fields);
			JOptionPane.showMessageDialog(null, "주문 완료", "확인", JOptionPane.CLOSED_OPTION);
			// 그래프 갱신
			orderConfirmFrame.orderConfirmView.model.setNumRows(0);
			orderConfirmFrame.orderConfirmView.addProductLine(orderConfirmDao.productAll());
			orderframe.resetText();
		} 
		// 주문 검색버튼
		else if (ob == orderframe.search_btn) {
			String fieldName = orderframe.combo.getSelectedItem().toString();
			if (fieldName.equals("상품id")) {
	        	fieldName = "product_id";
	        } else if (fieldName.equals("상품명")) {
	        	fieldName = "product_name";
	        }
			if (orderframe.search_jf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
                orderframe.search_jf.requestFocus();
                orderView.model.setNumRows(0);
    			orderView.addProductLine(orderDao.productAll());
            } else {// 검색어를 입력했을경우
                orderDao.getUserSearch(orderView.model, fieldName, orderframe.search_jf.getText());
                if (orderframe.search_jf.getText().length() < 2) {
                	JOptionPane.showMessageDialog(null, "2자이상 입력해주세요", "확인", JOptionPane.CLOSED_OPTION);
                	orderView.model.setNumRows(0);
         			orderView.addProductLine(orderDao.productAll());
                }
            }
			
		}	
		// 주문 취소버튼
		else if (ob == orderframe.cancel_btn) {
			orderframe.setVisible(false);
		}
	}

}
