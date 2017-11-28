package com.webapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private Integer id;
	private String name;
	private String gender;
	private String phoneNumber;
	private Date dob;
	private String identityNumber;
	
	public User(String name, String gender, String phoneNumber, Date dob, String identityNumber) {
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.identityNumber = identityNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getIdentityNumber() {
		return identityNumber;
	}
	
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	
}
