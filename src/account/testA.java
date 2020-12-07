package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class testA {
	
	public static void main(String[] args) {
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		String dat = "test";
		
		String sql = "UPDATE daily_check SET OFF_TIME = sysdate WHERE mem_no = ?";
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, dat);
			
			pstmt.execute();
			
			
			pstmt.close();
			conn.close();
			ds.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
