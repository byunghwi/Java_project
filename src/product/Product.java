package product;

import java.util.Date;

public class Product {
	String product_id;
	String product_name;
	int price;
	String worker_no;
	String save_time;

	public Product() {
	}

	public Product(String product_id, String product_name, int price, String worker_no, String save_time) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.worker_no = worker_no;
		this.save_time = save_time;
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

	public String getWorker_no() {
		return worker_no;
	}

	public void setWorker_no(String worker_no) {
		this.worker_no = worker_no;
	}

	public String getSave_time() {
		return save_time;
	}

	public void setSave_time(String save_time) {
		this.save_time = save_time;
	}
	
	
	
	
	
	
}
