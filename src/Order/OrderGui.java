//package Order;
////hikaricp로 해야되는거
//import java.awt.event.ActionEvent;
//
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//import db.DatabaseConnect;
//
//public class OrderGui extends JFrame implements ActionListener {
//	JButton order_button = new JButton("물품주문");
//	JButton cancel_button = new JButton("취소");
//	JTextArea product_list = new JTextArea();
//	
//	public OrderGui() {
//		setTitle("물품주문");
//		
//		layout();
//		
//		setBounds(200, 200, 300, 250);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//	
//	public void layout() {
//		JPanel panel = new JPanel();
//		panel.add(order_button);
//		panel.add(cancel_button);
//		product_list.setEditable(false); // 읽기만
//		JScrollPane spane  = new JScrollPane(product_list); // 스크롤바
//		
//		add("Center", spane);
//		add("South", panel);
//		
//		order_button.addActionListener(this);
//		cancel_button.addActionListener(this);
//	}
//	
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		try {
//			String sql = "SELECT * FROM product";
//			
//			if(e.getSource() == order_button) { // 주문버튼
//				
//			} else if(e.getSource() == cancel_button) { // 취소버튼
//				System.exit(0);
//			}
//			
//			DatabaseConnect db = new DatabaseConnect(sql);	
//			ResultSet rs = db.getRs();
//			product_list.setText("물품번호\t물품이름\t가격\n");
//			while (rs.next()) {
//				System.out.println(rs.getString(3));
//				String str = rs.getString("product_id") 
//						+ "\t" 
//						+ rs.getString("product_name") 
//						+ "\t" 
//						+ rs.getString("price") 
//						+ "\n";  
//				product_list.append(str);							
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	} 
//	
//
//	public static void main(String[] args) {
//		new OrderGui();
//	}
//	
//	
//}