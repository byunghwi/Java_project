package product;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import db.DatabaseConnect;

public class ProductMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tmodel;
	private String columnNames[];
	private String columnVals[];

	public ProductMain() throws SQLException {

		Dimension dim = new Dimension(1000, 500);
		setTitle("편의점물품관리");
		setLocation(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(dim);
		pack();
		setVisible(true);

		excutequerys();
		
		JTable table = new JTable(tmodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setSize(800,300);
		add(scrollpane);
	}


	//쿼리 실행
	public void excutequerys() throws SQLException {
		String query = "SELECT * FROM PRODUCT";

		DatabaseConnect db = new DatabaseConnect(query);
		ResultSet rs = db.getRs();
		ResultSetMetaData rsmd = rs.getMetaData();

		int columnCnt = rsmd.getColumnCount(); // 컬럼 수

		columnNames(rs, rsmd, columnCnt);

		// 테이블 로우 0번째에 DB컬럼명들 뿌려주기.
		tmodel = new DefaultTableModel(columnNames, 0);
		//컬럼들 값 추출 후 테이블 로우마다 쌓아주기.
		columnVal(rs, rsmd, columnCnt);
	
	}

	// 컬럼네임 배열 저장
	public void columnNames(ResultSet rs, ResultSetMetaData rsmd, int columnCnt) {
		try {
			
			columnNames = new String[columnCnt];
			
			if (rs.next()) {
				for (int i = 0; i < columnCnt; i++) {
					//System.out.println(i+" " + rsmd.getColumnName(i + 1));
					columnNames[i] = rsmd.getColumnName(i + 1);
				}
			}
		} catch (SQLException e) {
			System.err.println("sql exception 발생!");
			e.printStackTrace();
		}
	}
	
	//컬럼값들 추출 후 테이블 로우에 추가하기.
	public void columnVal(ResultSet rs, ResultSetMetaData rsmd, int columnCnt) {
		try {
			columnVals = new String[columnCnt];
			while (rs.next()) {
				for (int i = 0; i < columnCnt; i++) {
					columnVals[i] = rs.getString(rsmd.getColumnName(i + 1));
				}
				System.out.println(Arrays.toString(columnVals));
				tmodel.addRow(columnVals);
			}
			
		} catch (SQLException e) {
			System.err.println("sql exception 발생!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		new ProductMain();
	}
}
