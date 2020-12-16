package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db.DatabaseConnect;

public class ProductDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;

	ResultSetMetaData rsmd = null;

	Product product = null;

	// 상품 전체 목록
	public ArrayList<Product> productAll() {

		conn = DatabaseConnect.getConnection();
		// 상품들 담을 ArrayList 생성
		ArrayList<Product> products = new ArrayList<Product>();

		String query = "SELECT product_id as \"상품코드\", product_name as \"상품명\" "
				+ ", price as \"가격\" , worker_no as \"등록자\" ,TO_CHAR(save_time, 'YYYY-MM-dd') as \"등록일\" "
				+ " FROM product WHERE save_status = 'Y' ORDER BY product_id";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				product = new Product();

				product.setProduct_id(rs.getString(1));
				product.setProduct_name(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setWorker_no(rs.getString(4));
				product.setSave_time(rs.getString(5));

				products.add(product);
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

		return products;

	}

	// 상품 등록
	public void productAdd(Product product) {
		conn = DatabaseConnect.getConnection();

		String query = "insert into product (product_id, product_name, price, worker_no) values (? ,?, ?, ?)";
		
		//상품등록하면 수량 0으로 세팅되고 발주승인대기 테이블에 추가된다.
		String query2 =  "insert into order_product values (ORDER_PRODUCT_NO_SEQ.nextval, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, product.getProduct_id());
			ps.setString(2, product.getProduct_name());			
			ps.setInt(3, product.getPrice());
			ps.setString(4, "TEST"); 	// 추후에 로그인한 작업자 값 받아와서 넣어줄 것.

			int rsCnt = ps.executeUpdate();

			PreparedStatement ps2 = null;
			ps2 = conn.prepareStatement(query2);
			ps2.setString(1, product.getProduct_id());
			ps2.setInt(2, 0);
			ps2.setString(3, "TEST"); 			// 추후에 로그인한 작업자 값 받아와서 넣어줄 것.
			ps2.setString(4, dateToStr(new Date()));
			
			int rsCnt2 = ps2.executeUpdate();
			
			if(rsCnt==1 && rsCnt2==1) {
				System.out.println("[DB] 상품, 발주승인대기 insert 완료\n");
				if(ps2 != null) {
					ps2.close();
				}
			}

		} catch (SQLException e) {
			System.out.println("[DB] Insert 중 오류 발생\n");
			e.printStackTrace();
		}

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}

	}

	// 상품 수정
	public void productEdit(Product product) {
		conn = DatabaseConnect.getConnection();

		String query = "UPDATE product SET product_name = ?, price = ?, worker_no = ?, save_time = ? WHERE product_id = ?";

		try {			
			ps = conn.prepareStatement(query);

			
			ps.setString(1, product.getProduct_name());
			ps.setInt(2, product.getPrice());
			ps.setString(3, "TEST_EDIT");
			ps.setString(4, dateToStr(new Date()));
			ps.setString(5, product.getProduct_id());
		
			int rsCnt = ps.executeUpdate();
			
			if(rsCnt == 1) {
				System.out.println("[DB] Complete\n");
			}

		} catch (SQLException e) {
			System.out.println("[DB] Update 중 오류 발생\n");
			e.printStackTrace();
		}

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
	}

	// 상품 삭제
	public void productDel(String pid) {
		conn = DatabaseConnect.getConnection();

		String query = "UPDATE product SET save_status =\'N\' WHERE product_id = ? ";

		try {

			ps = conn.prepareStatement(query);
			ps.setString(1, pid);

			int rsCnt = ps.executeUpdate();
			if(rsCnt == 1) {
				System.out.println("[DB] 상품 삭제 업데이트 완료.\n");
			}

		} catch (SQLException e) {
			System.out.println("[DB] Update 중 오류 발생\n");
			e.printStackTrace();
		}

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> searchProduct(String combo, String searchWord) {
		ArrayList<Product> products = new ArrayList<Product>();
		conn = DatabaseConnect.getConnection();
		
		String code = null;
		if(combo.equals("상품코드")) {
			code = "product_id";
		}else if(combo.equals("상품명")) {
			code = "product_name";
		}
		
		String query = "SELECT product_id, product_name, price, worker_no, save_time FROM product WHERE save_status = 'Y' and " + code + " LIKE '%" + searchWord + "%' ";
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			int columCnt = rsmd.getColumnCount();

			while (rs.next()) {
				product = new Product();

				product.setProduct_id(rs.getString(1));
				product.setProduct_name(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setWorker_no(rs.getString(4));
				product.setSave_time(rs.getString(5));
				
				products.add(product);
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
		
		return products;
	}
	
	//날짜 변경 메서드
	public String dateToStr (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		
		return strDate;
	}

}
