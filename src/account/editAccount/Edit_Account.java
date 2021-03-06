package account.editAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import db.DatabaseConnect;

// 실제 DB에 수정된 회원 정보를 업데이트 하는 클래스
public class Edit_Account {
	// Member new_mem = new Member("mem_issd", "mem_pw", "mem_nm", "res_no", "phone", "address", 's', "mail");
	String [] edit_data = new String[8];
	public boolean edit_suc = false;
	
	String errorCode;
	String[] errorNames = new String[7];
	String[] messages = new String[7];
	
	public Edit_Account(String[] edit_data) {
		
		String[] errorNames = {"ID","PW","_NM","res","phone","SEX","MAIL"};
		String[] messages = {
				"아이디를 확인해주세요!!","패스워드를 확인해주세요!","이름을 확인해주세요!","주민등록번호를 확인해주세요!",
				"전화번호를 확인해주세요!","성별을 확인해주세요!","메일 주소를 확인해주세요!"};
		
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
			errorCode = e.getMessage().toLowerCase();
			System.out.println(errorCode);
			
			int cnt = 0;
			for (String errorname : errorNames ) {
				if (errorCode.contains(errorname.toLowerCase())) {
					JOptionPane.showMessageDialog(null, messages[cnt]);
				}
				cnt++;
			}
			cnt = 0;
			try {
				DatabaseConnect.dbClose(null, pstmt, conn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}	
		
}
			