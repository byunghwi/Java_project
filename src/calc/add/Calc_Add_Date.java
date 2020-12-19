package calc.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseConnect;

public class Calc_Add_Date {

	public Calc_Add_Date() {
		
	
		String sql = "INSERT INTO calculate VALUES ("
				+ "sysdate,(SELECT COUNT(sales_no) AS 총판매건수 fROM sales "
				+ "WHERE TO_CHAR(sales_date, 'YYYY-MM-DD') =TO_CHAR(SYSDATE,'YYYY-MM-DD')),"
				+ "(SELECT SUM(product_price) AS 총판매금액 "
				+ "FROM sales_detail WHERE sales_no IN("
				+ "SELECT sales_no FROM sales WHERE TO_CHAR(sales_date,'YYYY-MM-DD') = TO_CHAR(SYSDATE,'YYYY-MM-DD'))),'test',sysdate)";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			pstmt.execute();
			
			DatabaseConnect.dbClose(null, pstmt, conn);
			
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
