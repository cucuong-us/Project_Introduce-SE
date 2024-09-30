package com.introduce_SE.demo.ClinicWeb.model.impl;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class prescriptionId implements Serializable {
	
	public prescriptionId() {
		
	}

	public prescriptionId(int id, int idMedicine) {
		super();
		this.id = id;
		this.idMedicine = idMedicine;
	}

	private int id;
	private int idMedicine;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(int idMedicine) {
		this.idMedicine = idMedicine;
	}
	
	
}
