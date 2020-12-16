package disposal_alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import db.DatabaseConnect;

public class AlertDao extends JFrame {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	Disposal_product dp;
	
	// 확인창
	public ArrayList<Disposal_product> productAll() {
		conn = DatabaseConnect.getConnection();
		ArrayList<Disposal_product> list = new ArrayList<Disposal_product>();
		sql = "SELECT product_name, dis_date\r\n"
				+ "    FROM stock\r\n"
				+ "    WHERE TO_CHAR(dis_date, 'YYYYMMDD') < TO_CHAR(SYSDATE + 7, 'YYYYMMDD')\r\n"
				+ "    AND save_status = 'Y'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				dp = new Disposal_product();
				
				dp.setProduct_name(rs.getString(1));
				dp.setDis_date(rs.getDate(2));
				
				list.add(dp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}