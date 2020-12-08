package account.delAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import account.check.Check_SaveStatus;

public class Check_PW {
	
	String mem_id;
	String mem_pwd;
	public boolean check = false;
	Check_SaveStatus c_ss = null;

	public Check_PW(String mem_id, String mem_pwd) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		
		c_ss = new Check_SaveStatus(mem_id,mem_pwd);
		
		if(c_ss.check) {
			HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
			ds.setUsername("puser");
			ds.setPassword("12341234");
			
			String sql = "SELECT mem_pwd FROM member WHERE mem_id = ?";
			
			try {
				Connection conn = ds.getConnection();
				
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, mem_id);
				ResultSet result = pstmt.executeQuery();
				
				result.next();
				
				if(result.getString(1).equals(mem_pwd)) {
					check = true;
				} else {
					System.err.println("잘못된 PW 정보 입니다.");
				}
				
				
				
				result.close();
				pstmt.close();
				conn.close();
				ds.close();
				
			} catch (SQLException e) {
				
			}
		
		}
		else {
			System.err.println("잘못된 ID 정보 입니다.");
		}
		
	}

}






