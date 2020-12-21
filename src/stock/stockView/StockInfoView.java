package stock.stockView;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import stock.StockDao;
import stock.Stock_info;


// 상품 상세 정보에 대응하는 패널
public class StockInfoView extends JPanel {

private static final long serialVersionUID = 1L;
	
	public StockDao sdao = new StockDao();
	public JScrollPane stocksScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0){ 
		public boolean isCellEditable(int i, int c)
		{ 
			return false; 
		}};
	public JTable stockTable = new JTable(tblModel);

	public Vector<String> rows;
	public String product_id;
	
	public StockInfoView(String product_id){
		this.product_id = product_id;
		setLayout(null);
	
		stocksScrollPane.setBounds(12, 10, 640, 300);
		add(stocksScrollPane);
		
		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);		
		stockTable.setFont(new Font("나눔 고딕", Font.PLAIN, 15));
		

		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(sdao.stockInfos(product_id)); 
		
		stocksScrollPane.setViewportView(stockTable);
	}


	public void addStockLine(ArrayList<Stock_info> stock_infos) {
		int size = stock_infos.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(stock_infos.get(i).getProduct_id());
			rows.addElement(stock_infos.get(i).getProduct_name());
			rows.addElement(Integer.toString(stock_infos.get(i).getQuantity()));
			rows.addElement(stock_infos.get(i).getManu_date().toString());
			rows.addElement(stock_infos.get(i).getDis_date().toString());
			

			tblModel.addRow(rows);
		}
		
		stocksScrollPane.setViewportView(stockTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("제조일");
		colNames.add("폐기일");


		return colNames;
	}
}
