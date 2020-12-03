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
	
}
