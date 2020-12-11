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
	
	OrderConfirmView ocv = new OrderConfirmView();
	// 발주 테이블 목록
	public ArrayList<OrderConfirm> productAll() {
		conn = DatabaseConnect.getConnection();
		ArrayList<OrderConfirm> products = new ArrayList<OrderConfirm>();
		sql = "SELECT * FROM order_product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderConfirm();

				order.setOrder_product_no(rs.getInt(1));
				order.setProduct_id(rs.getString(2));
				order.setQuantity(rs.getInt(3));
				order.setWorker_no(rs.getString(4));
				order.setSave_time(rs.getDate(5));

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
		sql = "insert into stock VALUES("
				+ "STOCK_NO_SEQ.nextval, ?, \'testitem01\', "
				+ "\'20/12/11\', \'20/12/11\', \'20/12/12\', 10000, ?, \'Y\')";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[1].getText());
			ps.setInt(2, Integer.parseInt(fields[2].getText()));
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
		sql = "DELETE FROM order_product WHERE ORDER_PRODUCT_NO = ? AND product_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[0].getText());
			ps.setString(2, fields[1].getText());
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