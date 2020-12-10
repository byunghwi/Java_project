package account.addAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import account.*;

import com.zaxxer.hikari.HikariDataSource;

import account.Member;
import db.DatabaseConnect;

// 실제로 DB에 데이터를 보내는 클래스
public class Add_Account {
	
	
	public Add_Account(Member new_mem) {
		// Member new_mem = new Member("mem_issd", "mem_pw", "mem_nm", "res_no", "phone", "address", 's', "mail");
		
		
		String sql = "INSERT INTO member VALUES (mem_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, default,default)";
		
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, new_mem.mem_id);
			pstmt.setString(2, new_mem.mem_pwd); 
			pstmt.setString(3, new_mem.mem_nm);
			pstmt.setString(4, new_mem.premit_id);
			pstmt.setString(5, new_mem.res_no);
			pstmt.setString(6, new_mem.phone);
			pstmt.setString(7, new_mem.address);
			pstmt.setString(8, new_mem.sex);
			pstmt.setString(9, new_mem.mail);
			
			pstmt.execute();
			
			System.out.println("계정 생성 완료");
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}	
		
}
