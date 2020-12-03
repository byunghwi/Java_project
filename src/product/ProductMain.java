package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ProductMain {
	public static void main(String[] args) {

		HikariConfig config = new HikariConfig("src/jdbc/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);

		try {
			
			Connection conn = ds.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product " + "order by department_id");

			// 3-2. 준비된 구문을 실행한다. 쿼리가 SELECT문인 경우 결과를 Set으로 받아온다.
			ResultSet rs = pstmt.executeQuery();

			System.out.println("product_id\tproduct_name\tmanu_date\tdis_date\tquantity\tprice\n");
			while (rs.next()) {

				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\t%-10d\n", rs.getString("last_name"),
						rs.getString("first_name"), rs.getInt("manager_id"), rs.getInt("salary"),
						rs.getInt("department_id"));

			}

			rs.close();
			pstmt.close();
			ds.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
