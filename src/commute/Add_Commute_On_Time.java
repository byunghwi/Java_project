package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Add_Commute_On_Time {

	public Add_Commute_On_Time() {
	
	HikariDataSource ds = new HikariDataSource();
	ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
	ds.setUsername("puser");
	ds.setPassword("12341234");
	
	String sql = "INSERT INTO daily_check VALUES (sysdate,'test',sysdate,default)";
	
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
	

	
}
