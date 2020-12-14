package stocksub;

import java.util.Date;

public class Disposal {
	
	String disposalcode;
	String product_id;
	String mem_id;
	int quantity;
	Date manu_date;
	Date dis_date;
	Date save_time;
	
	public String getDisposalcode() {
		return disposalcode;
	}



	public void setDisposalcode(String disposalcode) {
		this.disposalcode = disposalcode;
	}



	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public String getMem_id() {
		return mem_id;
	}



	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
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



	public Date getSave_time() {
		return save_time;
	}



	public void setSave_time(Date save_time) {
		this.save_time = save_time;
	}




	
	
	
	public Disposal() {
		// TODO Auto-generated constructor stub
	}
}
