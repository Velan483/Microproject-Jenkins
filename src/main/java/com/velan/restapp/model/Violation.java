package com.velan.restapp.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Violation")
public class Violation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ViolationID")
	private int violation_id;
	@Column(name="Violation Date")
	private Date violation_Date ;
	@Column(name="Violation Type")
	private String violation_type;
	@Column(name="Location")
	private String location;
	@Column(name="Description")
	private String description;

	@ManyToOne
    @JoinColumn(name = "ViolatorID")
    private Violator violator;

	public Violation() {
		super();
	}
	
	public Violation(int violation_id, Date violation_Date, String violation_type, String location, String description,
			Violator violator) {
		super();
		this.violation_id = violation_id;
		this.violation_Date = violation_Date;
		this.violation_type = violation_type;
		this.location = location;
		this.description = description;
		this.violator = violator;
	}

	public int getViolation_id() {
		return violation_id;
	}

	public void setViolation_id(int violation_id) {
		this.violation_id = violation_id;
	}

	public Date getViolation_Date() {
		return violation_Date;
	}

	public void setViolation_Date(Date violation_Date) {
		this.violation_Date = violation_Date;
	}

	public String getViolation_type() {
		return violation_type;
	}

	public void setViolation_type(String violation_type) {
		this.violation_type = violation_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Violator getViolator() {
		return violator;
	}

	public void setViolator(Violator violator) {
		this.violator = violator;
	}

	@Override
	public String toString() {
		return "Violation [violation_id=" + violation_id + ", violation_Date=" + violation_Date + ", violation_type="
				+ violation_type + ", location=" + location + ", description=" + description + ", violator=" + violator
				+ "]";
	}

	
    
}
