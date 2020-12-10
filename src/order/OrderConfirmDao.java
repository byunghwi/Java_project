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
	PreparedStatement ps;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String sql;
	OrderConfirm order;
	
		// 발주 테이블 목록
		public ArrayList<OrderConfirm> productAll() {
			conn = DatabaseConnect.getConnection();
			ArrayList<OrderConfirm> products = new ArrayList<OrderConfirm>();
			sql = "SELECT * FROM order_product";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rsmd = rs.getMetaData();

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
		
		// 물품승인 (발주테이블 -> 물품테이블로 이동)
		public void productAdd(JTextField[] fields) {
			conn = DatabaseConnect.getConnection();

			sql = "insert into product (product_id, product_name, manu_date, dis_date, price) values (?, ? ,? ,?, ?)";

			try {
				ps = conn.prepareStatement(sql);

				ps.setString(1, fields[0].getText());
				ps.setString(2, fields[1].getText());
				ps.setString(3, fields[2].getText());
				ps.setString(4, fields[3].getText());
				ps.setInt(5, Integer.parseInt(fields[4].getText()));

				int rsCnt = ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println("[DB] Insert 중 오류 발생\n");
				e.printStackTrace();
			}
			try {
				DatabaseConnect.dbClose(rs, ps, conn);
			} catch (SQLException e) {
				System.out.println("[DB] 자원 반납 중 오류 발생\n");
				e.printStackTrace();
			}
		}
		
		// 상품 삭제
		public void productDel(String pid) {
			conn = DatabaseConnect.getConnection();

			sql = "DELETE FROM order_product WHERE product_id = ? ";

			try {

				ps = conn.prepareStatement(sql);
				ps.setString(1, pid);

				int rsCnt = ps.executeUpdate();
				if(rsCnt == 1) {
					System.out.println("[DB] 상품 삭제 업데이트 완료.\n");
				}

			} catch (SQLException e) {
				System.out.println("[DB] Update 중 오류 발생\n");
				e.printStackTrace();
			}

			// DB사용 종료
			try {
				DatabaseConnect.dbClose(rs, ps, conn);
			} catch (SQLException e) {
				System.out.println("[DB] 자원 반납 중 오류 발생\n");
				e.printStackTrace();
			}
		}
	
}