package com.introduce_SE.demo.ClinicWeb.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
	
	public Patient(int idPatient, String fullname, String sex, String address, int yearOfBirth, LocalDate date,
			List<ExaminationResults> examinationResults, List<Prescription> prescriptions) {
		super();
		this.idPatient = idPatient;
		this.fullname = fullname;
		this.sex = sex;
		this.address = address;
		this.yearOfBirth = yearOfBirth;
		this.date = date;
		this.examinationResults = examinationResults;
		this.prescriptions = prescriptions;
	}

	public Patient() {
		
	}
	
	@Id
	@Column(name = "id_patient")
	private int idPatient;
	
	private String fullname;
	
	private String sex;
	
	private String address;
	
	private int yearOfBirth;
	
	private LocalDate date;
	
	@OneToMany(mappedBy = "patient")
	private List<ExaminationResults> examinationResults;
	
	@OneToMany(mappedBy = "patient")
	private List<Prescription> prescriptions;

	public int getId() {
		return idPatient;
	}

	public void setId(int idPatient) {
		this.idPatient = idPatient;
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

	public List<ExaminationResults> getExaminationResults() {
		return examinationResults;
	}

	public void setExaminationResults(List<ExaminationResults> examinationResults) {
		this.examinationResults = examinationResults;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	
	
}
