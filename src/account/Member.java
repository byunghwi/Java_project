package account;

import java.util.Date;


// 멤버 정보에 대한 클래스
// getter setter 탑재 예정
public class Member {
	
	public String mem_id;
	public String mem_pwd;
	public String mem_nm;
	public String premit_id;
	public String res_no;
	public String phone;
	public String address;
	public char sex;
	public String mail;
	
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

