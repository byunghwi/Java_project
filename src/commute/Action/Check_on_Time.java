package commute.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Check_on_Time {

	
	//중복버튼 누르지 않게하기위한 클래스
	public Check_on_Time() {
		
		String sql = "SELECT * FROM daily_check WHERE mem_no='test3' and TO_DATE(dc_date,'YYYY-MM-DD')=TO_DATE(sysdate,'YYYY-MM-DD')";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);

		
			 
			if(!pstmt.executeQuery().next()) {
				new Add_Commute_On_Time();//insert
			}else {
				//delete 
			}
			
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}