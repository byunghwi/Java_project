package Order;

// hikaricp로 하지않은거
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.zaxxer.hikari.HikariDataSource;

public class OrderGui extends JFrame implements ActionListener{	
	JButton order_button = new JButton("물품주문");
	JButton cancel_button = new JButton("취소");
	static JTextArea txtResult = new JTextArea();
	static ResultSet rs;
	
	public OrderGui() {
		setTitle("물품주문");
		
		layInit();	//레이아웃 메소드
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "SELECT * FROM product";
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			//읽기
			rs = pstmt.executeQuery(sql);
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == order_button) {
			
		} else if(e.getSource() == cancel_button) {	
			System.exit(0);
		}
	}
	
}