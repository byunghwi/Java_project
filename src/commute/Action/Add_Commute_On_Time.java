package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

public class Add_Commute_On_Time {

	public String mem_id;
	
	public Add_Commute_On_Time(String mem_id) {
	

	
	String sql = "INSERT INTO daily_check VALUES (sysdate,?,sysdate,default)";
	
	try {
		Connection conn = DatabaseConnect.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement(sql);
		
		pstmt.setString(1, mem_id);
		
		pstmt.execute();
		
		DatabaseConnect.dbClose(null, pstmt, conn);
		
			
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}	
	

	
}
