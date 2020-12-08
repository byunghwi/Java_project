package account.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Check_SaveStatus {
	
	String mem_id;
	String mem_pwd;
	public boolean check = false;

	public Check_SaveStatus(String mem_id, String mem_pwd) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "SELECT save_status FROM member WHERE mem_id = ?";
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			ResultSet result = pstmt.executeQuery();
			
			result.next();
			
			if(result.getString(1).equals("Y")) {
				check = true;
			} else {
				System.err.println("Å»ÅðÇÑ È¸¿ø IDÀÔ´Ï´Ù.");
			}
			
			
			
			result.close();
			pstmt.close();
			conn.close();
			ds.close();
			
		} catch (SQLException e) {
			System.err.println("");
		}
		
	}

}





