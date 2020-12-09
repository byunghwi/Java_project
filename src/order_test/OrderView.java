//package order_test;
//
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.table.DefaultTableModel;
//
//public class OrderView extends JPanel {
//	
//	OrderDao od = new OrderDao();
//	JScrollPane sp = new JScrollPane(); // 스크롤 설정
//	Vector<String> data = getColum();
//	DefaultTableModel model = new DefaultTableModel(data, 0);
//	JTable table = new JTable(model);
//	Vector<String> title;
//	
//	public OrderView(){
//		setLayout(null);
//	
//		sp.setBounds(12, 10, 1133, 532);
//		add(sp);
//		
//		table.setRowMargin(10);
//		table.setRowHeight(30);		
//		
//		//테이블 로우 중 한 줄만 선택 가능.
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		addProductLine(od.productAll()); 
//		sp.setViewportView(table);
//	}
//
//	//Jtable에 로우 하나씩 추가하기.
//	public void addProductLine(ArrayList<OrderProductList> products) {
//		int size = products.size();
//
//		for (int i = 0; i < size; i++) {
//			title = new Vector<String>();
//			title.addElement(products.get(i).getProduct_id());
//			title.addElement(products.get(i).getProduct_name());
//			title.addElement(Integer.toString(products.get(i).getQuantity()));
//			title.addElement(Integer.toString(products.get(i).getPrice()));
//
//			//로우마다 테이블에 뿌려주기.
//			model.addRow(title);
//		}
//		
//		sp.setViewportView(table);
//	}
//	
//	private Vector<String> getColum() {
//		title = new Vector<String>();
//		title.add("상품코드");
//		title.add("상품명");
//		title.add("수량");
//		title.add("가격");
//
//		return title;
//	}
//	
//}
