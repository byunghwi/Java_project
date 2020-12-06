package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnect {
	//DB연결
	public static Connection getConnection() {
		Connection conn = null;
		HikariConfig config  = new HikariConfig("jdbc/hikari.properties");
		DataSource ds = new HikariDataSource(config);
		
		try {
			conn = ds.getConnection();
			System.out.println("[DB 연결 성공]\n");
		} catch (SQLException e) {
			System.out.println("[DB 연결 실패]\n" + e.toString());
		}
		
		return conn;	
	}
	
	//DB연결해제
	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
		System.out.println("[DB 자원 반납, DB 연결 해제]\n");
		
	}	
}
