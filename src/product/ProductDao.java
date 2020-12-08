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
	
	String query = null;
	
	//Product 객체를 담을 ArrayList생성.
	
	public Vector<String>columnNames = new Vector<String>();
	
	Product product = null;
	
	//상품 전체 목록
	public ArrayList<Product> productAll(){
		
		conn = DatabaseConnect.getConnection();
		//상품들 담을 ArrayList 생성
		ArrayList<Product> products = new ArrayList<Product>();
		
		query = "SELECT product_id as \"상품코드\", product_name as \"상품명\", to_char(manu_date, 'YYYY-MM-dd') as \"제조일\" "
				+ ", to_char(dis_date, 'YYYY-MM-dd') as \"폐기일\", quantity as \"수량\", price \"가격\" "
				+ " FROM product WHERE save_status = \'Y\' ORDER BY product_id";
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
		
//		//테스트 확인용
//		for(int i =0; i<products.size(); i++) {
//			System.out.println(products.get(i).getProduct_id() + " " + products.get(i).getProduct_name() );
//		}
		
		return products;
	}
	
	//상품 등록
	public void productAdd(Product product) {
		conn = DatabaseConnect.getConnection();
		
		
		query = "insert into product (product_id, product_name, manu_date, dis_date, price) values (?, ? ,? ,?, ?)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, product.getProduct_id());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, product.getManu_date().toString());
			ps.setString(4, product.getDis_date().toString());
			ps.setInt(5, product.getPrice());

			int rsCnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void productDel() {
		
	}
	
}
