package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Check_on_Time {

	public String mem_id;
	
	//중복버튼 누르지 않게하기위한 클래스
	public Check_on_Time(String mem_id) {
		
		String sql = "SELECT * FROM daily_check WHERE mem_no=? and TO_DATE(dc_date,'YYYY-MM-DD')=TO_DATE(sysdate,'YYYY-MM-DD')";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);

			pstmt.setString(1, mem_id);
		
			 
			if(!pstmt.executeQuery().next()) {
				new Add_Commute_On_Time(mem_id);
			
			}
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}