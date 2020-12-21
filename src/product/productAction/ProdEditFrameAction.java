package product.productAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.MainFrame;
import product.Product;

public class ProdEditFrameAction implements ActionListener {
	public MainFrame mainFrame;

	public ProdEditFrameAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.prodEditFrame.compEditBtn) {

			int row = mainFrame.productView.productTable.getSelectedRow();
			String product_id = (String) mainFrame.productView.tblModel.getValueAt(row, 0);
			mainFrame.product = new Product();
			mainFrame.product.setProduct_id(product_id);
			mainFrame.product.setProduct_name(mainFrame.prodEditFrame.tf1.getText());
			mainFrame.product.setPrice(Integer.parseInt(mainFrame.prodEditFrame.tf2.getText()));

			// DB 수정
			mainFrame.pdao.productEdit(mainFrame.product);

			// 상품목록 화면테이블 초기화 해주기.
			mainFrame.productView.tblModel.setNumRows(0);

			// 상품목록 화면테이블 새로 채우기
			mainFrame.productView.addProductLine(mainFrame.pdao.productAll());

			// 텍스트 필드에 채워진 값 초기화 해주기.
			mainFrame.prodEditFrame.resetText();

			// 확인 팝업창
			JOptionPane.showMessageDialog(null, "\t[SYSTEM] 수정이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			// 창 안보이게
			//mainFrame.prodEditFrame.setVisible(false);
			mainFrame.prodEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else if (ob == mainFrame.prodEditFrame.cancelEidtBtn) {
			mainFrame.prodEditFrame.resetText();
			//mainFrame.prodEditFrame.setVisible(false);
			mainFrame.prodEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

}
