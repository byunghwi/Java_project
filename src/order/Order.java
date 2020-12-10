package order;

public class Order {
	String product_id;
	String product_name;
	int quantity;
	int price;
	
	public Order() {
	}
	
	public Order(String product_id, String product_name, int quantity, int price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
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