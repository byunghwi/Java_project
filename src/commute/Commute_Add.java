package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import db.DatabaseConnect;

public class Commute_Add {

	public Commute_Add() {
		
		
		
		String sql = "INSERT INTO daily_check VALUES (sysdate-13,'test3',sysdate,default)";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
	
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new Commute_Add();
		
	}
	
}
