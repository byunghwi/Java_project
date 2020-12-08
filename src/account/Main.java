package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import account.addAccount.Join;
import account.delAccount.Secession;

public class Main {
	public static void main(String[] args) {
		
		new Secession();
		
		
	}	
}
