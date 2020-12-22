package calc.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import commute.Action.Add_Commute_On_Time;
import db.DatabaseConnect;

public class check_Calc {

	public String mem_id;
	
	public check_Calc(String mem_id) {
		
		String sql  = "SELECT * FROM calculate WHERE worker_no=? and TO_DATE(sale_date,'YYYY-MM-DD')=TO_DATE(sysdate,'YYYY-MM-DD')";
		
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			

			pstmt.setString(1, mem_id);
		
			
			
			if(!pstmt.executeQuery().next()) {
				new Calc_Add_Date(mem_id);
				JOptionPane.showMessageDialog(null, "[SYSTEM] 정산처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "[SYSTEM] 이미정산처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			}
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
