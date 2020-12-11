package ordertest;
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

import order.OrderConfirmDao;
import order.OrderConfirmFrame;
import order.OrderConfirmView;
import order.OrderDao;
import order.OrderFrame;
import order.OrderView;
import product.ProdEditFrame;
import product.ProdRegistFrame;
import product.Product;
import product.ProductDao;
import product.ProductView;

public class MainFrame extends JFrame implements ActionListener {

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

	// 발주승인대기창
	OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
	
	// 주문창
	OrderFrame orderframe = new OrderFrame();
	
	public CardLayout cardlayout;
	public CardLayout btn;

	public JPanel contentPanel;

	public JPanel pView;
	public JPanel pBtnView;
	public JPanel topView;
	
	OrderConfirmDao ocd = new OrderConfirmDao();
	OrderDao od = new OrderDao();
	
	OrderConfirmView ocv = new OrderConfirmView();
	OrderView ov = new OrderView();
	
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
//		pView = new JPanel();
//		pView.add(productView, "productView");
//		pView.setBackground(Color.WHITE);
//		pView.setBounds(0, 50, 1157, 552);
//		pView.setLayout(cardlayout);
//		contentPanel.add(pView);

		// 오른쪽 패널부분
		pBtnView = new JPanel();
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1158, 50, 164, 675);
		pBtnView.add(rightBtnPanel, "rightBtnPanel");
		pBtnView.setLayout(cardlayout);
		contentPanel.add(pBtnView);

		// 버튼들 액션 달기 Start
		rightBtnPanel.orderProdBtn.addActionListener(this);
		// 주문버튼
		orderConfirmFrame.order_btn.addActionListener(this);
		// 주문확정버튼, 취소버튼
		orderframe.order_btn.addActionListener(this);
		orderframe.cancel_btn.addActionListener(this);
		// 승인버튼
		orderConfirmFrame.confirm_btn.addActionListener(this);
		// 삭제버튼
		orderConfirmFrame.delete_btn.addActionListener(this);
		// 취소버튼
		orderConfirmFrame.cancel_btn.addActionListener(this);
		// 버튼들 액션 달기 End
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == rightBtnPanel.orderProdBtn) { // 오른쪽 발주버튼
			orderConfirmFrame.setVisible(true);
		} else if (ob == orderConfirmFrame.order_btn) { // 승인 주문버튼
			orderframe.setVisible(true);
		} else if (ob == orderConfirmFrame.confirm_btn) { // 승인 승인버튼
			ocd.confirmCheck(orderConfirmFrame.fields);
			ocd.confirmCancle(orderConfirmFrame.fields);
			JOptionPane.showMessageDialog(null, "승인 완료", "확인", JOptionPane.CLOSED_OPTION);
			
			
		} else if (ob == orderConfirmFrame.delete_btn) { // 승인 삭제버튼
			ocd.confirmCancle(orderConfirmFrame.fields);
		} else if (ob == orderConfirmFrame.cancel_btn) { // 승인 취소버튼
			orderConfirmFrame.setVisible(false);
		}
		
		if (ob == orderframe.order_btn) { // 주문 주문버튼
			od.moveconfirm(orderframe.fields);
			JOptionPane.showMessageDialog(null, "주문 완료", "확인", JOptionPane.CLOSED_OPTION);
		} else if (ob == orderframe.cancel_btn) { // 주문 취소버튼
			orderframe.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
