package order;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class OrderConfirmView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	OrderConfirmDao ocd = new OrderConfirmDao();
	public JScrollPane scrollpane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable orderTable = new JTable(model);
	public Vector<String> rows;
	
	public OrderConfirmView() {
		setLayout(null);
		
		scrollpane.setBounds(12, 10, 1133, 532);
		add(scrollpane);
		
		orderTable.setRowMargin(10);
		orderTable.setRowHeight(30);
		
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addProductLine(ocd.productAll()); 
		scrollpane.setViewportView(orderTable);
		
//		model.fireTableDataChanged(); // 테이블 내용 갱신
//		model.setNumRows(0); // 테이블 날리고 
//		addProductLine(ocd.productAll()); // 새로 받아와서 갱신
	}
	
	public void addProductLine(ArrayList<OrderConfirm> products) {
		int size = products.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(Integer.toString(products.get(i).getOrder_product_no()));
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(Integer.toString(products.get(i).getQuantity()));
			rows.addElement(products.get(i).getWorker_no());
			rows.addElement(products.get(i).getSave_time().toString());

			model.addRow(rows);
		}
		scrollpane.setViewportView(orderTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("발주번호");
		colNames.add("상품번호");
		colNames.add("수량");
		colNames.add("처리자");
		colNames.add("처리시간");

		return colNames;
	}
	
}