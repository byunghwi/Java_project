package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import db.DatabaseConnect;

public class ProductDao {
	Connection conn =null;
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
	ResultSetMetaData rsmd = null;
	
	//Product 객체를 담을 ArrayList생성.
	public ArrayList<Product> products = new ArrayList<Product>();
	public Vector<String>columnNames = new Vector<String>();
	
	Product product = null;
	
	public ProductDao(){
		
		conn = DatabaseConnect.getConnection();
		
		String query = "SELECT product_id as \"상품코드\", product_name as \"상품명\", to_char(manu_date, 'YYYY-MM-dd') as \"제조일\" "
				+ ", to_char(dis_date, 'YYYY-MM-dd') as \"폐기일\", quantity as \"수량\", price \"가격\" "
				+ " FROM product ORDER BY product_id";
		//System.out.println("쿼리 > " + query);
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			
			int columCnt = rsmd.getColumnCount();
			
			//컬럼네임 ArrayList 세팅
			for (int i = 0; i < columCnt; i++) {
				columnNames.add(i, rsmd.getColumnName(i+1));
				//System.out.printf("[컬럼네임 세팅] %d번째 ->  %s\n", i, rsmd.getColumnName(i+1));
			}
			
			
			while(rs.next()) {
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
		
	}
	
}
