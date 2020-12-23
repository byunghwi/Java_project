package account.findAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Read_Account_NAP {
	public String[] read_info = null;
	public boolean check = false;
	
	
	public Read_Account_NAP(String name, String phone_n) {
		
		String sql = "SELECT * FROM member WHERE mem_nm = ? AND phone = ? AND save_status = 'Y'";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone_n);
			ResultSet result = pstmt.executeQuery();
			ResultSetMetaData result_md = result.getMetaData();
			int col = result_md.getColumnCount();
			
			read_info = new String[col];
			
			if (result.next()){
				for(int i = 0; i<read_info.length; i++) {
					read_info[i] = result.getString(i+1);
					
				}
			}
			
			
			if (read_info[0] != null) {
				check = true;
			}
			
			DatabaseConnect.dbClose(result, pstmt, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Read_Account_NAP(String id, String name, String phone_n) {
		
		String sql = "SELECT * FROM member WHERE mem_nm = ? AND phone = ? AND save_status = 'Y' AND mem_id = ?";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone_n);
			pstmt.setString(3, id);
			ResultSet result = pstmt.executeQuery();
			ResultSetMetaData result_md = result.getMetaData();
			int col = result_md.getColumnCount();
			
			read_info = new String[col];
			
			if (result.next()){
				for(int i = 0; i<read_info.length; i++) {
					read_info[i] = result.getString(i+1);
					
				}
			}
			
			if (read_info[0] != null) {
				check = true;
			}
			
			DatabaseConnect.dbClose(result, pstmt, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reset_pw(String mem_id) {
		
		String sql = "UPDATE member SET mem_pwd = ? WHERE mem_id = ?";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_id);
			ResultSet result = pstmt.executeQuery();

			
			
			DatabaseConnect.dbClose(result, pstmt, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

