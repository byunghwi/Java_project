package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Commute {

	String dc_date;
	int mem_no;
	String on_time;
	String off_time;
	
	public Commute(
			String dc_date,
			int mem_no,
			String on_time,
			String off_time) {
		
		this.dc_date=dc_date;
		this.mem_no=mem_no;
		this.on_time=on_time;
		this.off_time=off_time;
		
	}
	public String setOntime() {
		
		return on_time;
	}
	
	public String setOfftime() {
		return off_time;
	}
	
	
	
	
}
