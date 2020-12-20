package order;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class OrderView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	OrderDao od = new OrderDao();
	
	JScrollPane scrollpane = new JScrollPane();
	static Vector<String> colNames = getColum();
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable orderTable = new JTable(model){
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	public Vector<String> rows;
	
	public OrderView() {
		setLayout(null);
		
		scrollpane.setBounds(12, 10, 1133, 200);
		add(scrollpane);
		
		orderTable.setRowMargin(10);
		orderTable.setRowHeight(30);		
		orderTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addProductLine(od.productAll()); 
		scrollpane.setViewportView(orderTable);
		
	}
	
	public void addProductLine(ArrayList<Order> products) {
		int size = products.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(Integer.toString(products.get(i).getPrice()));
			
			rows.addElement(Integer.toString(products.get(i).getQuantity()));

			model.addRow(rows);
		}
		scrollpane.setViewportView(orderTable);
	}
	
	private static Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("가격");
		// 재고 추가
		colNames.add("재고");

		return colNames;
	}
	
}