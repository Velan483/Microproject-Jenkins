package com.velan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
	@Id
	@Column(name="AdminID")
	private int admin_id;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="Confrim Password")
	private String confrim_password;
	@Column(name="Phone Number")
	private String phone_number;
	@Column(name="Address")
	private String address;
	
	public Admin() {
		super();
	}

	public Admin(int admin_id, String name, String email, String password, String confrim_password, String phone_number,
			String address) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confrim_password = confrim_password;
		this.phone_number = phone_number;
		this.address = address;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfrim_password() {
		return confrim_password;
	}

	public void setConfrim_password(String confrim_password) {
		this.confrim_password = confrim_password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confrim_password=" + confrim_password + ", phone_number=" + phone_number + ", address=" + address
				+ "]";
	}

}
