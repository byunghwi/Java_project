package product;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import common.HintTextField;
import common.RoundedButton;

import javax.swing.JLabel;
import java.awt.Color;

public class ProductView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProductDao pdao = new ProductDao();
	public JScrollPane productsScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable productTable = new JTable(tblModel){
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	public String comboArr[] = new String[] {"검색항목을 선택하세요","상품코드", "상품명"};
	public JComboBox<String> jcombo = new JComboBox<String>(comboArr);
	public JTextField searchTf;
	public JButton searchBtn;
	
	//행 정보들 담을 벡터
	public Vector<String> rows;

	public ProductView(){
		setLayout(null);
		
		productsScrollPane.setBounds(12, 40, 1133, 500);
		add(productsScrollPane);
	
		jcombo.setBounds(410, 10, 150, 27);
		searchTf = new HintTextField("검색어를 입력하세요.");
		searchTf.setBounds(562, 10, 200, 28);
		searchBtn = new RoundedButton("검색");
		searchBtn.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		searchBtn.setBounds(764, 10, 70, 28);
		
		add(jcombo);
		add(searchTf);
		add(searchBtn);
		productTable.setShowGrid(false);
		productTable.setSelectionBackground(Color.PINK);
		productTable.setShowVerticalLines(false);
		productTable.setShowHorizontalLines(false);
		productTable.setRowMargin(10);
		productTable.setRowHeight(30);		
		productTable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		productTable.getTableHeader().setFont(new Font("나눔 고딕", Font.PLAIN, 15));
		productTable.getTableHeader().setOpaque(false);
		productTable.getTableHeader().setBackground(new Color(32, 136, 203));
		productTable.getTableHeader().setForeground(new Color(255, 255, 255));
		productTable.setRowHeight(25);
		
		//테이블 로우 중 한 줄만 선택 가능.
		productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addProductLine(pdao.productAll()); 
		
		productsScrollPane.setViewportView(productTable);
		
		JLabel lblNewLabel = new JLabel("상품 목록");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 10, 174, 23);
		add(lblNewLabel);
		
	}

	//Jtable에 로우 하나씩 추가하기.
	public void addProductLine(ArrayList<Product> products) {
		int size = products.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(Integer.toString(products.get(i).getPrice()));
			rows.addElement(products.get(i).getWorker_no());
			rows.addElement(products.get(i).getSave_time());

			//로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}
		
		productsScrollPane.setViewportView(productTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("가격");
		colNames.add("등록자");
		colNames.add("등록일");

		return colNames;
	}
}
