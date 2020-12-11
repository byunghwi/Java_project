package order;

public class Order {
	String product_id;
	String product_name;
	int price;
	
	public Order() {
	}
	
	public Order(String product_id, String product_name, int price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}