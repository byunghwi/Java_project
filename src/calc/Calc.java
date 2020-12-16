package calc;

public class Calc {

	String sale_date;
	int total_sale_quantity;
	int total_sale_price;
	String worker_no;
	String save_time;
	
	public Calc(String sale_date,
	int total_sale_quantity,
	int total_sale_price,
	String worker_no,
	String save_time) {
		
		this.sale_date=sale_date;
		this.total_sale_quantity=total_sale_quantity;
		this.total_sale_price=total_sale_price;
		this.worker_no=worker_no;
		this.save_time=save_time;	
	}
	
	public String getsale_date() {
		return sale_date;
	}

	public void setsale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public int gettotal_sale_quantity() {
		return total_sale_quantity;
	}

	public void setMem_no(int total_sale_quantity) {
		this.total_sale_quantity = total_sale_quantity;
	}

	public int gettotal_sale_price() {
		return total_sale_price;
	}

	public void setOn_time(int total_sale_price) {
		this.total_sale_price = total_sale_price;
	}
	public String getworker_no() {
		return worker_no;
	}

	public void setworker_no(String worker_no) {
		this.worker_no = worker_no;
	}
	
	public String getsave_time() {
		return save_time;
	}
	
	public void setsave_time(String save_time) {
		this.save_time = save_time;
	}
	
}
