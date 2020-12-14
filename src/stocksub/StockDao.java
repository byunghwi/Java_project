package stocksub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.DatabaseConnect;


// 재고와 폐기 전반에 관련된 모든 데이터 입출력을 모아놓은 클래스
public class StockDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;

	String query1 = null;
	String query2 = null;
	String query3 = null;
	String query4 = null;
	String query5 = null;
	String query5_sub = null;
	
	Stock stock = null;
	Stock_info stock_info = null;
	Disposal disposal = null;
	
	
	public ArrayList<Stock> stockAll() {

		conn = DatabaseConnect.getConnection();

		ArrayList<Stock> stocks = new ArrayList<Stock>();

		query1 = "SELECT product_id AS 상품코드 ,product_name AS 상품명,sum(quantity) AS 수량, price AS 가격 FROM stock WHERE save_status = 'Y' GROUP BY product_id, product_name, price";
		try {
			pstmt = conn.prepareStatement(query1);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				stock = new Stock();
				
				stock.setProduct_id(rs.getString(1));
				stock.setProduct_name(rs.getString(2));
				stock.setQuantity(rs.getInt(3));
				stock.setPrice(rs.getInt(4));
				
				stocks.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			DatabaseConnect.dbClose(rs, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}

		return stocks;

	}
	
	public ArrayList<Stock_info> stockInfos(String product_id) {
		conn = DatabaseConnect.getConnection();
		
		ArrayList<Stock_info> stock_infos = new ArrayList<Stock_info>();
		
		query2 = "SELECT product_id AS 상품코드,product_name AS 상품명, quantity AS 수량,manu_date AS 제조일, dis_date AS 폐기일 FROM stock where product_id = ? AND save_status = 'Y'";
		try {
			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, product_id);
			
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				stock_info = new Stock_info();
				
				stock_info.setProduct_id(rs.getString(1));
				stock_info.setProduct_name(rs.getString(2));
				stock_info.setQuantity(rs.getInt(3));
				stock_info.setManu_date(rs.getDate(4));
				stock_info.setDis_date(rs.getDate(5));
				
				stock_infos.add(stock_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			DatabaseConnect.dbClose(rs, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}

		return stock_infos;
		
	}
	public void disposal_product(String product_id, String dis_date) {
		
		conn = DatabaseConnect.getConnection();
		query3 = "UPDATE stock SET quantity = 0, save_status = 'N' WHERE product_id = ? AND TO_CHAR(dis_date,'YYYY-MM-DD') = ?";
		try {
			pstmt = conn.prepareStatement(query3);
			pstmt.setString(1, product_id);
			pstmt.setString(2, dis_date);
			
			pstmt.executeQuery();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			DatabaseConnect.dbClose(null, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
	}
	
	public void send_disposal_table(String product_id, String manu_date, String dis_date,String quantity) {
		conn = DatabaseConnect.getConnection();
		query4 = "INSERT INTO dis_product VALUES(DIS_PD_NO_SEQ.nextval, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?,'admin',sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query4);
			pstmt.setString(1, product_id);
			pstmt.setString(2,manu_date);
			pstmt.setString(3, dis_date);
			pstmt.setInt(4, Integer.parseInt(quantity));
			
			pstmt.executeQuery();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			DatabaseConnect.dbClose(null, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Disposal> disposals(String save_time){
		
		ArrayList<Disposal> disposals = new ArrayList<Disposal>();
		
		conn = DatabaseConnect.getConnection();
		query5 = "select * from dis_product WHERE TO_DATE(save_time) = TO_DATE(sysdate,'YY-MM-DD')";
		query5_sub = "select * from dis_product WHERE TO_DATE(save_time) = TO_DATE(? ,'YYYY-MM-DD')";
		try {
			
			if (save_time.equals("default"))
				pstmt = conn.prepareStatement(query5);
			else {
				pstmt = conn.prepareStatement(query5_sub);
				pstmt.setString(1, save_time);
		
			}
			
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			
			
			int columCnt = rsmd.getColumnCount();
			
			while (rs.next()) {
				disposal = new Disposal();
				
				disposal.setDisposalcode(rs.getString(1));
				disposal.setProduct_id(rs.getString(2));
				disposal.setManu_date(rs.getDate(3));
				disposal.setDis_date(rs.getDate(4));
				disposal.setQuantity(rs.getInt(5));
				disposal.setMem_id(rs.getString(6));
				disposal.setSave_time(rs.getDate(7));
				
				disposals.add(disposal);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DatabaseConnect.dbClose(rs, pstmt, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		return disposals;
	}
	

}
