package account.editAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Edit_Account {
	// Member new_mem = new Member("mem_issd", "mem_pw", "mem_nm", "res_no", "phone", "address", 's', "mail");
	String [] edit_data = new String[8];
	public boolean edit_suc = false;
	
	public Edit_Account(String[] edit_data) {
		
		this.edit_data = edit_data;
		
		String sql = "UPDATE member\r\n"
				+ "SET\r\n"
				+ "    mem_pwd = ?,\r\n"
				+ "    mem_nm = ?,\r\n"
				+ "    res_no = ?,\r\n"
				+ "    phone = ?,\r\n"
				+ "    address = ?,\r\n"
				+ "    sex = ?,\r\n"
				+ "    mail = ?\r\n"
				+ "WHERE\r\n"
				+ "    mem_id = ?";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseConnect.getConnection();
			
			pstmt = 
					conn.prepareStatement(sql);
			
			for (int i = 1; i <= edit_data.length; i++) {
				pstmt.setString(i, edit_data[i-1]);
			}
			
			pstmt.execute();
			
			System.out.println("수정 성공!!");
			edit_suc = true;
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				DatabaseConnect.dbClose(null, pstmt, conn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}	
		
}
			