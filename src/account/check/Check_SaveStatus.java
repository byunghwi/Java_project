package account.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

// 회원의 존재 여부와 SaveStatus(탈퇴 여부 판별)를 확인하는 클래스
// 회원 정보를 확인하는 모든 과정에서 실행
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
			
			// 회원정보가 존재하고 Savestatus가 Y라면 check를 true로 반환하여 이후의 작업이 정상 진행되도록 한다
			if(result.getString(1).equals("Y")) {
				check = true;
			// 회원정보가 존재하지만 Savestatus가 N이라면 이후의 작업은 정상 작동하지 않는다
			} else {
				System.err.println("탈퇴한 회원입니다.");
			}
			
			DatabaseConnect.dbClose(result, pstmt, conn);
		
		// 아예 회원정보가 없는 경우 아이디가 잘못되었음을 알린다
		} catch (SQLException e) {
			System.err.println("잘못된 ID입니다");
		}
		
	}

}





