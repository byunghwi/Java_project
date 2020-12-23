package calc;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import db.DatabaseConnect;

public class CalcDao {
	
	static String start_date;
	static String end_date;
	
	public CalcDao(String start_date,String end_date) {
		
		this.start_date=start_date;
		this.end_date=end_date;
		
	}
	
	public static ArrayList<Calc> calclist(){
		
		ArrayList<Calc> calcs = new ArrayList<Calc>();
		
		String sql = "SELECT sale_date,total_sale_quantity,total_sale_price,worker_no,TO_CHAR(save_time, 'YYYY/MM/DD')as save_time FROM calculate WHERE sale_date between to_date(?,'YYYY-MM-dd') and to_date(?,'YYYY-MM-dd') ORDER BY sale_date";
		
		try {
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);
			
			
			pstmt.setString(1,start_date);
			pstmt.setString(2,end_date);
			
			
			ResultSet rs = pstmt.executeQuery();	

			//쿼리문에 해당하는 값 ArrayList에 값 저장
			while(rs.next()) {
				Calc calc = new Calc(rs.getString("sale_date"),rs.getInt("total_sale_quantity"),rs.getInt("total_sale_price"),rs.getString("worker_no"),rs.getString("save_time"));	
				calcs.add(calc);	
			}
			
			DatabaseConnect.dbClose(rs, pstmt, conn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		 }
		
		return calcs;
		
	}

}
