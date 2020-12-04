package Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DatabaseConnect;

public class OrderMain {
//
	public static void main(String[] args) {
		try {
			String product_list = "SELECT * FROM product";
			DatabaseConnect db = new DatabaseConnect(product_list);	
			ResultSet rs = db.getRs();
			
			System.out.println("물품목록");
			System.out.println("물품번호\t물품이름\t가격");
			while (rs.next()) {
				System.out.printf("%s\t%s\t%d\n",
						rs.getString("product_id"),
						rs.getString("product_name"),
						rs.getInt("price")
				);								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}