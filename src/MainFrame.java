import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProdEditFrame;
import product.ProdRegistFrame;
import product.Product;
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

	// 상품
	Product product;

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
		pView.add(productView, "productView");
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

			product = new Product();

			product.setProduct_id(prodRegistFrame.tf1.getText());
			product.setProduct_name(prodRegistFrame.tf2.getText());
			product.setManu_date(prodRegistFrame.dateChooser1.getDate());
			product.setDis_date(prodRegistFrame.dateChooser2.getDate());
			product.setPrice(Integer.parseInt(prodRegistFrame.tf3.getText()));

			pdao.productAdd(product);

			// 상품목록J테이블 초기화 해주기.
			productView.tblModel.setNumRows(0);

			// 상품목록J테이블 새로 채우기
			productView.addProductLine(pdao.productAll());

			// 텍스트 필드에 채워진 값 초기화 해주기.
			prodRegistFrame.resetText();

			// 확인 팝업창
			JOptionPane.showMessageDialog(null, "[SYSTEM] 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			// 창 안보이게
			prodRegistFrame.setVisible(false);

		} else if (ob == prodRegistFrame.cancelBtn) {
			prodRegistFrame.resetText();
			prodRegistFrame.setVisible(false);
		} else if (ob == rightBtnPanel.editProdBtn) {
			if (productView.productTable.getSelectedRow() != -1) {
				prodEditFrame.setVisible(true);

				// 선택한 행
				int row = productView.productTable.getSelectedRow();

				// 선택한 행 내용 수정 프레임창에 세팅해주기
				prodEditFrame.tf1.setText((String) productView.tblModel.getValueAt(row, 1));
				try {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd")
							.parse((String) productView.tblModel.getValueAt(row, 2));			
					Date date2 = new SimpleDateFormat("yyyy-MM-dd")
							.parse((String) productView.tblModel.getValueAt(row, 3));

					prodEditFrame.dateChooser1.setDate(date1);
					prodEditFrame.dateChooser2.setDate(date2);
				} catch (ParseException e1) {
					System.out.println("Date Parser error!\n");
					e1.printStackTrace();
				}

				prodEditFrame.tf2.setText((String) productView.tblModel.getValueAt(row, 4));
				prodEditFrame.tf3.setText((String) productView.tblModel.getValueAt(row, 5));

			} else {
				JOptionPane.showMessageDialog(null, "[SYSTEM] 수정하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}

		} else if (ob == rightBtnPanel.delProdBtn) {
			if (productView.productTable.getSelectedRow() != -1) {
				int row = productView.productTable.getSelectedRow();
				String product_id = (String) productView.tblModel.getValueAt(row, 0);

				// DB 삭제
				pdao.productDel(product_id);

				// 상품목록 화면테이블 초기화 해주기.
				productView.tblModel.setNumRows(0);

				// 상품목록 화면테이블 새로 채우기
				productView.addProductLine(pdao.productAll());

				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제가 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			} else {
				JOptionPane.showMessageDialog(null, "\t[SYSTEM] 삭제하시려는 상품을 선택해주세요.", "확인", JOptionPane.CLOSED_OPTION);
			}
		} else if (ob == prodEditFrame.compEditBtn) {

			int row = productView.productTable.getSelectedRow();
			String product_id = (String) productView.tblModel.getValueAt(row, 0);
			product = new Product();
			product.setProduct_id(product_id);
			product.setProduct_name(prodEditFrame.tf1.getText());
			product.setManu_date(prodEditFrame.dateChooser1.getDate());
			product.setDis_date(prodEditFrame.dateChooser2.getDate());
			product.setQuantity(Integer.parseInt(prodEditFrame.tf2.getText()));
			product.setPrice(Integer.parseInt(prodEditFrame.tf3.getText()));

			// DB 수정
			pdao.productEdit(product);

			// 상품목록 화면테이블 초기화 해주기.
			productView.tblModel.setNumRows(0);

			// 상품목록 화면테이블 새로 채우기
			productView.addProductLine(pdao.productAll());

			// 텍스트 필드에 채워진 값 초기화 해주기.
			prodEditFrame.resetText();

			// 확인 팝업창
			JOptionPane.showMessageDialog(null, "\t[SYSTEM] 수정이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);

			// 창 안보이게
			prodEditFrame.setVisible(false);
		} else if (ob == prodEditFrame.cancelEidtBtn) {
			prodEditFrame.resetText();
			prodEditFrame.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
