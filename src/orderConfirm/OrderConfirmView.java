package orderConfirm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class OrderConfirmView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	OrderConfirmDao ocd = new OrderConfirmDao();
	
	public JScrollPane scrollpane = new JScrollPane();
	public static Vector<String> colNames = getColum();
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable orderTable = new JTable(model){
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	Image backgroundimg = new ImageIcon("C:\\JAVA_SW_PHM\\shop.jpg").getImage();

	public Vector<String> rows;
	
	public OrderConfirmView() {
		setLayout(null);
		
		scrollpane.setBounds(12, 10, 1133, 250);
		add(scrollpane);
		
		orderTable.setRowMargin(10);
		orderTable.setRowHeight(30);
		orderTable.setFont(new Font("맑음 고딕", Font.PLAIN, 15));
		
		orderTable.setGridColor(Color.LIGHT_GRAY);
		orderTable.setSelectionBackground(Color.PINK);
		orderTable.setBackground(Color.WHITE);
		orderTable.setShowHorizontalLines(false);
		orderTable.setForeground(Color.BLACK);
		orderTable.setShowVerticalLines(false);
		
		orderTable.getTableHeader().setOpaque(false);
		orderTable.getTableHeader().setBackground(new Color(32, 136, 203));
		orderTable.getTableHeader().setForeground(new Color(255, 255, 255));
		
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addProductLine(ocd.productAll());
		scrollpane.setViewportView(orderTable);
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
			rows.addElement(products.get(i).getProduct_name().toString());
			rows.addElement(Integer.toString(products.get(i).getPrice()));

			model.addRow(rows);
		}
		scrollpane.setViewportView(orderTable);
	}
	
	private static Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("발주번호");
		colNames.add("상품id");
		colNames.add("수량");
		colNames.add("처리자");
		colNames.add("처리시간");
		colNames.add("상품명");
		colNames.add("가격");

		return colNames;
	}
	
}