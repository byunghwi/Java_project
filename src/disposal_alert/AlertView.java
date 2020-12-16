package disposal_alert;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlertView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	AlertDao ad = new AlertDao();
	public JScrollPane scrollpane = new JScrollPane();
	public static Vector<String> colNames = getColum();
	public DefaultTableModel model = new DefaultTableModel(colNames, 0);
	public JTable table = new JTable(model);
	public Vector<String> rows;
	
	public AlertView() {
		add(scrollpane);
		
		table.setRowMargin(10);
		table.setRowHeight(30);
		
		addProductLine(ad.productAll());
		scrollpane.setViewportView(table);
		
		table.setEnabled(false);
	}
	
	public void addProductLine(ArrayList<Disposal_product> products) {
		int size = products.size();
		
		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(products.get(i).getDis_date().toString());

			model.addRow(rows);
		}
		scrollpane.setViewportView(table);
	}
	
	private static Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품명");
		colNames.add("폐기날짜");

		return colNames;
	}
	
}