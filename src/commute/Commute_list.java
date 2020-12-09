package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import product.Product;

public class Commute_list {

	String start_date;
	String end_date;
	String mem_name;
	
	public JScrollPane productsScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable commuteTable = new JTable(tblModel);
	
	public Vector<String> rows;
	
	public Commute_list(String start_date,String end_date,String mem_name) {
	
		this.start_date=start_date;
		this.end_date=end_date;
		this.mem_name=mem_name;
		
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@175.115.175.207:1521/orcl.115.175.144");
		ds.setUsername("puser");
		ds.setPassword("12341234");
		
		String sql = "SELECT * FROM daily_check WHERE dc_date between ? and ? and mem_no= ?";
		
		ArrayList<Commute> commutes = new ArrayList<Commute>();
		
		try {
			Connection conn=ds.getConnection();
			PreparedStatement pstmt=
					conn.prepareStatement(sql);
			
			pstmt.setString(1,start_date);
			pstmt.setString(2,end_date);
			pstmt.setString(3,mem_name);
			
			ResultSet rs = pstmt.executeQuery();	

			while(rs.next()) {
				Commute commute = new Commute(rs.getString("dc_date"),rs.getString("mem_no"),rs.getString("on_time"),rs.getString("off_time"));	
				commutes.add(commute);	
			}
			
			pstmt.execute();
			pstmt.close();
			conn.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void addProductLine(ArrayList<Commute> commutes) {
		int size = commutes.size();
		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(commutes.get(i).getDc_date().toString());
			rows.addElement(commutes.get(i).getMem_no().toString());
			rows.addElement(commutes.get(i).getOn_time().toString());
			rows.addElement(commutes.get(i).getOff_time().toString());
			tblModel.addRow(rows);
		}
		
		productsScrollPane.setViewportView(commuteTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("날짜");
		colNames.add("사원명");
		colNames.add("출근시간");
		colNames.add("퇴근시간");
		return colNames;
	}
}
