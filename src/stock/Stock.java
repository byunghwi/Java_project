package stock;

public class Stock {
	String product_id;
	String product_name;
	int price;
	int quantity;
	
	public Stock() {}
	
	public Stock(String product_id, String product_name, int price, int quantity ) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}
}
