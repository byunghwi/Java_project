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
	PreparedStatement ps, ps2;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String sql, sql2;
	OrderConfirm order;
	
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
		
		String manu_date = RandomDay.randomDOB();
		String dis_date = RandomDay.randomDOB();
		
		sql = "INSERT INTO stock VALUES(STOCK_NO_SEQ.nextval, ?, ?, SYSDATE, ?, ?, ?, ?, 'Y')";
		sql2 = "DELETE FROM order_product WHERE ORDER_PRODUCT_NO = ? AND product_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[2].getText()); // 물품id
			ps.setString(2, fields[1].getText()); // 물품명
			ps.setString(3, manu_date.toString()); // 제조일
			ps.setString(4, dis_date.toString()); // 폐기일
			ps.setInt(5, Integer.parseInt(fields[3].getText())); // 가격
			ps.setInt(6, Integer.parseInt(fields[4].getText())); // 수량
			ps.executeUpdate();
			
			ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, fields[0].getText()); // 발주번호
			ps2.setString(2, fields[2].getText()); // 물품id
			ps2.executeUpdate();
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
			ps.setString(2, fields[2].getText());
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