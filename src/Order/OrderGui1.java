package Order;
// hikaricp로 하지않은거
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OrderGui1 extends JFrame implements ActionListener{
	JButton order_button = new JButton("물품주문");
	JButton cancel_button = new JButton("취소");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public OrderGui1() {
		setTitle("물품주문");
		
		layInit();	//레이아웃 메소드
		accDb();	//db접근메소드
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//레이아웃
	private void layInit() {
		JPanel panel = new JPanel();		
		panel.add(order_button); 
		panel.add(cancel_button); 
		txtResult.setEditable(false); //읽기만
		JScrollPane pane = new JScrollPane(txtResult); // ScrollBar 추가
		
		add("Center", pane);
		add("South", panel);
		
		order_button.addActionListener(this);
		cancel_button.addActionListener(this);
	}
	
	
	private void accDb() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//Driver 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144", 
					"puser",
					"12341234");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM product";
			
			if(e.getSource() == order_button) {
				
			} else if(e.getSource() == cancel_button) {	
				System.exit(0);
			}
			
			//읽기
			rs = stmt.executeQuery(sql);
			txtResult.setText("물품번호\t물품이름\t가격\n");
			while(rs.next()) {
				String str = rs.getString("product_id") 
						+ "\t" 
						+ rs.getString("product_name") 
						+ "\t" 
						+ rs.getString("price") 
						+ "\n";  
				txtResult.append(str);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {						
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new OrderGui1();
	}
}