package com.introduce_SE.demo.ClinicWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicine {
	
	public Medicine() {
		
	}
	
	public Medicine(int idMedicine, String nameOfMedicine, int price, String unit, String medicineUsage) {
		super();
		this.idMedicine = idMedicine;
		this.nameOfMedicine = nameOfMedicine;
		this.price = price;
		this.unit = unit;
		this.medicineUsage = medicineUsage;
	}
	
	@Id
	private int idMedicine;
	
	private String nameOfMedicine;
	
	private int price;
	
	private String unit;
	
	private String medicineUsage;

	public int getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(int idMedicine) {
		this.idMedicine = idMedicine;
	}

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
	
	
	
}
