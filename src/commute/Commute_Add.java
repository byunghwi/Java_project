package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Commute_Add {

	public Commute_Add() {
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "INSERT INTO daily_check VALUES (sysdate-13,'test3',sysdate,default)";
		
		try {
			Connection conn=ds.getConnection();
			
			PreparedStatement pstmt=
					conn.prepareStatement(sql);
			
			
			
			
			
			
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new Commute_Add();
		
	}
	
}
