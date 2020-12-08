package account.delAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

// 실제로 회원 탈퇴를 DB에 반영하는 클래스
// 탈퇴자는 실제로 DB에서 정보가 삭제되는것이 아닌 save_status만 변화된다(정보는 남아있음)
public class Del_Account {
	
	public Del_Account(String mem_id) {
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "UPDATE member SET save_status = 'N' WHERE mem_id = ?";
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			
			pstmt.execute();
			
			
			pstmt.close();
			conn.close();
			ds.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
