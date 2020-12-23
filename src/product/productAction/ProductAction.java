package product.productAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import common.CheckValid;
import main.MainFrame;
import product.Product;
import event.FindProductFrame;

public class ProductAction implements ActionListener {

	public MainFrame mainFrame;
	CheckValid chkValid = new CheckValid();

	public ProductAction(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == mainFrame.prodRegistFrame.regBtn) {
			String product_id = mainFrame.prodRegistFrame.tf1.getText();
			String price = mainFrame.prodRegistFrame.tf3.getText();
			
			//유효성 체크
			if(chkValid.isAlphaNum(product_id) && chkValid.isNumeric(price)) {
				mainFrame.product = new Product();

				mainFrame.product.setProduct_id(product_id);
				mainFrame.product.setProduct_name(mainFrame.prodRegistFrame.tf2.getText());
				mainFrame.product.setPrice(Integer.parseInt(price));
				mainFrame.product.setWorker_no(mainFrame.mem_id);
				
				mainFrame.pdao.productAdd(mainFrame.product);

				// 상품목록J테이블 초기화 해주기.
				mainFrame.productView.tblModel.setNumRows(0);

				// 상품목록J테이블 새로 채우기
				mainFrame.productView.addProductLine(mainFrame.pdao.productAll());

				// 텍스트 필드에 채워진 값 초기화 해주기.
				mainFrame.prodRegistFrame.resetText();

				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "[SYSTEM] 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

				// 창 안보이게
				mainFrame.prodRegistFrame.dispose();
			}else {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "[SYSTEM] 정확한 값을 입력해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		} else if (ob == mainFrame.prodRegistFrame.cancelBtn) {
			//창 안보이게
			mainFrame.prodRegistFrame.dispose();
	
		} else if (ob == mainFrame.productView.searchBtn || ob == mainFrame.findProductFrame.productView.searchBtn) { // 상품
																												// 때
			// 상품리스트화면에서 검색할때
			if (ob == mainFrame.productView.searchBtn) {
				String combo = (String) mainFrame.productView.jcombo.getSelectedItem();
				String searchWord = mainFrame.productView.searchTf.getText();

				// 검색어 없이 검색했을땐 원래 모든 상품리스트 다 보여주기.
				if (searchWord.equals("검색어를 입력하세요.") || searchWord.equals("")) {

					// 상품목록J테이블 초기화 해주기.
					mainFrame.productView.tblModel.setNumRows(0);

					mainFrame.productView.addProductLine(mainFrame.pdao.productAll());
				} else {
					if (searchWord.length() < 2) {
						JOptionPane.showMessageDialog(null, "[SYSTEM] 검색어는 2글자 이상 입력해주세요.", "확인",
								JOptionPane.CLOSED_OPTION);
					} else {
						// 상품목록J테이블 초기화 해주기.
						mainFrame.productView.tblModel.setNumRows(0);

						// 상품목록J테이블 새로 채우기
						mainFrame.productView.addProductLine(mainFrame.pdao.searchProduct(combo, searchWord));
					}
				}
			}
			// 이벤트 프레임에서 상품 검색할 때
			else if (ob == mainFrame.findProductFrame.productView.searchBtn) {
				String combo = (String) mainFrame.findProductFrame.productView.jcombo.getSelectedItem();
				String searchWord = mainFrame.findProductFrame.productView.searchTf.getText();

				// 검색어 없이 검색했을땐 원래 모든 상품리스트 다 보여주기.
				if (searchWord.equals("검색어를 입력하세요.") || searchWord.equals("")) {

					// 상품목록J테이블 초기화 해주기.
					mainFrame.findProductFrame.productView.tblModel.setNumRows(0);

					mainFrame.findProductFrame.productView.addProductLine(mainFrame.pdao.productAll());
				} else {
					if (searchWord.length() < 2) {
						JOptionPane.showMessageDialog(null, "[SYSTEM] 검색어는 2글자 이상 입력해주세요.", "확인",
								JOptionPane.CLOSED_OPTION);
					} else {
						// 상품목록J테이블 초기화 해주기.
						mainFrame.findProductFrame.productView.tblModel.setNumRows(0);

						// 상품목록J테이블 새로 채우기
						mainFrame.findProductFrame.productView
								.addProductLine(mainFrame.pdao.searchProduct(combo, searchWord));
					}
				}
			}
		} else if (ob == mainFrame.prodEditFrame.compEditBtn) {

			int row = mainFrame.productView.productTable.getSelectedRow();
			String product_id = (String) mainFrame.productView.tblModel.getValueAt(row, 0);
			String product_name = mainFrame.prodEditFrame.tf1.getText();
			String price = mainFrame.prodEditFrame.tf2.getText();
			
			//유효성 추가.
			if(!chkValid.isStrEmpty(product_id) && !chkValid.isStrEmpty(product_name) && chkValid.isNumeric(price)) {
				mainFrame.product = new Product();
				mainFrame.product.setProduct_id(product_id);
				mainFrame.product.setProduct_name(mainFrame.prodEditFrame.tf1.getText());
				mainFrame.product.setPrice(Integer.parseInt(mainFrame.prodEditFrame.tf2.getText()));
				mainFrame.product.setWorker_no(mainFrame.mem_id);

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
				mainFrame.prodEditFrame.dispose();
			} else {
				// 확인 팝업창
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 정확한 값을 입력해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		} else if (ob == mainFrame.prodEditFrame.cancelEidtBtn) {
			//mainFrame.prodEditFrame.resetText();
			mainFrame.prodEditFrame.dispose();	
		} // 이벤트 프레임에서 상품 검색할 때
		else if (ob == mainFrame.findProductFrame.productView.searchBtn) {
			String combo = (String) mainFrame.findProductFrame.productView.jcombo.getSelectedItem();
			String searchWord = mainFrame.findProductFrame.productView.searchTf.getText();

			// 검색어 없이 검색했을땐 원래 모든 상품리스트 다 보여주기.
			if (searchWord.equals("검색어를 입력하세요.") || searchWord.equals("")) {

				// 상품목록J테이블 초기화 해주기.
				mainFrame.findProductFrame.productView.tblModel.setNumRows(0);

				mainFrame.findProductFrame.productView.addProductLine(mainFrame.pdao.productAll());
			} else {
				if (searchWord.length() < 2) {
					JOptionPane.showMessageDialog(null, "[SYSTEM] 검색어는 2글자 이상 입력해주세요.", "확인",
							JOptionPane.CLOSED_OPTION);
				} else {
					// 상품목록J테이블 초기화 해주기.
					mainFrame.findProductFrame.productView.tblModel.setNumRows(0);

					// 상품목록J테이블 새로 채우기
					mainFrame.findProductFrame.productView
							.addProductLine(mainFrame.pdao.searchProduct(combo, searchWord));
				}

			}
		} else if (ob == mainFrame.findProductFrame.regBtn) {
			int row = mainFrame.findProductFrame.productView.productTable.getSelectedRow();

			mainFrame.findProductFrame.productView.searchTf.setText("");

			if (row != -1) {
				String product_id = String
						.valueOf(mainFrame.findProductFrame.productView.productTable.getValueAt(row, 0));
				mainFrame.findProductFrame.dispose();
				mainFrame.eventRegistFrame.tf1.setText(product_id);
			} else {
				JOptionPane.showMessageDialog(null, "[SYSTEM] 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		}

	}

}
