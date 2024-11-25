package com.introduce_SE.demo.ClinicWeb.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Disease {

	public Disease() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	

	@OneToMany(mappedBy="disease")
	private List<ExaminationResults> examinationResults;
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExaminationResults> getExaminationResults() {
		return examinationResults;
	}

	public void setExaminationResults(List<ExaminationResults> examinationResults) {
		this.examinationResults = examinationResults;
	}
	
	
	
}
