package commute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Commute {

	String dc_date;
	String mem_no;
	String on_time;
	String off_time;
	
	public Commute() {
		
	}
	
	public Commute(String dc_date,String mem_no,String on_time,String off_time) {
		this.dc_date=dc_date;
		this.mem_no=mem_no;
		this.on_time=on_time;
		this.off_time=off_time;
	}
	
	public String getDc_date() {
		return dc_date;
	}

	public void setDc_date(String dc_date) {
		this.dc_date = dc_date;
	}

	public String getMem_no() {
		return mem_no;
	}

	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}

	public String getOn_time() {
		return on_time;
	}

	public void setOn_time(String on_time) {
		this.on_time = on_time;
	}
	public String getOff_time() {
		return off_time;
	}

	public void setOff_time(String off_time) {
		this.off_time = off_time;
	}
	
}

