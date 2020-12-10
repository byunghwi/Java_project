package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

public class Add_Commute_On_Time {

	public Add_Commute_On_Time() {
	

	
	String sql = "INSERT INTO daily_check VALUES (sysdate,'test2',sysdate,default)";
	
	try {
		Connection conn = DatabaseConnect.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement(sql);
		
		DatabaseConnect.dbClose(null, pstmt, conn);
		
			
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}	
	

	
}
