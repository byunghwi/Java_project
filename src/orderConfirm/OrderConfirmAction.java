package orderConfirm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import main.MainFrame;

public class OrderConfirmAction implements ActionListener {
	public MainFrame mainFrame;

	public OrderConfirmAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == mainFrame.stockBtnPanel.orderConfirmBtn) {
			// 이거 2줄은 그래프 중복현상이 발생해서 넣어둠
			mainFrame.orderConfirmView.model.setNumRows(0);
			mainFrame.orderConfirmView.addProductLine(mainFrame.orderConfirmDao.productAll());
			mainFrame.orderConfirmFrame.setVisible(true);
			// 그래프 행 선택시
			mainFrame.orderConfirmFrame.orderConfirmView.orderTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable j = (JTable) e.getSource();
					int row = j.getSelectedRow();
					if (row != -1) {
						String num = (String) mainFrame.orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 0);
						mainFrame.orderConfirmFrame.fields[0].setText(num);
						String name = (String) mainFrame.orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 5);
						mainFrame.orderConfirmFrame.fields[1].setText(name);
						String id = (String) mainFrame.orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 1);
						mainFrame.orderConfirmFrame.fields[2].setText(id);
						String price = (String) mainFrame.orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 6);
						mainFrame.orderConfirmFrame.fields[3].setText(price);
						String amount = (String) mainFrame.orderConfirmFrame.orderConfirmView.orderTable.getValueAt(row, 2);
						mainFrame.orderConfirmFrame.fields[4].setText(amount);
					}
				}
			});
		}
		
		// 승인 상품조회버튼
		if (ob == mainFrame.orderConfirmFrame.order_btn) {
			mainFrame.orderframe.setVisible(true);
			// 그래프 초기화
			mainFrame.orderframe.ov.model.setNumRows(0);
			mainFrame.orderframe.ov.addProductLine(mainFrame.orderDao.productAll());
			// 텍스트필드 초기화
			mainFrame.orderframe.resetText();
			// 그래프 행 선택시
			mainFrame.orderframe.ov.orderTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable j = (JTable) e.getSource();
					int row = j.getSelectedRow();
					if (row != -1) {
						String id = (String) mainFrame.orderframe.ov.orderTable.getValueAt(row, 0);
						mainFrame.orderframe.fields[0].setText(id);
						mainFrame.orderframe.fields[2].setText(mainFrame.mem_id); // 사용자 id가져옴
					}
				}
			});
		} 
		
		// 승인목록 승인버튼
		else if (ob == mainFrame.orderConfirmFrame.confirm_btn) {
			if(mainFrame.orderConfirmFrame.fields[4].getText().equals("") || 
					!Pattern.matches("^[0-9]*$", mainFrame.orderConfirmFrame.fields[4].getText())) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
			}  else {
				
				if(mainFrame.orderConfirmDao.confirmCheck(mainFrame.orderConfirmFrame.fields)) {
					// 그래프 갱신
					mainFrame.orderConfirmFrame.orderConfirmView.model.setNumRows(0);
					mainFrame.orderConfirmFrame.orderConfirmView.addProductLine(mainFrame.orderConfirmDao.productAll());
					JOptionPane.showMessageDialog(null, "승인 완료", "확인", JOptionPane.CLOSED_OPTION);
					
					mainFrame.stockPanel.tblModel.setNumRows(0);
					mainFrame.stockPanel.addStockLine(mainFrame.stockPanel.sdao.stockAll());
					
				} else {
					JOptionPane.showMessageDialog(null, "\t[SYSTEM] 오류가 발생하였습니다.", "확인", JOptionPane.CLOSED_OPTION);
				}
				
			}
			// 텍스트필드 초기화
			mainFrame.orderConfirmFrame.resetText();
		} 
		
		// 승인 삭제버튼
		else if (ob == mainFrame.orderConfirmFrame.delete_btn) { 
			if(mainFrame.orderConfirmFrame.fields[3].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "삭제할 목록을 선택해주세요", "확인", JOptionPane.CLOSED_OPTION);
			} else {
				mainFrame.orderConfirmDao.confirmCancle(mainFrame.orderConfirmFrame.fields);
				// 그래프 갱신
				mainFrame.orderConfirmFrame.orderConfirmView.model.setNumRows(0);
				mainFrame.orderConfirmFrame.orderConfirmView.addProductLine(mainFrame.orderConfirmDao.productAll());
				mainFrame.orderConfirmFrame.resetText();
			}
		} 
		
		// 승인 취소버튼
		else if (ob == mainFrame.orderConfirmFrame.cancel_btn) {
			mainFrame.orderConfirmFrame.dispose();
		}
	
		// 승인대기목록 검색버튼
		else if (ob == mainFrame.orderConfirmFrame.search_btn) {
			String fieldName = mainFrame.orderConfirmFrame.combo.getSelectedItem().toString();
			if (fieldName.equals("상품id")) {
	        	fieldName = "product_id";
	        } else if (fieldName.equals("상품명")) {
	        	fieldName = "product_name";
	        }
			if (mainFrame.orderConfirmFrame.search_jf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "정확히 입력해 주세요", "확인", JOptionPane.CLOSED_OPTION);
				mainFrame.orderConfirmFrame.search_jf.requestFocus();
				mainFrame.orderConfirmView.model.setNumRows(0);
				mainFrame.orderConfirmView.addProductLine(mainFrame.orderConfirmDao.productAll());
				mainFrame.orderConfirmFrame.resetText();
            } else {// 검색어를 입력했을경우
            	mainFrame.orderConfirmDao.getUserSearch(mainFrame.orderConfirmView.model, fieldName, mainFrame.orderConfirmFrame.search_jf.getText());
            }
		}
	}

}