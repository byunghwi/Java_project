package stock;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class StockPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	StockDao stkdao = new StockDao();
	public JScrollPane stockScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable StockTable = new JTable(tblModel);
	// 행 정보들 담을 벡터
	public Vector<String> rows;

	public StockPanel() {

		setLayout(null);
		
		stockScrollPane.setBounds(12, 10, 1133, 532);
		add(stockScrollPane);

		StockTable.setRowMargin(10);
		StockTable.setRowHeight(30);
		StockTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		// 테이블 로우 중 한 줄만 선택 가능.
		StockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addProductLine(stkdao.stockAll());

		stockScrollPane.setViewportView(StockTable);
		
	}

	// Jtable에 로우 하나씩 추가하기.
	public void addProductLine(ArrayList<Stock> stocks) {
		int size = stocks.size();

		for (int i = 0; i < size; i++) {

			rows = new Vector<String>();
			//rows.addElement(Integer.toString(stocks.get(i).getStock_no()));
			rows.addElement(stocks.get(i).getProduct_id());
			rows.addElement(stocks.get(i).getProduct_name());
			rows.addElement(Integer.toString(stocks.get(i).getPrice()));
			rows.addElement(Integer.toString(stocks.get(i).getQuantity()));

			// 로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}

		stockScrollPane.setViewportView(StockTable);
	}

	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("가격");
		colNames.add("수량");

		return colNames;
	}
}
