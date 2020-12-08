package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.zaxxer.hikari.HikariDataSource;
import account.addAccount.Join;
import account.delAccount.Secession;


// 실행용 메인 클래스
public class Main {
	public static void main(String[] args) {
		new Login();
		
	}	
}
