package main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import event.Event;
import event.EventBtnPanel;
import event.EventDao;
import event.EventPanel;
import event.EventRegistFrame;
import event.FindProductFrame;
import event.eventAction.EventBtnPanelAction;
import event.eventAction.EventRegistFrameAction;
import main.mainAction.BottomAction;
import order.OrderDao;
import order.OrderFrame;
import order.OrderView;
import orderConfirm.OrderConfirmAction;
import orderConfirm.OrderConfirmDao;
import orderConfirm.OrderConfirmFrame;
import orderConfirm.OrderConfirmView;
import product.ProdBtnPanel;
import product.ProdEditFrame;
import product.ProdRegistFrame;
import product.Product;
import product.ProductDao;
import product.ProductView;
import product.productAction.ProdBtnPanelAction;
import product.productAction.ProdEditFrameAction;
import product.productAction.ProductAction;
import sale.SaleAction;
import sale.SaleBtnPanel;
import sale.SaleDao;
import sale.SalePanel;
import stock.StockDao;
import stocksub.stockAction.DisposalInfoAction;
import stocksub.stockAction.Disposal_Action;
import stocksub.stockAction.MoreInfoAction;
import stocksub.stockView.StockView;
import stocksub.stockframe.StockRightBtnPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	public TopPanel topPanel = new TopPanel();

	// 가운데 상품 보여줄 패널
	public ProductView productView = new ProductView();
	
	// 가운데 재고 보여줄 패널
	public StockView stockPanel = new StockView();
	
	// 가운데 판매 보여줄 패널
	public SalePanel salePanel = new SalePanel();
	
	// 가운데 이벤트 보여줄 패널
	public EventPanel eventPanel = new EventPanel();

	// 오른쪽 상품버튼 보여줄 패널
	public ProdBtnPanel prodBtnPanel = new ProdBtnPanel();
	
	// 오른쪽 판매버튼 보여줄 패널
	public SaleBtnPanel saleBtnPanel = new SaleBtnPanel();
	
	// 오른쪽 재고 버튼 보여줄 패널
	public StockRightBtnPanel stockBtnPanel = new StockRightBtnPanel();
	
	// 오른쪽 이벤트버튼 보여줄 패널
	public EventBtnPanel eventBtnPanel = new EventBtnPanel();
	
	// 하단 버튼들 보여줄 패널
	public BottomPanel bottomPanel = new BottomPanel();

	// 상품 등록 팝업 프레임
	public ProdRegistFrame prodRegistFrame = new ProdRegistFrame();

	// 상품 수정 팝업 프레임
	public ProdEditFrame prodEditFrame = new ProdEditFrame();
	
	// 이벤트 등록 팝업 프레임
	public EventRegistFrame eventRegistFrame = new EventRegistFrame();
	
	// 이벤트 등록 팝업 프레임 -> 상품 찾기 프레임
	public FindProductFrame findProductFrame = new FindProductFrame();
	
	// 상품
	public Product product;
	
