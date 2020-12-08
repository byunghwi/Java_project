package account.fr;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.ProductView;


// 디폴트 패키지의 메인프레임 복붙
// 시험용 클래스 추후 삭제예정
public class MainFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();
	
	//가운데 상품 보여줄 패널
	ProductView productView = new ProductView();
	
	//오른쪽 버튼들 보여줄 패널
	RightBtnPanel rightBtnPanel = new RightBtnPanel();
	
	
	public CardLayout cardlayout;
	public CardLayout btn;
	

	public JPanel contentPanel;
	
	public JPanel pView;
	public JPanel pBtnView;
	public JPanel topView;
	
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
		
		//상단 패널부분
		topView = new JPanel();
		topView.add(topPanel, "topPanel");
		topView.setBounds(0, 0, 1326, 50);
		topView.setBackground(new Color(0, 255,204));
		topView.setLayout(new BorderLayout());
		contentPanel.add(topView);
		
		//가운데 패널부분
		pView = new JPanel();
		pView.add(productView, "productView");
		pView.setBackground(Color.WHITE);
		
		pView.setBounds(0, 50, 1157, 552);
		pView.setLayout(cardlayout);
		contentPanel.add(pView);
		
		//오른쪽 패널부분
		pBtnView = new JPanel();
		pBtnView.setBackground(Color.WHITE);
		pBtnView.setBounds(1158, 50, 164, 675);
		pBtnView.add(rightBtnPanel, "rightBtnPanel");
		pBtnView.setLayout(cardlayout);
		contentPanel.add(pBtnView);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
