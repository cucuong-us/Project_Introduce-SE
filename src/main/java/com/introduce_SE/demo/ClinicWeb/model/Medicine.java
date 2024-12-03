package com.introduce_SE.demo.ClinicWeb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medicine {
	
	public Medicine(String nameOfMedicine, int price, String unit, String medicineUsage,
			List<Prescription> prescriptions) {
		super();
		this.nameOfMedicine = nameOfMedicine;
		this.price = price;
		this.unit = unit;
		this.medicineUsage = medicineUsage;
		this.prescriptions = prescriptions;
	}

	public Medicine() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicine;
	
	private String nameOfMedicine;
	
	private int price;
	
	private String unit;
	
	private String medicineUsage;
	
	public void setIdMedicine(int idMedicine) {
		this.idMedicine = idMedicine;
	}

	public int getIdMedicine() {
		return idMedicine;
	}

	@OneToMany(mappedBy = "medicine")
	@JsonIgnore
	private List<Prescription> prescriptions;

	public String getNameOfMedicine() {
		return nameOfMedicine;
	}

	public void setNameOfMedicine(String nameOfMedicine) {
		this.nameOfMedicine = nameOfMedicine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMedicineUsage() {
		return medicineUsage;
	}

	public void setMedicineUsage(String medicineUsage) {
		this.medicineUsage = medicineUsage;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
	
	
	
}
