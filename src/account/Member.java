package account;

import java.util.Date;


// 맴버에 대한 객체
public class Member {
	
	public String mem_id;
	public String mem_pwd;
	public String mem_nm;
	public String premit_id;
	public String res_no;
	public String phone;
	public String address;
	public String sex;
	public String mail;
	
	public Member(
			String mem_id,
			String mem_pwd,
			String mem_nm,
			String res_no,
			String phone,
			String address,
			String sex,
			String mail
			) {
		
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_nm = mem_nm;
		this.res_no = res_no;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.mail = mail;
		
		this.premit_id = "manager";
	}	
	

}

