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
	Vector data, title;
	JTable table;
	DefaultTableModel model;

	JButton order_button, cancel_button;
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
		Vector result = selectAll();
		model.setDataVector(result, title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setEnabled(false);
		JPanel panel = new JPanel();
		
		ptoduct_text = new JTextField(20);
		amount_text = new JTextField(10);

		product_label = new JLabel("물품id");
		amount_label = new JLabel("수량");

		order_button = new JButton("물품주문");
		cancel_button = new JButton("취소");

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
					
					pstmt.close();
					conn.close();
					ds.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

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

	
	public Vector selectAll() {
		try{
			HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
			ds.setUsername("puser");
			ds.setPassword("12341234");
			Connection conn = ds.getConnection();
			String sql = "select * from product";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Vector in = new Vector<String>();
				
				String id = rs.getString(1); 
				String name = rs.getString(2); 
				int quantity = rs.getInt(5); 
				int price = rs.getInt(6); 
				
				in.add(id);
				in.add(name);
				in.add(quantity);
				in.add(price);
				
				data.add(in);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			ds.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}


}