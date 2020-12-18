package account.delAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;

import account.check.Check_SaveStatus;
import db.DatabaseConnect;

// 입력된 ID에 대응하는 올바른 PW인지 확인하는 클래스
public class Check_PW {
	
	String mem_id;
	String mem_pwd;
	public boolean check = false;
	Check_SaveStatus c_ss = null;

	public Check_PW(String mem_id, String mem_pwd) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		
		// 먼저 SaveStatus 매서드를 통해 존재하는 계정인지를 확인한다
		c_ss = new Check_SaveStatus(mem_id,mem_pwd);
		
		// 계정이 존재하며 탈퇴한 상태가 아니라면 계정에 대한 PW를 확인한다
		if(c_ss.check) {
			
			
			String sql = "SELECT mem_pwd FROM member WHERE mem_id = ?";
			
			try {
				Connection conn = DatabaseConnect.getConnection();
				
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, mem_id);
				ResultSet result = pstmt.executeQuery();
				
				result.next();
				
				if(result.getString(1).equals(mem_pwd)) {
					// 올바른 정보라면 true를 반환하여 이후 작업이 정상 작동하도록 한다
					check = true;
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 PW 입니다!");
					System.err.println("잘못된 PW 입니다!");
				}
				
				
				DatabaseConnect.dbClose(result, pstmt, conn);
				
				
			} catch (SQLException e) {
				
			}
		
		}
		
		
	}

}






