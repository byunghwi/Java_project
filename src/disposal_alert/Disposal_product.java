package disposal_alert;

import java.util.Date;

public class Disposal_product {
	String product_name;
	Date dis_date;
	
	public Disposal_product() {
	}
	
	public Disposal_product(String product_name, Date dis_date) {
		super();
		this.product_name = product_name;
		this.dis_date = dis_date;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public Date getDis_date() {
		return dis_date;
	}
	
	public void setDis_date(Date dis_date) {
		this.dis_date = dis_date;
	}
	
}