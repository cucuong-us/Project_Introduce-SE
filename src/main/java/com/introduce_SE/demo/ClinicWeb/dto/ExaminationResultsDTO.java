package com.introduce_SE.demo.ClinicWeb.dto;

import java.time.LocalDate;

public class ExaminationResultsDTO {
	
	public ExaminationResultsDTO(String fullName, String symptom, String disease, LocalDate date) {
		super();
		this.fullName = fullName;
		this.symptom = symptom;
		this.disease = disease;
		this.date = date;
	}
	public ExaminationResultsDTO() {
		
	}
	
	private String fullName;
	private String symptom;
	private String disease;
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
