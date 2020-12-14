package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Check_on_Time {

	public Check_on_Time() {
		
		String sql = "SELECT * FROM daily_check WHERE mem_no='test3' and TO_DATE(dc_date,'YYYY-MM-DD')=TO_DATE(sysdate,'YYYY-MM-DD')";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);

		
			 
			if(!pstmt.executeQuery().next()) {
				new Add_Commute_On_Time();
			}
			
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}