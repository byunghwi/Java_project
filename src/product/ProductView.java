package product;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	ProductDao pdao = new ProductDao();
	public JScrollPane productsScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable productTable = new JTable(tblModel);
	//행 정보들 담을 벡터
	public Vector<String> rows;
	
	public ProductView(){
		setLayout(null);
		
	
		productsScrollPane.setBounds(12, 10, 1133, 532);
		add(productsScrollPane);
		
		productTable.setRowMargin(10);
		productTable.setRowHeight(30);		
		productTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addProductLine(pdao.productAll()); 
		
		productsScrollPane.setViewportView(productTable);
		
	}

	//Jtable에 로우 하나씩 추가하기.
	public void addProductLine(ArrayList<Product> products) {
		int size = products.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(Integer.toString(products.get(i).getPrice()));
			rows.addElement(products.get(i).getWorker_no());
			rows.addElement(products.get(i).getSave_time());

			//로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}
		
		productsScrollPane.setViewportView(productTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("가격");
		colNames.add("등록자");
		colNames.add("등록일");

		return colNames;
	}
}
