package com.lec.customer.vo;

public class CustomerVO {
	
	private String customer_id;
	private String customer_pw;
	private String customer_name;
	private String customer_jumin;
	private String customer_phone;
	private String customer_addr;
	private String customer_email;
	
	
	public String getId() {
		return customer_id;
	}
	public void setId(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getPw() {
		return customer_pw;
	}
	public void setPw(String customer_pw) {
		this.customer_pw = customer_pw;
	}
	public String getName() {
		return customer_name;
	}
	public void setName(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getJumin() {
		return customer_jumin;
	}
	public void setJumin(String customer_jumin) {
		this.customer_jumin = customer_jumin;
	}
	public String getPhone() {
		return customer_phone;
	}
	public void setPhone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getAddr() {
		return customer_addr;
	}
	public void setAddr(String customer_addr) {
		this.customer_addr = customer_addr;
	}
	public String getEmail() {
		return customer_email;
	}
	public void setEmail(String customer_email) {
		this.customer_email = customer_email;
	}
	
	@Override
	public String toString() {
		return "CustomerVO [id=" + customer_id + ", pw=" + customer_pw + ", name=" + customer_name + ", jumin=" + customer_jumin + ", phone=" + customer_phone
				+ ", addr=" + customer_addr + ", email=" + customer_email + "]";
	}
	

}
