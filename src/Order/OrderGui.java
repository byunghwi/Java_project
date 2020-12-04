package Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import db.DatabaseConnect;

public class OrderGui extends JFrame implements ActionListener {
	JButton order_button = new JButton("물품주문");
	JButton cancel_button = new JButton("취소");
	JTextArea product_list = new JTextArea();
	
	public OrderGui() {
		setTitle("물품주문");
		
		layout();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void layout() {
		JPanel panel = new JPanel();
		panel.add(order_button);
		panel.add(cancel_button);
		product_list.setEditable(false); // 읽기만
		JScrollPane spane  = new JScrollPane(product_list); // 스크롤바
		
		add("Center", spane);
		add("South", panel);
		
		order_button.addActionListener(this);
		cancel_button.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String sql = "SELECT * FROM product";
		
		DatabaseConnect db = new DatabaseConnect(sql);	
		ResultSet rs = db.getRs();
		
		if (e.getSource() == order_button) {
			
		} else if (e.getSource() == cancel_button) {
			System.exit(0);
		}
		
		product_list.setText("고객번호\t고객명\t주민번호\n");
		try {
			while(rs.next()) {
				String str = rs.getString("product_id") 
						+ "\t" + rs.getString("product_name") 
						+ "\t" + rs.getInt("price") 
						+ "\n";  
				product_list.append(str);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		} 
	

	public static void main(String[] args) {
		new OrderGui();
	}
	
	
}