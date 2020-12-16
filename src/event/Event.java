package event;

public class Event {
	String event_no;
	String product_id;
	String product_nm;
	String event_type;
	String start_date;
	String end_date;
	String worker_no;
	String save_time;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getWorker_no() {
		return worker_no;
	}
	public String getEvent_no() {
		return event_no;
	}
	public void setEvent_no(String event_no) {
		this.event_no = event_no;
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
	public String getProduct_nm() {
		return product_nm;
	}
	public void setProduct_nm(String product_nm) {
		this.product_nm = product_nm;
	}
	
	
}
