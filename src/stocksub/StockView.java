package stocksub;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class StockView extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	public StockDao sdao = new StockDao();
	public JScrollPane stocksScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable stockTable = new JTable(tblModel);
	//행 정보들 담을 벡터
	public Vector<String> rows;
	
	public StockView(){
		setLayout(null);
	
		stocksScrollPane.setBounds(12, 10, 1133, 532);
		add(stocksScrollPane);
		
		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);		
		stockTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(sdao.stockAll()); 
		
		stocksScrollPane.setViewportView(stockTable);
	}

	//Jtable에 로우 하나씩 추가하기.
	public void addStockLine(ArrayList<Stock> stocks) {
		int size = stocks.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(stocks.get(i).getProduct_id());
			rows.addElement(stocks.get(i).getProduct_name());
			rows.addElement(Integer.toString(stocks.get(i).getQuantity()));
			rows.addElement(Integer.toString(stocks.get(i).getPrice()));

			//로우마다 테이블에 뿌려주기.
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