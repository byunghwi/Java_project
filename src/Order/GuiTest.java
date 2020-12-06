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
	JTextArea product_list = new JTextArea(10, 30);
	JLabel product_label, amount_label; // 물품id, 수량 라벨
	JTextField ptoduct_text, amount_text;
	JPanel product_panel, amount_panel, select; // id,수량,선택(주문할지 취소할지) 패널
	JButton order_button, cancel_button; // 주문,취소 버튼

	
	public GuiTest() {
		setTitle("물품주문"); // 타이틀 제목
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 물품목록 테이블
		product_list.setEditable(false); // read only
		JScrollPane pane = new JScrollPane(product_list); // ScrollBar 추가
		
		add("Center", pane);
		try {
			//hikaricp 접속
			HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
			ds.setUsername("hr");
			ds.setPassword("1234");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();
			
			product_list.setText("물품번호\t물품이름\t가격\n");
			while(rs.next()) {
				String str = rs.getString("first_name") 
						+ "\t" 
						+ rs.getString("last_name") 
						+ "\t" 
						+ rs.getInt("salary") 
						+ "\n";  
				product_list.append(str);
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		} 
			
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
		c.add(product_panel);
        c.add(amount_panel);
        c.add(select);
	        
		setBounds(200, 200, 350, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == order_button) {	// 주문버튼실행
			OrderCheck();
		} else if(e.getSource() == cancel_button) {	//취소버튼실행
			System.exit(0);
		}
	}


	public void OrderCheck() { // 주문후 완료창
		setTitle("완료");

        JPanel check = new JPanel();
        setContentPane(check);
        
        JLabel NewLabel = new JLabel("새주문완료!");
        check.add(NewLabel);
        
        setSize(300,100);
        setResizable(false);
        setVisible(true);
	}
	
}
