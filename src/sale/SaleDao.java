package sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import db.DatabaseConnect;
import product.Product;
import stock.Stock;

public class SaleDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;
 
	ResultSetMetaData rsmd = null;



	Product product = null;
	Stock stock = null;
	
	//판매 메서드
	public ArrayList<Stock> saleComp() {
		String query = "SELECT product_id, product_name, sum(quantity), price FROM stock WHERE save_status = 'Y' GROUP BY product_id, product_name, price";
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
		
		String query = "SELECT sum(quantity) FROM stock WHERE product_id = ? GROUP BY product_id";
		
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
	
	//결제시 판매, 판매상세 테이블 인서트
	public Boolean pay(ArrayList<Stock> stocks) {
		//판매 테이블
		String query = "insert into sales values (SALES_NO_SEQ.nextval, to_char(SYSDATE, 'yyyy-MM-dd'), SYSDATE, ?)";
		
		//판매 상세 테이블
		String query2 = "insert into sales_detail values (SALE_DETAIL_NO_SEQ.NEXTVAL, SALES_NO_SEQ.currval, ?, ?, ?)";		
		
		//판매 테이블 시퀀스 조회
		String query3 = "SELECT SALES_NO_SEQ.currval FROM dual";
		int sales_seq = 0;

		conn = DatabaseConnect.getConnection();
		int result = 0;
		int result2 = 0;
		
		//판매 테이블 인서트
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "TEST");
			result = ps.executeUpdate();
			if(result > 0) {
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
				result2 = ps.executeUpdate();
				if(result2 > 0) {
					System.out.println("[DB] sale_detail insert (" + i + ") complete");
				}
			}

		} catch (SQLException e) {
			System.out.println("[DB] sale_detail insert error!");
			e.printStackTrace();
		}
		
		
		try {
			ps = conn.prepareStatement(query3);
			rs = ps.executeQuery();
			if(rs.next())
				sales_seq = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("[DB] select SALES_NO_SEQ error!");
			e.printStackTrace();
		}
		
		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		
		if(result > 0 && result2 > 0) {
			//현재 판매된 상품의 판매수량만큼 재고테이블도 업데이트
			if(payStockUpdate(sales_seq))
				return true;
			else {
				System.out.println("[DB] 상품 판매수량 재고 업데이트 중 오류발생");
				return false;
			}			
		}
		else {
			System.out.println("[DB] sale, sale_detail insert 중 오류 발생");
			return false;
		}

	}
	
	//현재 판매된 상품의 판매수량만큼 재고테이블 업데이트 메서드
	public Boolean payStockUpdate(int sales_seq) {
		
		conn = DatabaseConnect.getConnection();
		
		//현재 판매된 상품들의 상품코드와 상품판매수량 
		String query = "select product_id , sum(quantity) from sales_detail where sales_no = " + sales_seq + " group by product_id";
		
		try {
			HashMap<String, Integer> salesDetailMap = new HashMap<String, Integer>();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				 salesDetailMap.put(rs.getString(1), rs.getInt(2));
			}
			

			for( Map.Entry<String, Integer> entry : salesDetailMap.entrySet()) {
				String product_id = entry.getKey();
				int total = entry.getValue();
				
				for(int i=1; i<=total; i++) {
					//재고에서 해당 상품의 판매된 수량만큼의 수량 차감
					String query2 = "update stock set quantity = (select B.quantity from (select quantity-1 as quantity from stock where product_id = ? and save_status = 'Y' and quantity > 0 and rownum = 1 order by dis_date asc) B)" + 
							" where product_id = ? " + 
							"	and save_status = 'Y' " + 
							"	 and quantity > 0 " + 
							"     and ROWID IN (select dis_date from (select A.ROWID dis_date from stock A where product_id = ? and save_status = 'Y' and quantity > 0 order by dis_date ) where rownum = 1 ) ";
					ps = conn.prepareStatement(query2);
					ps.setString(1, product_id);
					ps.setString(2, product_id);
					ps.setString(3, product_id);
					
					int result = ps.executeUpdate();
					
					//정상적으로 업데이트 되면 반복 계속 진행.
					if(result > 0) {
						continue;
					}else {
						return false;
					}
				}
			}
	
		} catch (SQLException e) {
			System.out.println("[DB] 판매시 재고테이블 업데이트 오류");
			e.printStackTrace();
		}	
		return true;

	}
	
	//이벤트 상품 확인 메서드
	public String searchEvent(String product_id) {
		conn = DatabaseConnect.getConnection();
		
		String query = "SELEC event_type, start_date, end_date FROM EVENT WHERE product_id = ? and save_status = 'Y' and start_date <= SYSDATE and end_date >= SYSDATE";
		String eventType = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, product_id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
					eventType = rs.getString(1);
				}			
			}
		} catch (SQLException e) {
			System.out.println("[DB] Event 조회 중 에러");
			e.printStackTrace();	
		}
		
		return eventType;

	}
	
//	//판매 시퀀스 가져오기
//	public int getSaleSeq() {
//		query = "SELECT sales_no_seq.CURRVAL FROM DUAL ";
//		conn = DatabaseConnect.getConnection();
//		int seq = 0;
//		try {
//			ps = conn.prepareStatement(query);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				seq = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return seq;
//	}
}
