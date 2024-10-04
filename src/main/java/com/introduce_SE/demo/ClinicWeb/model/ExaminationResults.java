package com.introduce_SE.demo.ClinicWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExaminationResults {
	
	public ExaminationResults() {
		
	}
	
	

	public ExaminationResults(String id, Patient patient, String symptom, String disease) {
		super();
		this.id = id;
		this.patient = patient;
		this.symptom = symptom;
		this.disease = disease;
	}



	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private Patient patient;
	
	private String symptom;
	
	private String disease;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	
	
}
