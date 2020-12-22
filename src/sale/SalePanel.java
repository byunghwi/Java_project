package sale;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import main.TopPanel;
import product.Product;
import stock.Stock;
import stock.StockDao;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Product product;
	StockDao stockdao = new StockDao();
	public JScrollPane stockScrollPane = new JScrollPane(); 	// 재고 보여줄 스크롤패널
	public JScrollPane bucketScrollPane = new JScrollPane();	// 장바구니 보여줄 스크롤패널
	
	public Vector<String> stockcolNames = getColum("stock");
	public Vector<String> bucketcolNames = getColum("bucket");
	
	public DefaultTableModel stockTblModel = new DefaultTableModel(stockcolNames, 0);
	public DefaultTableModel bucketTblModel = new DefaultTableModel(bucketcolNames, 0);
	
	public JTable stockTable = new JTable(stockTblModel){
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	public JTable bucketTable = new JTable(bucketTblModel){
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	public JTextField prodnameTf; 	//상품이름 텍스트필드
	public JTextField prodQt;		//상품수량 텍스트필드
	
	public JLabel prodnameLb; 		//상품이름 라벨
	public JLabel prodQtLb;			//상품수량 라벨
	
	public JLabel stockTblLb; 		//재고테이블라벨
	public JLabel bucketTblLb;		//장바구니테이블라벨
	
	public JButton addBucketBtn;	//장바구니 추가 버튼
	public JButton delBucketBtn;	//장바구니 삭제 버튼
	
	public JButton completeBtn; 	//장바구니 결제 버튼
	
	
	// 행 정보들 담을 벡터
	public Vector<String> rows;

	public SalePanel() {
		setLayout(null);

		
	
		prodnameTf = new JTextField();
		prodnameTf.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodQt = new JTextField();
		
		prodnameLb = new JLabel("상품명");
		prodnameLb.setHorizontalAlignment(SwingConstants.CENTER);
		prodnameLb.setFont(new Font("나눔고딕", Font.BOLD, 13));
		prodQtLb = new JLabel("상품수량");
		prodQtLb.setHorizontalAlignment(SwingConstants.CENTER);
		prodQtLb.setFont(new Font("나눔고딕", Font.BOLD, 13));
		
		stockTblLb = new JLabel("재고목록");
		stockTblLb.setFont(new Font("나눔고딕", Font.BOLD, 15));
		bucketTblLb = new JLabel("장바구니");
		bucketTblLb.setFont(new Font("나눔고딕", Font.BOLD, 15));
			
		
	
		Image img1 = new ImageIcon("src/plus.png").getImage();
		Image chgimg1 = img1.getScaledInstance(60, 60, img1.SCALE_SMOOTH);
		ImageIcon icon1= new ImageIcon(chgimg1);
		
		Image img2 = new ImageIcon("src/minus.png").getImage();
		Image chgimg2 = img2.getScaledInstance(60, 60, img2.SCALE_SMOOTH);
		ImageIcon icon2= new ImageIcon(chgimg2);
		
		Image img3 = new ImageIcon("src/pay.png").getImage();
		Image chgimg3 = img3.getScaledInstance(80, 80, img3.SCALE_SMOOTH);
		ImageIcon icon3 = new ImageIcon(chgimg3);
		
		addBucketBtn =  new JButton(icon1);
		delBucketBtn = new JButton(icon2);
		delBucketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		completeBtn = new JButton(icon3);
//		//addBucketBtn.setFont(new Font("굴림체", Font.PLAIN, 12));
//		
//		
//		//delBucketBtn.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
//		completeBtn = new JButton("결제");
//		completeBtn.setIcon(new ImageIcon(SalePanel.class.getResource("/org/jfree/chart/gorilla.jpg")));
//		completeBtn.setSelectedIcon(null);
//		completeBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		completeBtn.setBorderPainted(false);
		completeBtn.setFocusPainted(false);
		completeBtn.setContentAreaFilled(false);
		
		
		
		addBucketBtn.setBorderPainted(false);
		addBucketBtn.setFocusPainted(false);
		addBucketBtn.setContentAreaFilled(false);
		
		delBucketBtn.setBorderPainted(false);
		delBucketBtn.setFocusPainted(false);
		delBucketBtn.setContentAreaFilled(false);
		
		stockTblLb.setBounds(22, 2, 70, 50);
		bucketTblLb.setBounds(710, 0, 70, 50);
		prodnameLb.setBounds(520, 180, 70, 20);
		prodQtLb.setBounds(622, 180, 70, 20);
		prodnameTf.setBounds(520, 210, 90, 30);
		prodQt.setBounds(622, 210, 70, 30);
		addBucketBtn.setBounds(582, 250, 49, 50);
		delBucketBtn.setBounds(582, 299, 49, 50);
		completeBtn.setBounds(562, 408, 90, 80);

		add(stockTblLb);
		add(bucketTblLb);
		add(prodnameLb);
		add(prodQtLb);
		add(prodnameTf);
		add(prodQt);
		add(addBucketBtn);
		add(delBucketBtn);
		add(completeBtn);
		stockScrollPane.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		stockScrollPane.setBackground(new Color(255, 255, 255));
		
		stockScrollPane.setBounds(12, 44, 494, 444);
		bucketScrollPane.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		bucketScrollPane.setBounds(704, 44, 426, 444);
		add(stockScrollPane);
		add(bucketScrollPane);
		stockTable.setGridColor(new Color(135, 206, 235));
		stockTable.setShowVerticalLines(false);
		stockTable.setShowHorizontalLines(false);
		stockTable.setShowGrid(false);
		stockTable.setSelectionBackground(new Color(255, 192, 203));

		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);
		stockTable.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		bucketTable.setGridColor(new Color(135, 206, 235));
		bucketTable.setShowGrid(false);
		bucketTable.setShowHorizontalLines(false);
		bucketTable.setShowVerticalLines(false);
		bucketTable.setSelectionBackground(new Color(255, 192, 203));

		
		bucketTable.setRowMargin(10);
		bucketTable.setRowHeight(30);
		bucketTable.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		
		// 테이블 로우 중 한 줄만 선택 가능.
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bucketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(stockdao.stockAll());

		stockScrollPane.setViewportView(stockTable);
		bucketScrollPane.setViewportView(bucketTable);
		
		
		stockTable.getTableHeader().setFont(new Font("나늠고딕", Font.PLAIN, 15));
		stockTable.getTableHeader().setOpaque(false);
		stockTable.getTableHeader().setBackground(new Color(32, 136, 203));
		stockTable.getTableHeader().setForeground(new Color(255, 255, 255));
		
		bucketTable.getTableHeader().setFont(new Font("나늠고딕", Font.PLAIN, 15));
		bucketTable.getTableHeader().setOpaque(false);
		bucketTable.getTableHeader().setBackground(new Color(32, 136, 203));
		bucketTable.getTableHeader().setForeground(new Color(255, 255, 255));
	}

	// Jtable에 로우 하나씩 추가하기.
	public void addStockLine(ArrayList<Stock> stocks) {
		int size = stocks.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			//rows.addElement(Integer.toString(stocks.get(i).getStock_no()));
			rows.addElement(stocks.get(i).getProduct_id());
			rows.addElement(stocks.get(i).getProduct_name());
			rows.addElement(Integer.toString(stocks.get(i).getQuantity()));
			rows.addElement(Integer.toString(stocks.get(i).getPrice()));
			
			// 로우마다 테이블에 뿌려주기.
			stockTblModel.addRow(rows);
		}

		stockScrollPane.setViewportView(stockTable);
	}

	private Vector<String> getColum(String check) {
		Vector<String> colNames = new Vector<String>();
		if(check.equals("stock")) {
			stockcolNames = new Vector<String>();
			//stockcolNames.add("재고번호");
			stockcolNames.add("상품코드");
			stockcolNames.add("상품명");
			stockcolNames.add("수량");
			stockcolNames.add("가격");
			
			
			colNames =  stockcolNames;
		}else if(check.equals("bucket")){
			bucketcolNames = new Vector<String>();
			bucketcolNames.add("상품코드");
			bucketcolNames.add("상품명");
			bucketcolNames.add("수량");
			bucketcolNames.add("가격");
			
			
			colNames =  bucketcolNames;
		}
		
		return colNames;

	}
}
