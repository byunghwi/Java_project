package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import db.DatabaseConnect;

public class OrderConfirmDao {
	Connection conn;
	PreparedStatement ps, pstmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String sql;
	OrderConfirm order;
	
	// 발주 테이블 목록
	public ArrayList<OrderConfirm> productAll() {
		conn = DatabaseConnect.getConnection();
		ArrayList<OrderConfirm> products = new ArrayList<OrderConfirm>();
		sql = "SELECT product_name, SUM(quantity) FROM stock group by product_name";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderConfirm();

				order.setOrder_product_no(rs.getInt(1));
				order.setProduct_id(rs.getString(2));
				order.setProduct_name(rs.getString(3));
				order.setQuantity(rs.getInt(4));

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
	
	// 발주 승인
	public void confirmCheck(JTextField[] fields) {
		conn = DatabaseConnect.getConnection();
		sql = "UPDATE stock SET quantity = quantity + ? WHERE product_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(fields[1].getText()));
			ps.setString(2, fields[0].getText());
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
	
	// 발주 삭제
	public void confirmCancle(JTextField[] fields) {
		conn = DatabaseConnect.getConnection();
		sql = "DELETE FROM order_product WHERE product_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[0].getText());
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