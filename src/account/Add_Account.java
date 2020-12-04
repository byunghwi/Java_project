package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.zaxxer.hikari.HikariDataSource;

public class Add_Account {
	
	
	public Add_Account() {
		Member new_mem = new Member("mem_issd", "mem_pw", "mem_nm", "res_no", "phone", "address", 's', "mail");
		
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "INSERT INTO member VALUES (mem_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
		
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, new_mem.mem_id);
			pstmt.setString(2, new_mem.mem_pwd); 
			pstmt.setString(3, new_mem.mem_nm);
			pstmt.setString(4, new_mem.premit_id);
			pstmt.setString(5, new_mem.res_no);
			pstmt.setString(6, new_mem.phone);
			pstmt.setString(7, new_mem.address);
			pstmt.setString(8, Character.toString(new_mem.sex));
			pstmt.setString(9, new_mem.mail);
			pstmt.setString(9, new_mem.mail);
			
			pstmt.execute();
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
		
}
