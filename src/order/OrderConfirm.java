package order;

import java.util.Date;

public class OrderConfirm { // 발주테이블
	int order_product_no;
	String product_id;
	int quantity;
	String worker_no;
	Date save_time;
	
	public OrderConfirm() {
	}
	
	public OrderConfirm(int order_product_no, String product_id, int quantity, String worker_no, Date save_time) {
		super();
		this.order_product_no = order_product_no;
		this.product_id = product_id;
		this.quantity = quantity;
		this.worker_no = worker_no;
		this.save_time = save_time;
	}
	
	public int getOrder_product_no() {
		return order_product_no;
	}

	public void setOrder_product_no(int order_product_no) {
		this.order_product_no = order_product_no;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getWorker_no() {
		return worker_no;
	}

	public void setWorker_no(String worker_no) {
		this.worker_no = worker_no;
	}
	
	public Date getSave_time() {
		return save_time;
	}
	
	public void setSave_time(Date save_time) {
		this.save_time = save_time;
	}


}