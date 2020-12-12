package stocksub;

import java.util.Date;

public class Stock_info {
	String product_id;
	String product_name;
	int price;
	int quantity;
	Date manu_date;
	Date dis_date;
	Date in_date;
	
	public Stock_info() {}
	
	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getManu_date() {
		return manu_date;
	}

	public void setManu_date(Date manu_date) {
		this.manu_date = manu_date;
	}

	public Date getDis_date() {
		return dis_date;
	}

	public void setDis_date(Date dis_date) {
		this.dis_date = dis_date;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	
}
