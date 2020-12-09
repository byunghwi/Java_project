package account.delAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import account.check.Check_SaveStatus;
import db.DatabaseConnect;

// 입력받은 ID에 대한 PW가 맞는지 확인하는 클래스
public class Check_PW {
	
	String mem_id;
	String mem_pwd;
	public boolean check = false;
	Check_SaveStatus c_ss = null;

	public Check_PW(String mem_id, String mem_pwd) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		
		// 먼저 퇴사자의 정보인지 확인
		c_ss = new Check_SaveStatus(mem_id,mem_pwd);
		
		// 퇴사자도 아니고 ID의 정보도 존재한다면 이하의 조건문 실행
		if(c_ss.check) {
			
			
			String sql = "SELECT mem_pwd FROM member WHERE mem_id = ?";
			
			try {
				Connection conn = DatabaseConnect.getConnection();
				
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, mem_id);
				ResultSet result = pstmt.executeQuery();
				
				result.next();
				
				// ID에 대한 PW가 맞다면 check를 true로 변경
				if(result.getString(1).equals(mem_pwd)) {
					check = true;
				} else {
					System.err.println("잘못된 PW 정보 입니다.");
				}
				
				
				DatabaseConnect.dbClose(result, pstmt, conn);
				
				
			} catch (SQLException e) {
				
			}
		
		}
		
		
	}

}






