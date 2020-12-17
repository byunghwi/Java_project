package orderConfirm;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
		sql = "SELECT order_product.*, product.product_name "
				+ "FROM product, order_product WHERE product.product_id = order_product.product_id";
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
				order.setProduct_name(rs.getString(6));

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
		
		String manu_date = Date_manu.randomDOB();
		String dis_date = Date_dis.randomDOB();
		
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
	
	// 승인대기 검색
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
		conn = DatabaseConnect.getConnection();
        String sql = "SELECT\r\n"
        		+ "    order_product.*, product.product_name\r\n"
        		+ "FROM product, order_product\r\n"
        		+ "WHERE product.product_id = order_product.product_id \r\n"
        		+ "AND product."+ fieldName.trim() +" LIKE '%" + word.trim() + "%'";
        try {
        	ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            // DefaultTableModel에 있는 기존 데이터 지우기
            for (int i = 0; i < dt.getRowCount();) {
                dt.removeRow(0);
            }
            while (rs.next()) {
                Object data[] = { 
                		rs.getInt(1),
                		rs.getString(2), 
                		rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6) };
                dt.addRow(data);
            }
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