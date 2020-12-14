package account.addAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import account.*;

import com.zaxxer.hikari.HikariDataSource;

import account.Member;
import db.DatabaseConnect;

// 실제로 DB에 회원정보를 전송하는 클래스
public class Add_Account{
	
	String errorCode;
	String[] errorNames = new String[7];
	String[] messages = new String[7];
	
	public Add_Account(Member new_mem) {
		// Member new_mem = new Member("mem_issd", "mem_pw", "mem_nm", "res_no", "phone", "address", 's', "mail");
		// 제약조건을 바탕으로 유효성 검사를 진행
		String[] errorNames = {"ID","PW","_NM","res","phone","SEX","MAIL"};
		String[] messages = {
				"아이디를 확인해주세요!!","패스워드를 확인해주세요!","이름을 확인해주세요!","주민등록번호를 확인해주세요!",
				"전화번호를 확인해주세요!","성별을 확인해주세요!","메일 주소를 확인해주세요!"};
		
		String sql = "INSERT INTO member VALUES (mem_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, default,default)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DatabaseConnect.getConnection();
			
			pstmt = 
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
			
			System.out.println("가입 완료!");
			
		} catch (SQLException e) {
			errorCode = e.getMessage();
			System.out.println(errorCode);
			
			int cnt = 0;
			for (String errorname : errorNames ) {
				if (errorCode.contains(errorname)) {
					JOptionPane.showMessageDialog(null, messages[cnt]);
				}
				cnt++;
			}
			cnt = 0;
			
		} finally {
			try {
				DatabaseConnect.dbClose(null, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
		
}
