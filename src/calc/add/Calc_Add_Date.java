package calc.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Calc_Add_Date {

	public String mem_id;
	
	public Calc_Add_Date(String mem_id) {
		
	
		String sql = "INSERT INTO calculate VALUES ("
				+ "sysdate,(SELECT COUNT(sales_no) AS 총판매건수 fROM sales "
				+ "WHERE TO_CHAR(sales_date, 'YYYY-MM-DD') =TO_CHAR(SYSDATE,'YYYY-MM-DD')),"
				+ "(SELECT SUM(product_price) AS 총판매금액 "
				+ "FROM sales_detail WHERE sales_no IN("
				+ "SELECT sales_no FROM sales WHERE TO_CHAR(sales_date,'YYYY-MM-DD') = TO_CHAR(SYSDATE,'YYYY-MM-DD'))),?,sysdate)";
		String sql2 = "INSERT INTO calculate VALUES (sysdate,0,0,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DatabaseConnect.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, mem_id);
			pstmt.execute();
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
				
			
		} catch (SQLException e) {
			try {
				DatabaseConnect.dbClose(null, pstmt, conn);
				conn = DatabaseConnect.getConnection();
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, mem_id);
				pstmt.execute();
				
				DatabaseConnect.dbClose(null, pstmt, conn);
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
	}

	
	
	
}
