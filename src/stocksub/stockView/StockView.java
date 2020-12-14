package stocksub.stockView;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import stocksub.Stock;
import stocksub.StockDao;

// 상품 정보에 대응하는 패널
public class StockView extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	public StockDao sdao = new StockDao();
	public JScrollPane stocksScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0){ 
		// 테이블의 요소 더블클릭 시 수정 되지 않도록 추가
		public boolean isCellEditable(int i, int c)
			{ 
				return false; 
			}};




	public JTable stockTable = new JTable(tblModel);

	public Vector<String> rows;
	
	public StockView(){
		setLayout(null);
	
		stocksScrollPane.setBounds(12, 10, 1133, 532);
		add(stocksScrollPane);
		
		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);		
		stockTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(sdao.stockAll()); 
		
		stocksScrollPane.setViewportView(stockTable);
	}

	public void addStockLine(ArrayList<Stock> stocks) {
		int size = stocks.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(stocks.get(i).getProduct_id());
			rows.addElement(stocks.get(i).getProduct_name());
			rows.addElement(Integer.toString(stocks.get(i).getQuantity()));
			rows.addElement(Integer.toString(stocks.get(i).getPrice()));

			tblModel.addRow(rows);
		}
		
		stocksScrollPane.setViewportView(stockTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("가격");


		return colNames;
	}
}