package product;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DatabaseConnect;

public class ProductMain {
	public static void main(String[] args) throws SQLException{
		String query = "SELECT * FROM PRODUCT";
		
		DatabaseConnect db = new DatabaseConnect(query);	
		ResultSet rs = db.getRs();

		System.out.println("상품코드\t상품명\t제조일\t폐기일\t수량\t가격\n");
		while (rs.next()) {
			
			System.out.printf("%-8s\t%-8s\t%-10s\t%-10s\t%-10d\t%-10d\n",
			rs.getString("PRODUCT_ID"),
			rs.getString("PRODUCT_NAME"),
			rs.getString("MANU_DATE"),
			rs.getString("DIS_DATE"),
			rs.getInt("QUANTITY"),
			rs.getInt("PRICE"));
		}
				
		}
	}
		

