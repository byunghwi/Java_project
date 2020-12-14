package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;
import account.addAccount.Join;
import account.delAccount.Secession;
import account.editAccount.Edit;
import account.editAccount.Read_Account;

public class Main {
	public static void main(String[] args) {

		new Join();
		
		
	}	
}
