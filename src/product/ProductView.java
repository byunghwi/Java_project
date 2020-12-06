package product;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ProductView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JScrollPane productsScrollPane = new JScrollPane();
	ProductDao pdao = new ProductDao();
	public Vector<String> colNames = pdao.columnNames;
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable productTable = new JTable(tblModel);
	
	public ProductView(){
		setLayout(null);
	
		productsScrollPane.setBounds(20, 30, 980, 600);
		add(productsScrollPane);
		
		productTable.setRowMargin(10);
		productTable.setRowHeight(30);
		
		productTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		showProducts(pdao.products); 

		productsScrollPane.setViewportView(productTable);
	}

	public void showProducts(ArrayList<Product> products) {
		int size = products.size();
		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(products.get(i).getManu_date().toString());
			rows.addElement(products.get(i).getDis_date().toString());
			rows.addElement(Integer.toString(products.get(i).getQuantity()));
			rows.addElement(Integer.toString(products.get(i).getPrice()));
//			System.out.printf("%s \t %s \t %s \t %s \t %s \t %s\n", 
//					products.get(i).getProduct_id(), products.get(i).getProduct_name() 
//					, products.get(i).getManu_date().toString(), products.get(i).getDis_date().toString()
//					, Integer.toString(products.get(i).getQuantity())
//					, Integer.toString(products.get(i).getPrice()));
			tblModel.addRow(rows);
		}
		
		productsScrollPane.setViewportView(productTable);
	}

}
