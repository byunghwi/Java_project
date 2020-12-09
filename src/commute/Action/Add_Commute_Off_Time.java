package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Add_Commute_Off_Time {

	public Add_Commute_Off_Time() {
	
	HikariDataSource ds = new HikariDataSource();
	ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
	ds.setUsername("puser");
	ds.setPassword("12341234");
	
	
	
	String sql = "UPDATE daily_check SET OFF_TIME = sysdate WHERE mem_no = 'test3'";
	
	
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
