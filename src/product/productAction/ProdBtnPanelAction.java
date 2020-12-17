package product.productAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.MainFrame;

public class ProdBtnPanelAction implements ActionListener {
	public MainFrame mainFrame;

	public ProdBtnPanelAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();
		
		if (ob == mainFrame.prodBtnPanel.registProdBtn) {
			mainFrame.prodRegistFrame.resetText();
			mainFrame.prodRegistFrame.setVisible(true);
		} else if (ob == mainFrame.prodBtnPanel.editProdBtn) {
			if (mainFrame.productView.productTable.getSelectedRow() != -1) {
				mainFrame.prodEditFrame.setVisible(true);

				// 선택한 행
				int row = mainFrame.productView.productTable.getSelectedRow();

				// 선택한 행 내용 수정 프레임창에 세팅해주기
				mainFrame.prodEditFrame.tf1.setText((String) mainFrame.productView.tblModel.getValueAt(row, 1));
				mainFrame.prodEditFrame.tf2.setText((String) mainFrame.productView.tblModel.getValueAt(row, 2));
				// prodEditFrame.tf3.setText((String) productView.tblModel.getValueAt(row, 5));

			} else {
				JOptionPane.showMessageDialog(null, "[SYSTEM] 수정하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		} else if (ob == mainFrame.prodBtnPanel.delProdBtn) { // 우측패널 상품 삭제 버튼 클릭시
			if (mainFrame.productView.productTable.getSelectedRow() != -1) {
				int row = mainFrame.productView.productTable.getSelectedRow();
				String product_id = (String) mainFrame.productView.tblModel.getValueAt(row, 0);

				// DB 삭제
				mainFrame.pdao.productDel(product_id);

				// 상품목록 화면테이블 초기화 해주기.
				mainFrame.productView.tblModel.setNumRows(0);

				// 상품목록 화면테이블 새로 채우기
				mainFrame.productView.addProductLine(mainFrame.pdao.productAll());

				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제가 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			} else {
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}
		}
	}
}
