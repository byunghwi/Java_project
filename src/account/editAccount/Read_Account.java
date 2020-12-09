package account.editAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import db.DatabaseConnect;

public class Read_Account {
	public String[] read_info = null;
	
	
	public Read_Account(String mem_id) {
		
		String sql = "SELECT * FROM member WHERE mem_id = ?";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			ResultSet result = pstmt.executeQuery();
			ResultSetMetaData result_md = result.getMetaData();
			int col = result_md.getColumnCount();
			read_info = new String[col];
			
			result.next();
			for(int i = 0; i<read_info.length; i++) {
				read_info[i] = result.getString(i+1);
			}
			
			
			DatabaseConnect.dbClose(result, pstmt, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
