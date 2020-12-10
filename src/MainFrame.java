import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProdEditFrame;
import product.ProdRegistFrame;
import product.ProductDao;
import product.ProductView;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();

	// 가운데 상품 보여줄 패널
	ProductView productView = new ProductView();


	// 오른쪽 버튼들 보여줄 패널
	RightBtnPanel rightBtnPanel = new RightBtnPanel();

	// 상품 등록 팝업 프레임
	ProdRegistFrame prodRegistFrame = new ProdRegistFrame();

	// 상품 수정 팝업 프레임
	ProdEditFrame prodEditFrame = new ProdEditFrame();

	public CardLayout cardlayout;
	public CardLayout btn;

	public JPanel contentPanel;

	public JPanel pView;
	public JPanel pBtnView;
	public JPanel topView;

	ProductDao pdao = new ProductDao();

	public MainFrame() {
		
		cardlayout = new CardLayout();

		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("편의점프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 753);
		setVisible(true);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		// 상단 패널부분
		topView = new JPanel();
		topView.add(topPanel, "topPanel");
		topView.setBounds(0, 0, 1326, 50);
		topView.setBackground(new Color(0, 255, 204));
		topView.setLayout(new BorderLayout());
		contentPanel.add(topView);

		// 가운데 패널부분
		pView = new JPanel();
		pView.add(productView , "productView");
		pView.setBackground(Color.WHITE);
		pView.setBounds(0, 50, 1157, 552);
		pView.setLayout(cardlayout);
		contentPanel.add(pView);

		// 오른쪽 패널부분
		pBtnView = new JPanel();
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1158, 50, 164, 675);
		pBtnView.add(rightBtnPanel, "rightBtnPanel");
		pBtnView.setLayout(cardlayout);
		contentPanel.add(pBtnView);

		// 버튼들 액션 달기 Start
		rightBtnPanel.registProdBtn.addActionListener(this); // 우측패널 상품등록 버튼
		rightBtnPanel.editProdBtn.addActionListener(this); // 우측패널 상품 수정 버튼
		rightBtnPanel.delProdBtn.addActionListener(this); // 우측패널 상품 삭제 버튼

		prodRegistFrame.regBtn.addActionListener(this); // 팝업 상품등록 프레임 등록 버튼
		prodRegistFrame.cancelBtn.addActionListener(this); // 팝업 상품등록 프레임 취소 버튼
		
		prodEditFrame.compEditBtn.addActionListener(this);
		prodEditFrame.cancelEidtBtn.addActionListener(this);
		// 버튼들 액션 달기 End
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();

		if (ob == rightBtnPanel.registProdBtn) {
			prodRegistFrame.setVisible(true);
		} else if (ob == prodRegistFrame.regBtn) {
			pdao.productAdd(prodRegistFrame.fields);

			// 상품목록J테이블 초기화 해주기.
			productView.tblModel.setNumRows(0);

			// 상품목록J테이블 새로 채우기
			productView.addProductLine(pdao.productAll());

			// 텍스트 필드에 채워진 값 초기화 해주기.
			prodRegistFrame.resetText(prodRegistFrame.fields);

			// 확인 팝업창
			JOptionPane.showMessageDialog(null, "[SYSTEM] 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			// 창 안보이게
			prodRegistFrame.setVisible(false);

		} else if (ob == prodRegistFrame.cancelBtn) {
			prodRegistFrame.setVisible(false);
		} else if (ob == rightBtnPanel.editProdBtn) {
			if (productView.productTable.getSelectedRow() != -1) {
				prodEditFrame.setVisible(true);

				// 선택한 행
				int row = productView.productTable.getSelectedRow();
				
				// 선택한 행 내용 수정 프레임창에 세팅해주기
				for (int i = 0; i < 5; i++) {
					prodEditFrame.fields[i].setText((String) productView.tblModel.getValueAt(row, (i + 1)));
				}

			} else {
				JOptionPane.showMessageDialog(null, "[SYSTEM] 수정하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		} else if (ob == rightBtnPanel.delProdBtn) {
			if (productView.productTable.getSelectedRow() != -1) {
				int row = productView.productTable.getSelectedRow();
				String product_id = (String) productView.tblModel.getValueAt(row, 0);
				pdao.productDel(product_id);
				
				// 상품목록 화면테이블 초기화 해주기.
				productView.tblModel.setNumRows(0);

				// 상품목록 화면테이블 새로 채우기
				productView.addProductLine(pdao.productAll());
				
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제가 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
				
			} else {
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}
		}else if (ob == prodEditFrame.compEditBtn) {
			
			int row = productView.productTable.getSelectedRow();
			String product_id = (String) productView.tblModel.getValueAt(row, 0);
			
			pdao.productEdit(prodEditFrame.fields, product_id);

			// 상품목록 화면테이블 초기화 해주기.
			productView.tblModel.setNumRows(0);

			// 상품목록 화면테이블 새로 채우기
			productView.addProductLine(pdao.productAll());

			// 텍스트 필드에 채워진 값 초기화 해주기.
			prodEditFrame.resetText(prodEditFrame.fields);

			// 확인 팝업창
			JOptionPane.showMessageDialog(null, "\t[SYSTEM] 수정이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			// 창 안보이게
			prodEditFrame.setVisible(false);
		} else if(ob == prodEditFrame.cancelEidtBtn) {
			prodEditFrame.resetText(prodEditFrame.fields);
			prodEditFrame.setVisible(false);
		}

	}


}
