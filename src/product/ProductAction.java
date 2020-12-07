package product;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.DatabaseConnect;

public class ProductAction extends MouseAdapter{
	
	Connection conn =null;
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
	ResultSetMetaData rsmd = null;
	
	String query;
	
	String chkBtn;
	
	JTextField[] fields;
	
	DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
	
	JFrame subOpenFrame;

	
	public ProductAction(JTextField[] fields, String chkBtn, JFrame subOpenFrame) throws ParseException {
		//텍스트 필드값 배열
		this.fields = fields;
		this.chkBtn = chkBtn;
		this.subOpenFrame = subOpenFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//등록버튼 누를 떄
		if(chkBtn.equals("Regist")) {
			query = "insert into product (product_id, product_name, manu_date, dis_date, price) values (?, ? ,? ,?, ?)";
			
			try {
				conn = DatabaseConnect.getConnection();
				//자동으로 커밋되는 것을 막음.
				conn.setAutoCommit(false);
				
				ps = conn.prepareStatement(query);
				
				
				ps.setString(1, fields[0].getText());
				ps.setString(2, fields[1].getText());
				ps.setString(3, fields[2].getText());
				ps.setString(4, fields[3].getText());
				ps.setInt(5, Integer.parseInt(fields[4].getText()));

				int rsCnt = ps.executeUpdate();
				
				if(rsCnt == 1) {
					System.out.println("[DB] successfully insert to product\n");
					conn.commit();
					
					//확인 팝업창
					JOptionPane.showMessageDialog(null, "[SYSTEM] 등록이 완료되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
					
					//메서드 호출한 클래스의 서브프레임 닫아주기.
					subOpenFrame.dispose();
					
				}else {
					System.out.println("[DB] insert error!!\n");
					conn.rollback();
	
				}
			} catch (SQLException e1) {
				System.out.println("[DB error!]\n");
				e1.printStackTrace();
			} 
			
		//취소버튼 누를 때 메서드 호출한 클래스의 서브프레임 닫아주기.
		}else if(chkBtn.equals("Cancel")){
			subOpenFrame.dispose();
		}
		
		//DB사용 종료
		try {
			DatabaseConnect.dbClose(rs, ps, conn);
		} catch (SQLException e1) {
			System.out.println("[DB 자원 반납 오류!]\n");
			e1.printStackTrace();
		}
	}

}
