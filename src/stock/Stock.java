package stock;

public class Stock {
	int stock_no;
	String product_id;
	String product_name;
	String in_date;
	String manu_date;
	String dis_date;
	int price;
	int quantity;
	String save_status;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public int getStock_no() {
		return stock_no;
	}

	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
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

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	public String getManu_date() {
		return manu_date;
	}

	public void setManu_date(String manu_date) {
		this.manu_date = manu_date;
	}

	public String getDis_date() {
		return dis_date;
	}

	public void setDis_date(String dis_date) {
		this.dis_date = dis_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSave_status() {
		return save_status;
	}

	public void setSave_status(String save_status) {
		this.save_status = save_status;
	}
}
