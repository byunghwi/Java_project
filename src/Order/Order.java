package Order;
// 일단 만들어둠
import java.util.Date;

public class Order {

	int order_product_no;
	String product_id;
	int quantity;
	int worker_no;
	Date save_time;

	public Order(int order_product_no, String product_id, int quantity, 
			int worker_no, Date save_time) {
		this.order_product_no = order_product_no;
		this.product_id = product_id;
		this.quantity = quantity;
		this.worker_no = worker_no;
		this.save_time = save_time;
	}
	
}