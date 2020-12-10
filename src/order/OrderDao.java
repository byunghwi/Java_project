package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

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
		sql = "SELECT * FROM order_product WHERE save_status = \'N\'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			while (rs.next()) {
				order = new Order();

				order.setProduct_id(rs.getString(1));
				order.setProduct_name(rs.getString(2));
				order.setQuantity(rs.getInt(3));
				order.setPrice(rs.getInt(4));

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
	
	
	// 상품 주문
	public void productOrder() {
		conn = DatabaseConnect.getConnection();

		sql = "UPDATE product SET quantity = quantity +  WHERE product_id = ''";

		try {
			ps = conn.prepareStatement(sql);
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