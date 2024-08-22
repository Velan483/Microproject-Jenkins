package com.velan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Violator")
public class Violator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ViolatorID")
	private int violator_id;
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
	@Column(name="Gender")
	private String gender;
	@Column(name="License Plate")
	private String license_plate ;
	@Column(name="Vehicle Type")
	private String vehicle_type;
	@Column(name="Vehicle Model")
	private String vehicle_model;
	
	public Violator() {
		super();
	}

	public Violator(int violator_id, String name, String email, String password, String confrim_password,
			String phone_number, String address, String gender, String license_plate, String vehicle_type,
			String vehicle_model) {
		super();
		this.violator_id = violator_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confrim_password = confrim_password;
		this.phone_number = phone_number;
		this.address = address;
		this.gender = gender;
		this.license_plate = license_plate;
		this.vehicle_type = vehicle_type;
		this.vehicle_model = vehicle_model;
	}

	public int getViolator_id() {
		return violator_id;
	}

	public void setViolator_id(int violator_id) {
		this.violator_id = violator_id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	@Override
	public String toString() {
		return "Violator [violator_id=" + violator_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confrim_password=" + confrim_password + ", phone_number=" + phone_number + ", address=" + address
				+ ", gender=" + gender + ", license_plate=" + license_plate + ", vehicle_type=" + vehicle_type
				+ ", vehicle_model=" + vehicle_model + "]";
	}	
	
}
