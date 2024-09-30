package com.introduce_SE.demo.ClinicWeb.model;

import com.introduce_SE.demo.ClinicWeb.model.impl.prescriptionId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescription {
	
	public Prescription() {
		
	}

	public Prescription(prescriptionId id, Patient patient, int quantity) {
		super();
		this.id = id;
		this.patient = patient;
		this.quantity = quantity;
	}

	@EmbeddedId
	private prescriptionId id;
	
	@ManyToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="idMedicine", insertable = false, updatable = false)
	private Medicine medicine;
	
	private int quantity;

	public prescriptionId getId() {
		return id;
	}

	public void setId(prescriptionId id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
