package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import db.DatabaseConnect;

public class OrderDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String sql;
	Order order;
	
	// 주문물품 목록
	public ArrayList<Order> productAll() {
		conn = DatabaseConnect.getConnection();
		ArrayList<Order> products = new ArrayList<Order>();
		sql = "SELECT * FROM product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			while (rs.next()) {
				order = new Order();

				order.setProduct_id(rs.getString(1));
				order.setProduct_name(rs.getString(2));
				order.setPrice(rs.getInt(3));

				products.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	// 승인테이블로 이동
	public void moveconfirm(JTextField[] fields) {
		conn = DatabaseConnect.getConnection();
		sql = "insert into order_product VALUES(ORDER_PRODUCT_NO_SEQ.nextval, ?, ?, ?, to_char(sysdate,'yyyy.mm.dd'))";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[0].getText());
			ps.setInt(2, Integer.parseInt(fields[1].getText()));
			ps.setString(3, fields[2].getText());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}