package com.introduce_SE.demo.ClinicWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Configuration {
	
	public Configuration() {
		
	}
	
	public Configuration(int maxPatient) {
		super();
		this.maxPatient = maxPatient;
	}

	@Id
	public int maxPatient;

	public int getMaxPatient() {
		return maxPatient;
	}

	public void setMaxPatient(int maxPatient) {
		this.maxPatient = maxPatient;
	}
	
	
}
