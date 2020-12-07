package product;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import db.DatabaseConnect;

public class ProductAction extends MouseAdapter{
	
	Connection conn =null;
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
	ResultSetMetaData rsmd = null;
	
	String query;
	
	JTextField[] fields;
	
	DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

	
	public ProductAction(JTextField[] fields) throws ParseException {
		//텍스트 필드값 배열
		this.fields = fields;

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		query = "insert into product (product_id, product_name, manu_date, dis_date, price) values (?, ? ,? ,?, ?)";
		
		
		try {
			conn = DatabaseConnect.getConnection();
			//자동으로 커밋되는 것을 막음.
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(query);
			System.out.println("ps > " + ps);
			//확인용////////////////////////////////////////
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i].getText());
			}
			//////////////////////////////////////////////
			
			
			ps.setString(1, fields[0].getText());
			ps.setString(2, fields[1].getText());
			ps.setString(3, fields[2].getText());
			ps.setString(4, fields[3].getText());
			ps.setInt(5, Integer.parseInt(fields[4].getText()));

			int rsCnt = ps.executeUpdate();
			
			if(rsCnt == 1) {
				System.out.println("[DB] successfully insert to product\n");
				conn.commit();
			}else {
				System.out.println("[DB] insert error!!\n");
				conn.rollback();
			}
		} catch (SQLException e1) {
			System.out.println("[DB error!]\n");
			e1.printStackTrace();
		}
	}
}