//	OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
//	OrderFrame orderframe = new OrderFrame();
//	OrderConfirmDao orderConfirmDao = new OrderConfirmDao();
//	OrderConfirmView orderConfirmView = new OrderConfirmView();
//	OrderDao orderDao = new OrderDao();
//	OrderView orderView = new OrderView();
	
	// 이벤트
	public Event event;

	public CardLayout cardlayout;
	public CardLayout btnlayout;

	public JPanel contentPanel;

	public JPanel centerView;
	public JPanel pBtnView;
	public JPanel topView;
	public JPanel bottomView;

	public ProductDao pdao = new ProductDao();
	public SaleDao sdao = new SaleDao();
	public StockDao stockdao = new StockDao();
	public EventDao eventdao = new EventDao();
	
	// 로그인 할 회원 정보를 가져올 변수
	public String mem_id;

	
	
	public MainFrame() {
		
		cardlayout = new CardLayout();
		btnlayout = new CardLayout();

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
		topView.setBounds(0, 0, 1297, 50);
		topView.setBackground(new Color(0, 255, 204));
		topView.setLayout(new BorderLayout());
		contentPanel.add(topView);

		// 가운데 패널부분 - 상품 , 재고
		centerView = new JPanel();
		centerView.setLayout(cardlayout);
		centerView.add(productView, "productView"); // 상품 
		centerView.add(stockPanel, "stockPanel"); 	// 재고
		centerView.add(salePanel, "salePanel");		//판매
		centerView.add(eventPanel, "eventPanel");  	//이벤트
		centerView.setBackground(Color.WHITE);
		centerView.setBounds(0, 50, 1157, 552);
		contentPanel.add(centerView);

		// 오른쪽 패널부분
		pBtnView = new JPanel();
		pBtnView.setLayout(btnlayout);
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1158, 50, 142, 675);
		pBtnView.add(prodBtnPanel, "prodBtnPanel"); 	// 상품관련 오른쪽 버튼들
		pBtnView.add(stockBtnPanel, "stockBtnPanel");	// 재고관련 오른쪽 버튼들
		pBtnView.add(saleBtnPanel, "saleBtnPanel");		// 판매관련 오른쪽 버튼들
		pBtnView.add(eventBtnPanel, "eventBtnPanel");	// 이벤트 관련 오른쪽 버튼들
		
		contentPanel.add(pBtnView);
				
		// 하단 패널부분
		bottomView = new JPanel();
		bottomView.setBackground(Color.WHITE);
		bottomView.setBounds(8, 610, 1145, 100);
		bottomView.add(bottomPanel, "bottomPanel");
		bottomView.setLayout(btnlayout);
		contentPanel.add(bottomView);

		// 버튼들 액션 달기 Start
		prodBtnPanel.registProdBtn.addActionListener(new ProdBtnPanelAction(this)); 		//우측패널 상품등록 버튼
		prodBtnPanel.editProdBtn.addActionListener(new ProdBtnPanelAction(this)); 		//우측패널 상품 수정 버튼
		prodBtnPanel.delProdBtn.addActionListener(new ProdBtnPanelAction(this)); 			//우측패널 상품 삭제 버튼
		eventBtnPanel.eventRegBtn.addActionListener(new EventBtnPanelAction(this));		//우측패널 이벤트 등록 버튼 
		eventBtnPanel.eventDelBtn.addActionListener(new EventBtnPanelAction(this));		//우측패널 이벤트 등록 버튼 
		stockBtnPanel.productMoreInfoBtn.addActionListener(new MoreInfoAction(this));	//우측패널 재고 상세정보 확인 버튼
		stockBtnPanel.disposalInfoBtn.addActionListener(new DisposalInfoAction(this));
		stockBtnPanel.orderConfirmBtn.addActionListener(new OrderConfirmAction(this)); // 발주승인목록 버튼

		prodRegistFrame.regBtn.addActionListener(new ProductAction(this)); 					//팝업 상품등록 프레임 등록 버튼
		prodRegistFrame.cancelBtn.addActionListener(new ProductAction(this)); 				//팝업 상품등록 프레임 취소 버튼
		productView.searchBtn.addActionListener(new ProductAction(this));					//상품 검색 버튼
		findProductFrame.productView.searchBtn.addActionListener(new ProductAction(this)); 	//이벤트 프레임 - 상품찾기 프레임 - 상품검색 버튼
		findProductFrame.regBtn.addActionListener(new ProductAction(this));					//이벤트 프레임 - 상품찾기 프레임 - 상품코드입력 버튼

		prodEditFrame.compEditBtn.addActionListener(new ProdEditFrameAction(this));			//팝업 상품 수정 프레임 수정 버튼
		prodEditFrame.cancelEidtBtn.addActionListener(new ProdEditFrameAction(this));		//팝업 상품 수정 프레임 취소 버튼
		
		eventRegistFrame.regBtn.addActionListener(new EventRegistFrameAction(this)); 		//팝업 이벤트 등록 프레임 등록 버튼
		eventRegistFrame.cancelBtn.addActionListener(new EventRegistFrameAction(this)); 	//팝업 이벤트 등록 프레임 취소 버튼
		eventRegistFrame.searchBtn.addActionListener(new EventRegistFrameAction(this)); 	//팝업 이벤트 등록 프레임 상품찾기 버튼
		
		bottomPanel.productBtn.addActionListener(new BottomAction(this));					//하단패널 상품 버튼
		bottomPanel.saleBtn.addActionListener(new BottomAction(this));						//하단패널 판매 버튼
		bottomPanel.stockBtn.addActionListener(new BottomAction(this));						//하단패널 재고 버튼
		bottomPanel.disBtn.addActionListener(new BottomAction(this));						//하단패널 폐기 버튼
		bottomPanel.accountBtn.addActionListener(new BottomAction(this)); 					//하단패널 유저 버튼
		bottomPanel.commuteBtn.addActionListener(new BottomAction(this)); 					//하단패널 근태 버튼
		bottomPanel.calcBtn.addActionListener(new BottomAction(this));  					//하단패널 정산 버튼
		bottomPanel.eventBtn.addActionListener(new BottomAction(this)); 					//하단패널 이벤트 버튼
		
		salePanel.addBucketBtn.addActionListener(new SaleAction(this));						//판매패널 장바구니 추가 버튼
		salePanel.delBucketBtn.addActionListener(new SaleAction(this));						//판매패널 장바구니 삭제 버튼
		salePanel.completeBtn.addActionListener(new SaleAction(this));						//판매패널 결제 버튼
		
	
		// 버튼들 액션 달기 End
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}