package com.introduce_SE.demo.ClinicWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExaminationResults {
	
	public ExaminationResults(String symptom, Patient patient, Disease disease) {
		super();
		this.symptom = symptom;
		this.patient = patient;
		this.disease = disease;
	}

	public ExaminationResults() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String symptom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patient", insertable = false, updatable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="disease", insertable = false, updatable = false)
	private Disease disease;

	public String getSymptom() {
		return symptom;
	}



	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Disease getDisease() {
		return disease;
	}



	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	
	
}
