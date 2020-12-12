package stocksub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseConnect;

public class StockDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;

	String query1 = null;
	String query2 = null;
	String query3 = null;
	
	Stock stock = null;
	Stock_info stock_info = null;
	
	
	public ArrayList<Stock> stockAll() {

		conn = DatabaseConnect.getConnection();
		// ��ǰ�� ���� ArrayList ����
		ArrayList<Stock> stocks = new ArrayList<Stock>();

		query1 = "SELECT product_id AS ��ǰ�ڵ� ,product_name AS ��ǰ��,sum(quantity) AS ����, price AS ���� FROM stock GROUP BY product_id, product_name,price";
		try {
			pstmt = conn.prepareStatement(query1);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				stock = new Stock();
				
				stock.setProduct_id(rs.getString(1));
				stock.setProduct_name(rs.getString(2));
				stock.setQuantity(rs.getInt(3));
				stock.setPrice(rs.getInt(4));
				
				stocks.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DB��� ����
		try {
			DatabaseConnect.dbClose(rs, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] �ڿ� �ݳ� �� ���� �߻�\n");
			e.printStackTrace();
		}

		return stocks;

	}
	
	public ArrayList<Stock_info> stockInfos(String product_id) {
		conn = DatabaseConnect.getConnection();
		
		ArrayList<Stock_info> stock_infos = new ArrayList<Stock_info>();
		
		query2 = "SELECT product_id AS ��ǰ�ڵ� ,product_name AS ��ǰ��, quantity AS ����,manu_date AS ������, dis_date AS ����� FROM stock where product_id = ? AND save_status = 'Y'";
		try {
			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, product_id);
			
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				stock_info = new Stock_info();
				
				stock_info.setProduct_id(rs.getString(1));
				stock_info.setProduct_name(rs.getString(2));
				stock_info.setQuantity(rs.getInt(3));
				stock_info.setManu_date(rs.getDate(4));
				stock_info.setDis_date(rs.getDate(5));
				
				stock_infos.add(stock_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DB��� ����
		try {
			DatabaseConnect.dbClose(rs, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] �ڿ� �ݳ� �� ���� �߻�\n");
			e.printStackTrace();
		}

		return stock_infos;
		
	}
	public void Disposal_product(String product_id, String dis_date) {
		
		conn = DatabaseConnect.getConnection();
		query3 = "UPDATE stock SET quantity = 0, save_status = 'N' WHERE product_id = ? AND TO_CHAR(dis_date,'YYYY-MM-DD') = ?";
		try {
			pstmt = conn.prepareStatement(query3);
			pstmt.setString(1, product_id);
			pstmt.setString(2, dis_date);
			
			pstmt.executeQuery();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DB��� ����
		try {
			DatabaseConnect.dbClose(null, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] �ڿ� �ݳ� �� ���� �߻�\n");
			e.printStackTrace();
		}
		
		
	}
	

}
