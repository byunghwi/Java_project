package product;

import java.util.Date;

public class Product {
	String product_id;
	String product_name;
	Date manu_date;
	Date dis_date;
	int quantity;
	int price;
	
	public Product() {
	}

	public Product(String product_id, String product_name, Date manu_date, Date dis_date, int quantity, int price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.manu_date = manu_date;
		this.dis_date = dis_date;
		this.quantity = quantity;
		this.price = price;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
