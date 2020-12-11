package order;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
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

public class OrderView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	OrderDao od = new OrderDao();
	JScrollPane scrollpane = new JScrollPane();
	Vector<String> colNames = getColum();
	public DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable orderTable = new JTable(model);
	public Vector<String> rows;
	public JButton order_btn, cancel_btn; // 주문, 취소 버튼
	JPanel panel = new JPanel();
	
	public OrderView() {
		setLayout(null);
		
		scrollpane.setBounds(12, 10, 1133, 532);
		add(scrollpane);
		
		orderTable.setRowMargin(10);
		orderTable.setRowHeight(30);		
		orderTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addProductLine(od.productAll()); 
		scrollpane.setViewportView(orderTable);
		
		order_btn = new JButton("주문");
		cancel_btn = new JButton("취소");
		
		panel.add(order_btn);
		panel.add(cancel_btn);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	public void addProductLine(ArrayList<Order> products) {
		int size = products.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(Integer.toString(products.get(i).getPrice()));

			model.addRow(rows);
		}
		scrollpane.setViewportView(orderTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("가격");

		return colNames;
	}
	
}