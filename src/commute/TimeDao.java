package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DatabaseConnect;

public class TimeDao {

	public TimeDao() {
		
	}
	
public static ArrayList<Commute> commute_Time(){
		
		ArrayList<Commute> commutes = new ArrayList<Commute>();
		
		String sql = "SELECT TO_CHAR(dc_date, 'YYYY/MM/DD')as dc_date,mem_no,TO_CHAR(on_time,'HH24:Mi:ss')as on_time,TO_CHAR(off_time,'HH24:Mi:ss')as off_time FROM daily_check ORDER BY dc_date DESC";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();	

			
			//쿼리문에 해당하는 값 ArrayList에 값 저장
			while(rs.next()) {
				Commute commute = new Commute(rs.getString("dc_date"),rs.getString("mem_no"),rs.getString("on_time"),rs.getString("off_time"));	
				commutes.add(commute);	
			}
			
			DatabaseConnect.dbClose(rs, pstmt, conn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		 }
		return commutes;
	
	   }
	
}