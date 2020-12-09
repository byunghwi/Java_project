package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTextField;

import db.DatabaseConnect;

public class ProductDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;

	ResultSetMetaData rsmd = null;

	String query = null;

	Product product = null;

	// 상품 전체 목록
	public ArrayList<Product> productAll() {

		conn = DatabaseConnect.getConnection();
		// 상품들 담을 ArrayList 생성
		ArrayList<Product> products = new ArrayList<Product>();

		query = "SELECT product_id as \"상품코드\", product_name as \"상품명\", to_char(manu_date, 'YYYY-MM-dd') as \"제조일\" "
				+ ", to_char(dis_date, 'YYYY-MM-dd') as \"폐기일\", quantity as \"수량\", price \"가격\" "
				+ " FROM product WHERE save_status = \'Y\' ORDER BY product_id";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				product = new Product();

				product.setProduct_id(rs.getString(1));
				product.setProduct_name(rs.getString(2));
				product.setManu_date(rs.getDate(3));
				product.setDis_date(rs.getDate(4));
				product.setQuantity(rs.getInt(5));
				product.setPrice(rs.getInt(6));

				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}

		return products;

	}

	// 상품 등록
	public void productAdd(JTextField[] fields) {
		conn = DatabaseConnect.getConnection();

		query = "insert into product (product_id, product_name, manu_date, dis_date, price) values (?, ? ,? ,?, ?)";

		try {
			ps = conn.prepareStatement(query);

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

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}

	}

	// 상품 수정
	public void productEdit(JTextField[] fields, String product_id) {
		conn = DatabaseConnect.getConnection();

		query = "UPDATE product SET product_name = ?, manu_date = ?, dis_date = ?, quantity = ?, price = ? WHERE product_id = ?";
		System.out.println(query);
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, fields[0].getText());
			ps.setString(2, fields[1].getText());
			ps.setString(3, fields[2].getText());
			ps.setString(4, fields[3].getText());
			ps.setString(5, fields[4].getText());
			ps.setString(6, product_id);

			int rsCnt = ps.executeUpdate();
			
			if(rsCnt > 0) {
				System.out.println("[DB] Complete\n");
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

	// 상품 삭제
	public void productDel(String pid) {
		conn = DatabaseConnect.getConnection();

		query = "UPDATE product SET save_status =\'N\' WHERE product_id = ? ";

		try {

			ps = conn.prepareStatement(query);
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
