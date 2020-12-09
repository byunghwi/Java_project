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
		//System.out.println("상품들 arraylist 사이즈 > " + size);
		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(products.get(i).getProduct_id());
			rows.addElement(products.get(i).getProduct_name());
			rows.addElement(products.get(i).getManu_date().toString());
			rows.addElement(products.get(i).getDis_date().toString());
			rows.addElement(Integer.toString(products.get(i).getQuantity()));
			rows.addElement(Integer.toString(products.get(i).getPrice()));
			
//			System.out.printf("%s\t %s\t %s\t %s\t %s\t %s \n", 
//					products.get(i).getProduct_id(), 
//					products.get(i).getProduct_name(), 
//					products.get(i).getManu_date().toString(), 
//					products.get(i).getDis_date().toString(), 
//					Integer.toString(products.get(i).getQuantity()), 
//					Integer.toString(products.get(i).getPrice()) );
//			
//			System.out.println("한 줄 정보 > " +rows);
//			
			//로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}
		
		productsScrollPane.setViewportView(productTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("제조일");
		colNames.add("폐기일");
		colNames.add("수량");
		colNames.add("가격");

		return colNames;
	}
	
	//테이블 행 지우기. 화면단에서만
	public void clearRows(int rowSize, DefaultTableModel dtm) {
		if (rowSize > 0) {
			for (int i = rowSize - 1; i >= 0; i--) {
				dtm.removeRow(i);
			}
		}
	}

}
