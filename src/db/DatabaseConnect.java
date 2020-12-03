package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnect {
	String query;
	static HikariConfig config;
	static HikariDataSource ds;
	static Connection conn;
	static PreparedStatement pstmt;
	
	static {
		config  = new HikariConfig("jdbc/hikari.properties");
		ds = new HikariDataSource(config);
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public DatabaseConnect(String query) {
		this.query = query;

		try {

			PreparedStatement pstmt = conn.prepareStatement(this.query);

			// 3-2. 준비된 구문을 실행한다. 쿼리가 SELECT문인 경우 결과를 Set으로 받아온다.
			ResultSet rs = pstmt.executeQuery();

//			System.out.println("상품코드\t상품명\t제조일\t폐기일\t수량\t가격\n");
//			while (rs.next()) {
//
//				System.out.printf("%-15s\t%-10s\t%-10s\t%-10s\t%-10d\t%-10d\n",
//						rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getDate("MANU_DATE"),
//						rs.getDate("DIS_DATE"), rs.getInt("QUANTITY"), rs.getInt("PRICE"));
//
//			}
//
//			rs.close();
//			pstmt.close();
//			ds.close();
//			conn.close();

		} catch (SQLException e) {
			System.err.println("연결에 실패했습니다.");
			e.printStackTrace();
		}
	}
}
