package order;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class OrderConfirmView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	OrderConfirmDao ocd = new OrderConfirmDao();
	JScrollPane scrollpane = new JScrollPane();
	Vector<String> colNames = getColum();
	public DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable orderTable = new JTable(model);
	public Vector<String> rows;
	public JButton order_btn, confirm_btn, delete_btn, cancel_btn; // 주문, 승인, 삭제, 취소 버튼
	JPanel panel = new JPanel();
	
	public OrderConfirmView() {
		setLayout(null);
		
		scrollpane.setBounds(12, 10, 1133, 532);
		add(scrollpane);
		
		orderTable.setRowMargin(10);
		orderTable.setRowHeight(30);		
		orderTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addProductLine(ocd.productAll()); 
		scrollpane.setViewportView(orderTable);
		
		order_btn = new JButton("주문");
		confirm_btn = new JButton("승인");
		delete_btn = new JButton("삭제");
		cancel_btn = new JButton("취소");
		
		panel.add(order_btn);
		panel.add(confirm_btn);
		panel.add(delete_btn);
		panel.add(cancel_btn);
		
		Container c = getRootPane();
		
		c.add(panel, BorderLayout.SOUTH);
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