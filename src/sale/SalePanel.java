package sale;

import java.awt.Font;
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

import product.Product;
import stock.Stock;
import stock.StockDao;

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
		prodnameLb.setFont(new Font("굴림체", Font.PLAIN, 13));
		prodQtLb = new JLabel("상품수량");
		prodQtLb.setFont(new Font("굴림체", Font.PLAIN, 13));
		
		stockTblLb = new JLabel("재고목록");
		stockTblLb.setFont(new Font("굴림체", Font.BOLD, 15));
		bucketTblLb = new JLabel("장바구니");
		bucketTblLb.setFont(new Font("굴림체", Font.BOLD, 15));
			
		addBucketBtn =  new JButton("추가");
		addBucketBtn.setFont(new Font("굴림체", Font.PLAIN, 12));
		delBucketBtn = new JButton("삭제");
		delBucketBtn.setFont(new Font("굴림체", Font.PLAIN, 12));
		completeBtn = new JButton("결제");
		completeBtn.setFont(new Font("굴림체", Font.PLAIN, 12));
		
		stockTblLb.setBounds(50, 0, 70, 50);
		bucketTblLb.setBounds(710, 0, 70, 50);
		prodnameLb.setBounds(470, 490, 70, 20);
		prodQtLb.setBounds(560, 490, 70, 20);
		prodnameTf.setBounds(470, 510, 90, 30);
		prodQt.setBounds(560, 510, 70, 30);
		addBucketBtn.setBounds(660, 510, 70, 30);
		delBucketBtn.setBounds(735, 510, 70, 30);
		completeBtn.setBounds(810, 510, 70, 30);

		add(stockTblLb);
		add(bucketTblLb);
		add(prodnameLb);
		add(prodQtLb);
		add(prodnameTf);
		add(prodQt);
		add(addBucketBtn);
		add(delBucketBtn);
		add(completeBtn);
		
		stockScrollPane.setBounds(12, 44, 600, 444);
		bucketScrollPane.setBounds(680, 44, 450, 444);
		add(stockScrollPane);
		add(bucketScrollPane);

		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);
		stockTable.setFont(new Font("굴림체", Font.PLAIN, 14));

		
		bucketTable.setRowMargin(10);
		bucketTable.setRowHeight(30);
		bucketTable.setFont(new Font("굴림체", Font.PLAIN, 14));
		
		// 테이블 로우 중 한 줄만 선택 가능.
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bucketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(stockdao.stockAll());

		stockScrollPane.setViewportView(stockTable);
		bucketScrollPane.setViewportView(bucketTable);
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
