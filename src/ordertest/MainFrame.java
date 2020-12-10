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
import product.ProdRegistFrame;
import product.ProductDao;
import product.ProductView;


public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();

	// 가운데 상품 보여줄 패널
	ProductView productView = new ProductView();

	// 오른쪽 버튼들 보여줄 패널
	RightBtnPanel rightBtnPanel = new RightBtnPanel();
	
	// 상품 등록 팝업 프레임
	ProdRegistFrame prodRegistFrame = new ProdRegistFrame();
	
	// 상품발주승인
	OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
	
	// 상품주문
	OrderFrame orderFrame = new OrderFrame();

	public CardLayout cardlayout;
	public CardLayout btn;

	public JPanel contentPanel;

	public JPanel pView;
	public JPanel pBtnView;
	public JPanel topView;
	
	ProductDao pdao = new ProductDao();
	OrderConfirmDao ocd = new OrderConfirmDao();
	OrderDao od = new OrderDao();

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
		
		//버튼들 액션 달기 start
		rightBtnPanel.registProdBtn.addActionListener(this); 	//우측패널 상품등록 버튼
		rightBtnPanel.orderProdBtn.addActionListener(this); 	//우측패널 상품주문 버튼
		
		prodRegistFrame.regBtn.addActionListener(this); 		//팝업 상품등록 프레임 등록 버튼
		prodRegistFrame.cancelBtn.addActionListener(this); 		//팝업 상품등록 프레임 취소 버튼
		
		orderConfirmFrame.order_btn.addActionListener(this);	// 승인목록 주문목록 활성버튼
		orderConfirmFrame.confirm_btn.addActionListener(this); // 승인목록 승인버튼
		orderConfirmFrame.delete_btn.addActionListener(this); // 승인목록 삭제버튼
		orderConfirmFrame.cancel_btn.addActionListener(this); // 승인버튼 취소버튼
		
		orderFrame.order_btn.addActionListener(this);	// 주문목록 주문버튼(승인대기창으로 이동)
		orderFrame.cancel_btn.addActionListener(this); // 주문목록 취소버튼
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();
		
		if(ob == rightBtnPanel.registProdBtn) {
			prodRegistFrame.setVisible(true);
		} else if (ob == prodRegistFrame.regBtn) {
			pdao.productAdd(prodRegistFrame.fields);
			
			//상품목록J테이블 초기화 해주기.
			productView.tblModel.setNumRows(0);
			
			//상품목록J테이블 새로 채우기
			productView.addProductLine(pdao.productAll());
				
			//텍스트 필드에 채워진 값 초기화 해주기.
			for (int i = 0; i< prodRegistFrame.fields.length; i++) {
				prodRegistFrame.fields[i].setText("");
			}
			
			//확인 팝업창
			JOptionPane.showMessageDialog(null, "[SYSTEM] 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
			//창 안보이게 
			prodRegistFrame.setVisible(false);
			
		} else if (ob == prodRegistFrame.cancelBtn) {
			prodRegistFrame.setVisible(false);
		} 
		
		// 오른쪽 상품발주버튼 클릭
		if (ob == rightBtnPanel.orderProdBtn) { // 승인대기 - 주문
			orderConfirmFrame.setVisible(true);
		} else if (ob == orderConfirmFrame.order_btn) {
			orderFrame.setVisible(true);
		} else if (ob == orderConfirmFrame.confirm_btn) { // 승인대기 - 승인
			
		} else if (ob == orderConfirmFrame.delete_btn) { // 승인대기 - 삭제
			ocd.confirmCancle(orderConfirmFrame.fields);
		} else if (ob == orderConfirmFrame.cancel_btn) { // 승인대기 - 취소
			orderConfirmFrame.setVisible(false);
		} 
		
		if (ob == orderFrame.order_btn) { // 물품주문 - 발주테이블로 이동
			od.moveconfirm(orderFrame.fields);
		} else if (ob == orderFrame.cancel_btn) { // 취소
			orderFrame.setVisible(false);
		} 
		
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}