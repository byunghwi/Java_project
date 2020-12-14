package account.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

// SaveStatus(��� ����)�� Ȯ���ϴ� Ŭ����
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
			
			// ��� ���θ� �ľ��Ͽ� ����ڰ� �ƴ϶�� �Ǻ��� ���� check�� true�� ����
			if(result.getString(1).equals("Y")) {
				check = true;
			} else {
				System.err.println("탈퇴한 회원입니다.");
			}
			
			DatabaseConnect.dbClose(result, pstmt, conn);
		
			// �߸��� ID ������ ���ε� �� Ŭ�������� �ľ�
		} catch (SQLException e) {
			System.err.println("잘못된 ID입니다");
		}
		
	}

}





