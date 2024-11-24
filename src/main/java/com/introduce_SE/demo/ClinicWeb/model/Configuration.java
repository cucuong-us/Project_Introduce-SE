package com.introduce_SE.demo.ClinicWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Configuration {

	public Configuration() {
		
	}
	
	public Configuration(int maxPatient, int examinationPrice) {
		super();
		this.maxPatient = maxPatient;
		this.examinationPrice = examinationPrice;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int maxPatient;
	
	public int examinationPrice;

	public int getMaxPatient() {
		return maxPatient;
	}

	public void setMaxPatient(int maxPatient) {
		this.maxPatient = maxPatient;
	}

	public int getExaminationPrice() {
		return examinationPrice;
	}

	public void setExaminationPrice(int examinationPrice) {
		this.examinationPrice = examinationPrice;
	}
	
	
	
}
