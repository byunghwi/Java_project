package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnect {
	String query;
	static HikariConfig config;
	static HikariDataSource ds;
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	static {
		config  = new HikariConfig("jdbc/hikari.properties");
		ds = new HikariDataSource(config);
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public DatabaseConnect(String query) {
		this.query = query;

		try {
			pstmt = conn.prepareStatement(this.query);		
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.err.println("연결에 실패했습니다.");
			e.printStackTrace();
		}
	}

	public ResultSet getRs() {
		return rs;
	}

	
}
