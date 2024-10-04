package com.introduce_SE.demo.ClinicWeb.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
	
	public Patient() {
		
	}

	public Patient(String id, String fullname, String sex, String address, int yearOfBirth, LocalDate date) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.sex = sex;
		this.address = address;
		this.yearOfBirth = yearOfBirth;
		this.date = date;
	}
	
	@Id
	private String id;
	
	private String fullname;
	
	private String sex;
	
	private String address;
	
	private int yearOfBirth;
	
	private LocalDate date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
