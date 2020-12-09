package order_test;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DatabaseConnect;

public class OrderFrame extends JFrame {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	ResultSetMetaData rsmd;

	private static final long serialVersionUID = 1L;
	Vector data, title; // 배열역할
	JTable table;
	DefaultTableModel model; // 테이블 데이터 설정할 수 있게 설정
	JButton order_button, cancel_button; // 주문,취소 버튼
	JTextField product_text, amount_text;
	JLabel product_label, amount_label;

	public OrderFrame() {
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
		product_label = new JLabel("물품id");
//		product_text = new HintTextField("id 입력");
		product_text = new JTextField(20);
		amount_label = new JLabel("수량");
//		amount_text = new HintTextField("수량 입력");
		amount_text = new JTextField(20);
		order_button = new JButton("물품주문");
		cancel_button = new JButton("취소");
		
		// 물품주문버튼실행
		order_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conn = DatabaseConnect.getConnection();
				String product = product_text.getText();
				int amount = Integer.parseInt(amount_text.getText());
				
				String sql = "UPDATE product SET quantity = quantity + "+amount+" WHERE product_id = '"+product+"'";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
					model.fireTableDataChanged(); // 테이블 내용 갱신
					model.setNumRows(0); // 테이블 날리고 
					selectAll(); // 새로 받아와서 갱신
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					DatabaseConnect.dbClose(rs, ps, conn);
				} catch (SQLException e1) {
					System.out.println("[DB] 자원 반납 중 오류 발생\n");
					e1.printStackTrace();
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
		
		// JLabel,JTextField(물품id, 수량), 주문,취소 버튼 add
		panel.add(product_label);
		panel.add(product_text);
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
		conn = DatabaseConnect.getConnection();
		String sql = "select * from product";
		try{
			// product테이블에 null값인 상품수량 -> 0부터 시작할수 있게 바꿔줌
//			String nullsql = "update product set quantity = 0 where quantity is null";
//			PreparedStatement nullpstmt = conn.prepareStatement(nullsql);
//			nullpstmt.executeUpdate();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			
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
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		return data; 
	}

}