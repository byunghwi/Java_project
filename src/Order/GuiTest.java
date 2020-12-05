package Order;

import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.zaxxer.hikari.HikariDataSource;

public class GuiTest extends JFrame implements ActionListener {
	JLabel product_label, amount_label; // 물품id, 수량 라벨
	JPanel product_panel, amount_panel, select; // id,수량,선택 패널
	JButton order_button, cancel_button;
	JTextArea product_list; //물품리스트 + 스크롤바추가예정
	JTextField ptoduct_text, amount_text;
	
	ResultSet rs;
	
	public GuiTest() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		setTitle("물품주문"); // 타이틀 제목
		
		//hikaricp 접속
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "SELECT * FROM product";
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			//물품id 패널
			product_panel = new JPanel();
			product_label = new JLabel("물품id:");
			ptoduct_text = new JTextField(10);
			product_panel.add(product_label);
			product_panel.add(ptoduct_text);
			
			//수량 패널
			amount_panel = new JPanel();
			amount_label = new JLabel("수량:");
			amount_text = new JTextField(10);
			amount_panel.add(amount_label);
			amount_panel.add(amount_text);
			
			//버튼
			select = new JPanel();		
			order_button = new JButton("물품주문"); // 수량확인후 주문버튼
			cancel_button = new JButton("취소"); // 취소버튼
			select.add(order_button);
			select.add(cancel_button);
			order_button.addActionListener(this);
			cancel_button.addActionListener(this);
			
			// 패널추가
			c.add(product_panel);//id, pw, 버튼 추가
	        c.add(amount_panel);
	        c.add(select);
			
	        product_list = new JTextArea();
	        JScrollPane s = new JScrollPane(product_list);
	        
	        c.add(s);//textarea 추가
			
	        product_list.setText("물품번호\t물품이름\t가격\n");
			while(rs.next()) {
				String str = rs.getString("product_id") 
						+ "\t" 
						+ rs.getString("product_name") 
						+ "\t" 
						+ rs.getString("price") 
						+ "\n";  
				product_list.append(str);
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
		setSize(250, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == order_button) {
			
		} else if(e.getSource() == cancel_button) {	
			System.exit(0);
		}
	}
	
}
