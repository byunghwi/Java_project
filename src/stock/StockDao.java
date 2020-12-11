package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseConnect;
import product.Product;

public class StockDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;

	String query = null;
	
	Stock stock = null;
	
	public ArrayList<Stock> stockAll() {

		conn = DatabaseConnect.getConnection();
		// ��ǰ�� ���� ArrayList ����
		ArrayList<Stock> stocks = new ArrayList<Stock>();

		query = "SELECT product_id as \"��ǰ�ڵ�\", product_name as \"��ǰ��\", to_char(manu_date, 'YYYY-MM-dd') as \"������\" "
				+ ", to_char(dis_date, 'YYYY-MM-dd') as \"�����\", quantity as \"����\", price \"����\" "
				+ " FROM product WHERE save_status = \'Y\' ORDER BY product_id";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				stock = new Stock();

				stock.product_id(rs.getString(1));
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

		// DB��� ����
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] �ڿ� �ݳ� �� ���� �߻�\n");
			e.printStackTrace();
		}

		return products;

	}
	

}
