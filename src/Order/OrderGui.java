package Order;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

public class OrderGui extends JFrame {

	private static final long serialVersionUID = 1L;
	Vector data, title; // 배열역할
	JTable table;
	DefaultTableModel model; // 테이블 데이터 설정할 수 있게 설정

	JButton order_button, cancel_button; // 주문,취소 버튼
	JTextField ptoduct_text, amount_text;
	JLabel product_label, amount_label;

	public OrderGui() {
		super("발주 시스템");
		data = new Vector<>();
		title = new Vector<>();
		title.add("물품ID");
		title.add("물품명");
		title.add("재고");
		title.add("가격");

		model = new DefaultTableModel();
		Vector result = selectAll(); // Vector data(product테이블 물품) 가져올 배열
		model.setDataVector(result, title); // 2차원 배열
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table); // 스크롤 설정
		table.setEnabled(false); // 그래프 더블클릭 편집 못하게 설정
		JPanel panel = new JPanel();
		
		ptoduct_text = new JTextField(20);
		amount_text = new JTextField(10);

		product_label = new JLabel("물품id");
		amount_label = new JLabel("수량");

		order_button = new JButton("물품주문");
		cancel_button = new JButton("취소");
		
		// 물품주문버튼실행
		order_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HikariDataSource ds = new HikariDataSource();
				ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
				ds.setUsername("puser");
				ds.setPassword("12341234");
				try {
					String product = ptoduct_text.getText();
					int amount = Integer.parseInt(amount_text.getText());
					Connection conn = ds.getConnection();
					
					String sql = "UPDATE product SET quantity = quantity + "+amount+" WHERE product_id = '"+product+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
					model.fireTableDataChanged(); // 테이블 내용 갱신
					model.setNumRows(0); // 테이블 날리고 
					selectAll(); // 새로 받아와서 갱신
					
					pstmt.close();
					conn.close();
					ds.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		// 취소버튼실행
		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(product_label);
		panel.add(ptoduct_text);
		
		panel.add(amount_label);
		panel.add(amount_text);

		panel.add(order_button);
		panel.add(cancel_button);

		Container c = getContentPane();

		c.add(new JLabel("물품목록", JLabel.CENTER),"North");
		c.add(sp, BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);
	}

	
	public Vector selectAll() { // selectAll() : product 테이블에 있는 모든 데이터를 가지고 오는 메소드
		try{
			HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
			ds.setUsername("puser");
			ds.setPassword("12341234");
			Connection conn = ds.getConnection();
			
			// product테이블에 null값인 상품수량 -> 0부터 시작할수 있게 바꿔줌
			String nullsql = "update product set quantity = 0 where quantity is null";
			PreparedStatement nullpstmt = conn.prepareStatement(nullsql);
			nullpstmt.executeUpdate();
			
			String sql = "select * from product";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){ // 그래프에서 값 가져와 정렬
				Vector in = new Vector<String>();
				
				String id = rs.getString(1); // product_id
				String name = rs.getString(2); // product_name
				int quantity = rs.getInt(5); // quantity
				int price = rs.getInt(6); // price
				
				in.add(id);
				in.add(name);
				in.add(quantity);
				in.add(price);
				
				data.add(in);
			}
			
			rs.close();
			pstmt.close();
			
			nullpstmt.close();
			
			conn.close();
			ds.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data; 
	}

}