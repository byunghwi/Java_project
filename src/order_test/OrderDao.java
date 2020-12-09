//package order_test;
//
//import java.sql.Connection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.swing.JTextField;
//
//import db.DatabaseConnect;
//
//public class OrderDao {
//	Connection conn;
//	PreparedStatement ps;
//	ResultSet rs;
//	ResultSetMetaData rsmd;
//	
//	OrderProductList product;
//	String query;
//	
//	public  productAll() {
//
//		try {
//			ps = conn.prepareStatement(query);
//			rs = ps.executeQuery();
//			rsmd = rs.getMetaData();
//
//			int columCnt = rsmd.getColumnCount();
//
//			while (rs.next()) {
//				product = new OrderProductList();
//
//				product.setProduct_id(rs.getString(1));
//				product.setProduct_name(rs.getString(2));
//				product.setQuantity(rs.getInt(3));
//				product.setPrice(rs.getInt(4));
//
//				products.add(product);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DatabaseConnect.dbClose(rs, ps, conn);
//		} catch (SQLException e) {
//			System.out.println("[DB] 자원 반납 중 오류 발생\n");
//			e.printStackTrace();
//		}
//		return products;
//	}
//	
//		
//		// 발주 기능
//		public void productEdit(JTextField[] fields, String product_id) {
//			conn = DatabaseConnect.getConnection();
//
//			String product = product_text.getText();
//			int amount = Integer.parseInt(amount_text.getText());
//			
//			query = "UPDATE product SET quantity = quantity + "+amount+" WHERE product_id = '"+product+"'";
//			try {
//				ps = conn.prepareStatement(query);
//
//				ps.setString(1, fields[0].getText());
//				ps.setString(2, fields[1].getText());
//				ps.setString(3, fields[2].getText());
//				ps.setString(4, fields[3].getText());
//				ps.setString(5, fields[4].getText());
//				ps.setString(6, product_id);
//
//				int rsCnt = ps.executeUpdate();
//				
//				if(rsCnt > 0) {
//					System.out.println("[DB] Complete\n");
//				}
//
//			} catch (SQLException e) {
//				System.out.println("[DB] Update 중 오류 발생\n");
//				e.printStackTrace();
//			}
//			try {
//				DatabaseConnect.dbClose(rs, ps, conn);
//			} catch (SQLException e) {
//				System.out.println("[DB] 자원 반납 중 오류 발생\n");
//				e.printStackTrace();
//			}
//		}
//	
//}