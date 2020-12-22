package main;
import java.awt.BorderLayout; 
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import account.action.PopSecession_Action;
import account.action.UserInfoAction;
import calc.CalcDao;
import calc.CalcPanel;
import calc.BtnAction.CalcBtnAction;
import calc.MainCalcFrame.CalcBtnPanel;
import commute.CommutePanel;
import commute.TimeDao;
import commute.BtnAction.CommuteBtnAction;
import commute.List.Commute_ListDao;
import commute.MainCommuteFrame.CommuteBtnPanel;
import event.Event;
import event.EventBtnPanel;
import event.EventDao;
import event.EventPanel;
import event.EventRegistFrame;
import event.FindProductFrame;
import event.eventAction.EventBtnPanelAction;
import event.eventAction.EventRegistFrameAction;
import main.mainAction.BottomAction;
import order.OrderAction;
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
import sale.SaleBtnPanel;
import sale.SaleDao;
import sale.SaleListPanel;
import sale.SalePanel;
import sale.saleAction.SaleAction;
import sale.saleAction.SaleBtnPanelAction;
import sale.saleAction.SaleListPanelAction;
import stock.StockDao;
import stock.stockAction.DisposalInfoAction;
import stock.stockAction.MoreInfoAction;
import stock.stockView.StockView;
import stock.stockframe.StockRightBtnPanel;
import javax.swing.JLabel;


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
	
	// 가운데 판매리스트 보여줄 패널
	public SaleListPanel saleListPanel = new SaleListPanel();
	
	// 가운데 이벤트 보여줄 패널
	public EventPanel eventPanel = new EventPanel();
	
	// 가운데 근태 보여줄 패널 
	public CommutePanel commutePanel= new CommutePanel();
	
	// 가운데 정산 보여줄 패널
	public CalcPanel calcPanel=new CalcPanel(null,null);

	// 오른쪽 상품버튼 보여줄 패널
	public ProdBtnPanel prodBtnPanel = new ProdBtnPanel();
	
	// 오른쪽 판매버튼 보여줄 패널
	public SaleBtnPanel saleBtnPanel = new SaleBtnPanel();
	
	// 오른쪽 재고 버튼 보여줄 패널
	public StockRightBtnPanel stockBtnPanel = new StockRightBtnPanel();
	
	// 오른쪽 이벤트버튼 보여줄 패널
	public EventBtnPanel eventBtnPanel = new EventBtnPanel();
	
	// 오른쪽 근태버튼 보여줄 패널
	public CommuteBtnPanel commuteBtnPanel=new CommuteBtnPanel();
	
	// 오른쪽 정산버튼 보여줄 패널
	public CalcBtnPanel calcBtnPanel=new CalcBtnPanel();
	
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
	
	// 이벤트
	public Event event;
	
	// 발주승인, 발주주문 프레임, DB, View
	public OrderConfirmFrame orderConfirmFrame = new OrderConfirmFrame();
	public OrderFrame orderframe = new OrderFrame();
	public OrderConfirmDao orderConfirmDao = new OrderConfirmDao();
	public OrderConfirmView orderConfirmView = new OrderConfirmView();
	public OrderDao orderDao = new OrderDao();
	public OrderView orderView = new OrderView();

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
	public TimeDao timedao= new TimeDao();
	public Commute_ListDao commutelistdao=new Commute_ListDao(null,null,null);
	public CalcDao calcdao=new CalcDao(null,null);
	
	// 로그인 할 회원 정보를 가져올 변수
	public String mem_id;
	
	// 매뉴바 기본 설정
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("회원정보");
	JMenuItem i1 = new JMenuItem("확인/수정");
	JMenuItem i2 = new JMenuItem("탈퇴");


	public MainFrame() {
		
		// 매뉴 바 추가
		bar.add(menu);
		menu.add(i1);
		menu.add(i2);
		this.setJMenuBar(bar);
		
		cardlayout = new CardLayout();
		btnlayout = new CardLayout();

		//setUndecorated(true); // 프레임 타이틀 바 안보이게 - 적용하면 프레임 이동에 대한 소스도 구현해주어어야 함.
		setFont(new Font("나눔 고딕", Font.BOLD, 20));
		setTitle("편의점프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 778);
		setVisible(true);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		// 상단 패널부분
		topView = new JPanel();
		topView.setLayout(null);
		topPanel.setBounds(0, 0, 1302, 50);
		topView.add(topPanel);
		topView.setBounds(0, 0, 1367, 50);
		topView.setBackground(new Color(255, 255, 255));
		contentPanel.add(topView);

		// 가운데 패널부분 - 상품 , 재고
		centerView = new JPanel();
		centerView.setLayout(cardlayout);
		centerView.add(productView, "productView"); 	//상품 
		centerView.add(stockPanel, "stockPanel"); 		//재고
		centerView.add(salePanel, "salePanel");			//판매화면
		centerView.add(saleListPanel, "saleListPanel");	//판매리스트
		centerView.add(eventPanel, "eventPanel");  		//이벤트
		centerView.add(commutePanel,"commutePanel");	//근태
		centerView.add(calcPanel,"calcPanel");		//정산
		centerView.setBackground(Color.WHITE);
		centerView.setBounds(0, 50, 1157, 552);
		contentPanel.add(centerView);

		// 오른쪽 패널부분
		pBtnView = new JPanel();
		pBtnView.setLayout(btnlayout);
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1158, 50, 142, 660);
		pBtnView.add(prodBtnPanel, "prodBtnPanel"); 	// 상품관련 오른쪽 버튼들
		pBtnView.add(stockBtnPanel, "stockBtnPanel");	// 재고관련 오른쪽 버튼들
		pBtnView.add(saleBtnPanel, "saleBtnPanel");		// 판매관련 오른쪽 버튼들
		pBtnView.add(eventBtnPanel, "eventBtnPanel");	// 이벤트 관련 오른쪽 버튼들
		pBtnView.add(commuteBtnPanel, "commuteBtnPanel");// 근태관련 오른쪽 버튼들
		pBtnView.add(calcBtnPanel, "calcBtnPanel");		 // 정산관련 오른쪽 버튼
		
		contentPanel.add(pBtnView);
				
		// 하단 패널부분
		bottomView = new JPanel();
		bottomView.setBackground(Color.WHITE);
		bottomView.setBounds(8, 608, 1135, 100);
		bottomView.add(bottomPanel, "bottomPanel");
		bottomView.setLayout(btnlayout);
		contentPanel.add(bottomView);

		// 버튼들 액션 달기 Start
		prodBtnPanel.registProdBtn.addActionListener(new ProdBtnPanelAction(this)); 		//우측패널 상품등록 버튼
		prodBtnPanel.editProdBtn.addActionListener(new ProdBtnPanelAction(this)); 		//우측패널 상품 수정 버튼
		prodBtnPanel.delProdBtn.addActionListener(new ProdBtnPanelAction(this)); 			//우측패널 상품 삭제 버튼
		
		commuteBtnPanel.on_timeBtn.addActionListener(new CommuteBtnAction(this));		//우측패널 출근버튼
		commuteBtnPanel.off_timeBtn.addActionListener(new CommuteBtnAction(this));		//우측패널 퇴근버튼
		commuteBtnPanel.commuteBtn.addActionListener(new CommuteBtnAction(this));		//우측패널 근태목록버튼
		
		calcBtnPanel.calc_Btn.addActionListener(new CalcBtnAction(this));				//우측패널 정산버튼
		
		eventBtnPanel.eventRegBtn.addActionListener(new EventBtnPanelAction(this));		//우측패널 이벤트 등록 버튼 
		eventBtnPanel.eventDelBtn.addActionListener(new EventBtnPanelAction(this));		//우측패널 이벤트 등록 버튼 
		stockBtnPanel.productMoreInfoBtn.addActionListener(new MoreInfoAction(this));	//우측패널 재고 상세정보 확인 버튼
		stockBtnPanel.disposalInfoBtn.addActionListener(new DisposalInfoAction(this));	//우측패널 폐기 정보 확인 버튼
		stockBtnPanel.orderConfirmBtn.addActionListener(new OrderConfirmAction(this)); // 발주승인목록 버튼

		saleBtnPanel.saleListBtn.addActionListener(new SaleBtnPanelAction(this));		//우측패널 판매리스트 버튼
		saleBtnPanel.saleBtn.addActionListener(new SaleBtnPanelAction(this));			//우측패널 판매 버튼
		
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
		bottomPanel.commuteBtn.addActionListener(new BottomAction(this)); 					//하단패널 근태 버튼
		bottomPanel.calcBtn.addActionListener(new BottomAction(this));  					//하단패널 정산 버튼
		bottomPanel.eventBtn.addActionListener(new BottomAction(this)); 					//하단패널 이벤트 버튼
		
		salePanel.addBucketBtn.addActionListener(new SaleAction(this));						//판매패널 장바구니 추가 버튼
		salePanel.delBucketBtn.addActionListener(new SaleAction(this));						//판매패널 장바구니 삭제 버튼
		salePanel.completeBtn.addActionListener(new SaleAction(this));						//판매패널 결제 버튼
		
		saleListPanel.searchBtn.addActionListener(new SaleListPanelAction(this));			//판매리스트 패널 검색버튼
		
		i1.addActionListener(new UserInfoAction(this));										// 회원정보 확인/수정 버튼
		i2.addActionListener(new PopSecession_Action(this));										// 회원탈퇴 버튼
		
		// 발주승인목록 버튼
		orderConfirmFrame.order_btn.addActionListener(new OrderConfirmAction(this));
		orderConfirmFrame.confirm_btn.addActionListener(new OrderConfirmAction(this));
		orderConfirmFrame.delete_btn.addActionListener(new OrderConfirmAction(this));
		orderConfirmFrame.cancel_btn.addActionListener(new OrderConfirmAction(this));
		orderConfirmFrame.search_btn.addActionListener(new OrderConfirmAction(this));
		
		orderframe.order_btn.addActionListener(new OrderAction(this));
		orderframe.cancel_btn.addActionListener(new OrderAction(this));
		orderframe.search_btn.addActionListener(new OrderAction(this));
		// 버튼들 액션 달기 End
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
