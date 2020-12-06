package Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ProductList {

	public static void main(String[] args) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		try {
			Connection conn = ds.getConnection();
			String sql = "SELECT * FROM product";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
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