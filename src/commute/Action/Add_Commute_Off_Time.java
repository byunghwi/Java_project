package commute.Action;

import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

public class Add_Commute_Off_Time {

	public Add_Commute_Off_Time() {
	

	
	
	
	String sql = "UPDATE daily_check SET OFF_TIME = sysdate WHERE mem_no = 'test3'and TO_DATE(dc_date,'YYYY-MM-DD')=TO_DATE(sysdate,'YYYY-MM-DD')";

	
	
	try {
		Connection conn = DatabaseConnect.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement(sql);
		
		pstmt.execute();
		
		DatabaseConnect.dbClose(null, pstmt, conn);
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}
	

	
}
