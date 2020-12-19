package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
		// product테이블, stock테이블 inner Join 같은이름 상품 총재고 나오도록
		sql = "SELECT product.product_id, product.product_name, product.price, SUM(stock.quantity)\r\n"
				+ "FROM product\r\n"
				+ "INNER JOIN stock\r\n"
				+ "ON product.save_status = 'Y' \r\n"
				+ "group by product.product_id, product.product_name, product.price";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			while (rs.next()) {
				order = new Order();

				order.setProduct_id(rs.getString(1));
				order.setProduct_name(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setQuantity(rs.getInt(4));;

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
	
	// 주문(승인테이블로 이동)
	public void moveconfirm(JTextField[] fields) {
		conn = DatabaseConnect.getConnection();
		sql = "insert into order_product VALUES(ORDER_PRODUCT_NO_SEQ.nextval, ?, ?, ?, to_char(sysdate,'yyyy.mm.dd'))";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fields[0].getText()); // 물품id
			ps.setInt(2, Integer.parseInt(fields[1].getText())); // 수량
			ps.setString(3, fields[2].getText()); // 처리자명
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
	
	// 삭제(등록했던 상품삭제) - 필요하면 쓰려고 만들어둠
//	public void deleteproduct(JTextField[] fields) {
//		conn = DatabaseConnect.getConnection();
//		sql = "DELETE FROM product WHERE product_id = ?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, fields[0].getText());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DatabaseConnect.dbClose(rs, ps, conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
		conn = DatabaseConnect.getConnection();
        String sql = "SELECT * FROM stock WHERE " + fieldName.trim()
                + " LIKE '%" + word.trim() + "%'";
        try {
        	ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            // DefaultTableModel에 있는 기존 데이터 지우기
            for (int i = 0; i < dt.getRowCount();) {
                dt.removeRow(0);
            }
            while (rs.next()) {
                Object data[] = { 
                		rs.getString(2), 
                		rs.getString(3),
                        rs.getInt(7),
                        rs.getInt(8) };
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