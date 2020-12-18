package orderConfirm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import main.MainFrame;
import order.OrderDao;
import order.OrderFrame;
import order.OrderView;

public class OrderConfirmAction implements ActionListener {
	public MainFrame mainFrame;

	public OrderConfirmAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
//	MainFrame mainFrame;
	OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
	OrderFrame orderframe = new OrderFrame();
	OrderConfirmDao orderConfirmDao = new OrderConfirmDao();
	OrderConfirmView orderConfirmView = new OrderConfirmView();
	OrderDao orderDao = new OrderDao();
	OrderView orderView = new OrderView();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == mainFrame.stockBtnPanel.orderConfirmBtn) {
			// 이거 2줄은 그래프 중복현상이 발생해서 넣어둠
//			orderConfirmView.model.setNumRows(0);
//			orderConfirmView.addProductLine(orderConfirmDao.productAll());
			orderConfirmFrame.setVisible(true);
			// 그래프 행 선택시
			orderConfirmFrame.orderConfirmView.orderTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable j = (JTable) e.getSource();
					int row = j.getSelectedRow();
					if (row != -1) {
						String num = (String) orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 0);
						orderConfirmFrame.fields[0].setText(num);
						String name = (String) orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 5);
						orderConfirmFrame.fields[1].setText(name);
						String id = (String) orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 1);
						orderConfirmFrame.fields[2].setText(id);
						String amount = (String) orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 2);
						orderConfirmFrame.fields[4].setText(amount);
					}
				}
			});
		}
		// 승인 주문버튼
		if (ob == orderConfirmFrame.order_btn) { 
			orderframe.setVisible(true);
			// 그래프 초기화
			orderframe.ov.model.setNumRows(0);
			orderframe.ov.addProductLine(orderDao.productAll());
			// 그래프 행 선택시
			orderframe.ov.orderTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable j = (JTable) e.getSource();
					int row = j.getSelectedRow();
					if (row != -1) {
						String id = (String) orderframe.ov.orderTable.getValueAt(row, 0);
						orderframe.fields[0].setText(id);
					}
				}
			});
		} 
		// 승인목록 승인버튼
		else if (ob == orderConfirmFrame.confirm_btn) {
			if(orderConfirmFrame.fields[3].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
			} else if(orderConfirmFrame.fields[3].getText().equals("") || 
					!Pattern.matches("^[0-9]*$", orderConfirmFrame.fields[3].getText())) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
			}  else {
				orderConfirmDao.confirmCheck(orderConfirmFrame.fields);
				// 그래프 갱신
				orderConfirmFrame.orderConfirmView.model.setNumRows(0);
				orderConfirmFrame.orderConfirmView.addProductLine(orderConfirmDao.productAll());
				JOptionPane.showMessageDialog(null, "승인 완료", "확인", JOptionPane.CLOSED_OPTION);
			}
			// 초기화
			orderConfirmFrame.resetText();
		} 
		// 승인 삭제버튼
		else if (ob == orderConfirmFrame.delete_btn) { 
			orderConfirmDao.confirmCancle(orderConfirmFrame.fields);
			// 그래프 갱신
			orderConfirmFrame.orderConfirmView.model.setNumRows(0);
			orderConfirmFrame.orderConfirmView.addProductLine(orderConfirmDao.productAll());
		} // 승인 취소버튼
		else if (ob == orderConfirmFrame.cancel_btn) {
			orderConfirmFrame.setVisible(false);	
		}
		// 승인대기목록 검색버튼
		else if (ob == orderConfirmFrame.search_btn) {
			String fieldName = orderConfirmFrame.combo.getSelectedItem().toString();
			if (fieldName.equals("상품id")) {
	        	fieldName = "product_id";
	        } else if (fieldName.equals("상품명")) {
	        	fieldName = "product_name";
	        }
			if (orderConfirmFrame.search_jf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
				orderConfirmFrame.search_jf.requestFocus();
				orderConfirmView.model.setNumRows(0);
    			orderConfirmView.addProductLine(orderConfirmDao.productAll());
            } else {// 검색어를 입력했을경우
            	orderConfirmDao.getUserSearch(orderConfirmView.model, fieldName, orderConfirmFrame.search_jf.getText());
                if (orderConfirmFrame.search_jf.getText().length() < 2) {
                	JOptionPane.showMessageDialog(null, "2자이상 입력해주세요", "확인", JOptionPane.CLOSED_OPTION);
                	orderConfirmView.model.setNumRows(0);
        			orderConfirmView.addProductLine(orderConfirmDao.productAll());
                }
            }
		}
	}

}