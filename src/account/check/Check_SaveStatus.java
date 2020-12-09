package account.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

// SaveStatus(퇴사 여부)를 확인하는 클래스
public class Check_SaveStatus {
	
	String mem_id;
	String mem_pwd;
	public boolean check = false;

	public Check_SaveStatus(String mem_id, String mem_pwd) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		
		String sql = "SELECT save_status FROM member WHERE mem_id = ?";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			ResultSet result = pstmt.executeQuery();
			
			result.next();
			
			// 퇴사 여부를 파악하여 퇴사자가 아니라면 판별용 변수 check를 true로 변경
			if(result.getString(1).equals("Y")) {
				check = true;
			} else {
				System.err.println("탈퇴한 회원 ID입니다.");
			}
			
			DatabaseConnect.dbClose(result, pstmt, conn);
		
			// 잘못된 ID 인지의 여부도 이 클래스에서 파악
		} catch (SQLException e) {
			System.err.println("잘못된 ID 정보 입니다.");
		}
		
	}

}





