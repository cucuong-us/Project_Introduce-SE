package com.introduce_SE.demo.ClinicWeb.dto;

public class ExaminationResultsDTO {
	
	public ExaminationResultsDTO() {
		
	}

	public ExaminationResultsDTO(String fullName, String symptom, String disease) {
		super();
		this.fullName = fullName;
		this.symptom = symptom;
		this.disease = disease;
	}
	private String fullName;
	private String symptom;
	private String disease;
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
