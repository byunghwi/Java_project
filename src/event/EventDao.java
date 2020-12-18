package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.DatabaseConnect;
import product.Product;
import stock.Stock;

public class EventDao {
	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;

	ResultSetMetaData rsmd = null;

	Product product = null;
	Stock stock = null;

	public EventDao() {
	}

	public ArrayList<Event> eventAll() {
		conn = DatabaseConnect.getConnection();

		String query = "SELECT e.event_no, e.event_type, e.product_id, p.product_name, to_char(e.start_dt, 'YYYY-MM-dd'), to_char(e.end_dt, 'YYYY-MM-dd'), e.worker_no, to_char(e.save_time, 'YY-MM-dd HH24:Mi:SS') "
				+ "FROM event e, product p "
				+ "WHERE e.product_id = p.product_id and p.save_status = 'Y' and e.save_status = 'Y' ORDER BY e.save_time DESC";

		ArrayList<Event> eventList = new ArrayList<Event>();

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Event event = new Event();
				event.setEvent_no(rs.getString(1));
				event.setEvent_type(rs.getString(2));
				event.setProduct_id(rs.getString(3));
				event.setProduct_nm(rs.getString(4));			
				event.setStart_date(rs.getString(5));
				event.setEnd_date(rs.getString(6));
				event.setWorker_no(rs.getString(7));
				event.setSave_time(rs.getString(8));

				eventList.add(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DB사용 종료
			try {
				DatabaseConnect.dbClose(rs, ps, conn);
			} catch (SQLException e) {
				System.out.println("[DB] 자원 반납 중 오류 발생\n");
				e.printStackTrace();
			}
		}
		
		return eventList;
	}

	// 이벤트 등록
	public Boolean eventAdd(Event event) {
		conn = DatabaseConnect.getConnection();

		String query = "insert into event  values (event_no_seq.nextval ,?, ?, ?, ?, 'Y', ?, SYSDATE)";
		// (event_no, event_type, product_id, start_dt, end_dt, save_status, worker_no,
		// save_time)
		int rsCnt = 0;
		
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, event.getEvent_type());
			ps.setString(2, event.getProduct_id());
			ps.setString(3, event.getStart_date());
			ps.setString(4, event.getEnd_date());
			ps.setString(5, "TEST"); // 추후에 로그인한 작업자 값 받아와서 넣어줄 것.


			rsCnt = ps.executeUpdate();

			if (rsCnt == 1) {
				System.out.println("[DB] Event insert 완료\n");
			}

		} catch (SQLException e) {
			System.out.println("[DB] Event Insert 중 오류 발생\n");
			e.printStackTrace();
		}

		// DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			System.out.println("[DB] 자원 반납 중 오류 발생\n");
			e.printStackTrace();
		}
		
		if(rsCnt == 1)
			return true;
		else
			return false;

	}

	// 이벤트 수정
	public void eventEdit(Event event) {
		conn = DatabaseConnect.getConnection();

		String query = "UPDATE event SET event_type = ?, start_dt = ? , end_dt = ?, worker_no = ?, save_time = ? WHERE event_no = ?";
		System.out.println(query);
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, event.getEvent_type());
			ps.setString(2, event.getStart_date());
			ps.setString(3, event.getEnd_date());
			ps.setString(4, "TEST");
			ps.setString(5, event.getSave_time());
			ps.setString(6, event.getEvent_no());

			int rsCnt = ps.executeUpdate();

			if (rsCnt == 1) {
				System.out.println("[DB] event edit Complete\n");
			}

		} catch (SQLException e) {
			System.out.println("[DB] event edit 중 오류 발생\n");
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

	// 이벤트 삭제
	public void eventDel(String eventno) {
		conn = DatabaseConnect.getConnection();

		String query = "UPDATE event SET save_status =\'N\' WHERE event_no = ? ";

		try {

			ps = conn.prepareStatement(query);
			ps.setString(1, eventno);

			int rsCnt = ps.executeUpdate();
			if (rsCnt == 1) {
				System.out.println("[DB] 이벤트 삭제 업데이트 완료.\n");
			}

		} catch (SQLException e) {
			System.out.println("[DB] 이벤트 삭제 중 오류 발생\n");
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
}
