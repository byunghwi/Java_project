package sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import db.DatabaseConnect;
import product.Product;
import stock.Stock;

public class SaleDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;
 
	ResultSetMetaData rsmd = null;

	String query = null;
	String query2 = null;

	Product product = null;
	Stock stock = null;
	
	//판매 메서드
	public ArrayList<Stock> saleComp() {
		query = "SELECT product_id, product_name, sum(quantity), price FROM stock WHERE save_status = 'Y' GROUP BY product_id, product_name, price";
		conn = DatabaseConnect.getConnection();
		
		// 재고들 담을 ArrayList 생성
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				stock  = new Stock();

				stock.setProduct_id(rs.getString(1));
				stock.setProduct_name(rs.getString(2));
				stock.setPrice(Integer.parseInt(rs.getString(3)));
				stock.setQuantity(Integer.parseInt(rs.getString(4)));		
				
				stocks.add(stock);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		
		return stocks;
	}
	
	//원래 재고의 수량으로 화면 변경해주기
	public int originQt(String product_id) {
		
		query = "SELECT sum(quantity) FROM stock WHERE product_id = ? GROUP BY product_id";
		
		conn = DatabaseConnect.getConnection();
		
		int originQt = -1;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, product_id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				originQt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		
		return originQt;
	}
	
	//결제 메서드
	public Boolean pay(ArrayList<Stock> stocks) {
		//판매 테이블
		query = "insert into sales values (SALES_NO_SEQ.nextval, to_char(SYSDATE, 'yyyy-MM-dd'), SYSDATE, ?)";
		//판매 상세 테이블
		query2 = "insert into sales_detail values (SALE_DETAIL_NO_SEQ.NEXTVAL, SALES_NO_SEQ.currval, ?, ?, ?)";
		
		conn = DatabaseConnect.getConnection();
		int rs = 0;
		int rs2 = 0;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "TEST");
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("[DB] sale insert complete");
			}
		} catch (SQLException e) {
			System.out.println("[DB] sale insert error!");
			e.printStackTrace();
		}
		
		try {
			for(int i=0; i<stocks.size(); i++) {
				ps = conn.prepareStatement(query2);
				//ps.setInt(1, getSaleSeq());
				ps.setString(1, stocks.get(i).getProduct_id());
				ps.setInt(2, stocks.get(i).getQuantity());
				ps.setInt(3, stocks.get(i).getPrice());
				rs2 = ps.executeUpdate();
				if(rs2 > 0) {
					System.out.println("[DB] sale_detail insert (" + i + ") complete");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs > 0 && rs2 > 0)
			return true;
		else
			return false;
	}
	
	//판매 시퀀스 가져오기
	public int getSaleSeq() {
		query = "SELECT sales_no_seq.CURRVAL FROM DUAL ";
		conn = DatabaseConnect.getConnection();
		int seq = 0;
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				seq = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}
}
