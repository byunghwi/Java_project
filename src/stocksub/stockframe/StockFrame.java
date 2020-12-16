package stocksub.stockframe;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stocksub.Stock;
import stocksub.StockDao;
import stocksub.stockAction.DisposalInfoAction;
import stocksub.stockAction.MoreInfoAction;
import stocksub.stockView.StockView;

// 재고에 대한 메인 프레임 
public class StockFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();

	// 가운데 상품 보여줄 패널
	public StockView stockView = new StockView();

	// 오른쪽 버튼들 보여줄 패널
	RightBtnPanel rightBtnPanel = new RightBtnPanel();
	

	// 상품
	Stock stock;

	public CardLayout cardlayout;
	public CardLayout btn;

	public JPanel contentPanel;

	public JPanel sView;
	public JPanel sBtnView;
	public JPanel topView;

	StockDao sdao = new StockDao();

	public StockFrame() {

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
		sView = new JPanel();
		sView.add(stockView, "stockView");
		sView.setBackground(Color.WHITE);
		sView.setBounds(0, 50, 1157, 552);
		sView.setLayout(cardlayout);
		contentPanel.add(sView);

		// 오른쪽 패널부분
		sBtnView = new JPanel();
		sBtnView.setBackground(Color.WHITE);
		sBtnView.setBounds(1158, 50, 164, 675);
		sBtnView.add(rightBtnPanel, "rightBtnPanel");
		sBtnView.setLayout(cardlayout);
		contentPanel.add(sBtnView);
		
		rightBtnPanel.productMoreInfoBtn.addActionListener(new MoreInfoAction(this));

		rightBtnPanel.disposalInfoBtn.addActionListener(new DisposalInfoAction(this));


	}
	public static void main(String[] args) {
		new StockFrame();
	}
}
