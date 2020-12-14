package account.delAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

// 데이터 베이스에 실제 회원탈퇴를 반영하는 클래스
public class Del_Account {
	
	public Del_Account(String mem_id) {
		
		String sql = "UPDATE member SET save_status = 'N' WHERE mem_id = ?";
		
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
