package sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import db.DatabaseConnect;
import product.Product;
import stock.Stock;

public class SaleDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;
 
	ResultSetMetaData rsmd = null;

	String query = null;
	String query2 = null;

	Product product = null;
	Stock stock = null;
	
	//판매 메서드
	public ArrayList<Stock> saleComp() {
		query = "SELECT * FROM stock ORDER BY stock_no";
		conn = DatabaseConnect.getConnection();
		
		// 재고들 담을 ArrayList 생성
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				stock  = new Stock();

				stock.setStock_no(Integer.parseInt(rs.getString(1)));
				stock.setProduct_id(rs.getString(2));
				stock.setProduct_name(rs.getString(3));
				stock.setIn_date(rs.getString(4));
				stock.setManu_date(rs.getString(5));
				stock.setDis_date(rs.getString(6));
				stock.setPrice(Integer.parseInt(rs.getString(7)));
				stock.setQuantity(Integer.parseInt(rs.getString(8)));
				stock.setSave_status(rs.getString(9));
				
				stocks.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return stocks;
	}
}
