package sale;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import common.HintTextField;
import product.Product;
import product.ProductView;

public class SaleDetailListFrame extends JFrame {
	
	SaleDao saledao = new SaleDao();
//	public JPanel contentPanel;
//	public JPanel centerPanel;
	public JPanel tablePanel;
	
	public CardLayout cardlayout;
	
	public JScrollPane saleDetailListScrollPane = new JScrollPane();	
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable saleDetailListTable = new JTable(tblModel) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	//행 정보들 담을 벡터
	public Vector<String> rows;


	String sales_no;

	public SaleDetailListFrame(String sales_no) {
		this.sales_no = sales_no;
		
		setFont(new Font("나눔고딕", Font.BOLD, 20));
		setTitle("판매 상세 리스트");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		setVisible(false);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		saleDetailListScrollPane.setBounds(10, 10, 760, 340);
		tablePanel.add(saleDetailListScrollPane);
		saleDetailListTable.setShowVerticalLines(false);
		saleDetailListTable.setShowHorizontalLines(false);
		saleDetailListTable.setShowGrid(false);
		saleDetailListTable.setSelectionBackground(Color.PINK);
		saleDetailListTable.setGridColor(new Color(135, 206, 235));
		
		saleDetailListTable.setRowMargin(10);
		saleDetailListTable.setRowHeight(30);		
		saleDetailListTable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		
		saleDetailListTable.getTableHeader().setFont(new Font("나눔고딕", Font.PLAIN, 15));
		saleDetailListTable.getTableHeader().setOpaque(false);
		saleDetailListTable.getTableHeader().setBackground(new Color(32, 136, 203));
		saleDetailListTable.getTableHeader().setForeground(new Color(255, 255, 255));
		
		//테이블 로우 중 한 줄만 선택 가능.
		saleDetailListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		addSaleDetailLine(saledao.salesDetailList(sales_no)); 

		saleDetailListScrollPane.setViewportView(saleDetailListTable);
		
		getContentPane().add(tablePanel);
	}

	// Jtable에 로우 하나씩 추가하기.
	public void addSaleDetailLine(ArrayList<SaleDetail> saleDetails) {
		int size = saleDetails.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();

			rows.addElement(Integer.toString(saleDetails.get(i).getSales_detail_no()));		// 판매 상세 번호
			rows.addElement(Integer.toString(saleDetails.get(i).getSales_no()));		// 판매 번호
			rows.addElement(saleDetails.get(i).getProduct_id()); 						// 상품코드
			rows.addElement(saleDetails.get(i).getProduct_name()); 						// 상품명
			rows.addElement(saleDetails.get(i).getEvent_type());						// 이벤트명
			rows.addElement(Integer.toString(saleDetails.get(i).getQuantity())); 		// 구매 수량
			rows.addElement(Integer.toString(saleDetails.get(i).getProduct_price()));	// 상품 가격
			
			// 로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}

		saleDetailListScrollPane.setViewportView(saleDetailListTable);
	}

	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("판매 상세번호");
		colNames.add("판매번호");
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("이벤트명");
		colNames.add("구매수량");
		colNames.add("금액");

		return colNames;
	}
}
