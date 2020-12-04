package account;

import java.util.Date;

public class Member {
	
	String mem_id;
	String mem_pwd;
	String mem_nm;
	String premit_id;
	String res_no;
	String phone;
	String address;
	char sex;
	String mail;
	
	public Member(
			String mem_id,
			String mem_pwd,
			String mem_nm,
			String res_no,
			String phone,
			String address,
			char sex,
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

