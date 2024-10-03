package com.introduce_SE.demo.ClinicWeb.dto;

public class PrescriptionDTO {
	
	public PrescriptionDTO() {
		
	}

	public PrescriptionDTO(String nameOfMedicine, String unit, int quantity, String medicineUsage) {
		super();
		this.nameOfMedicine = nameOfMedicine;
		this.unit = unit;
		this.quantity = quantity;
		this.medicineUsage = medicineUsage;
	}
	private String nameOfMedicine;
	private String unit;
	private int quantity;
	private String medicineUsage;
	public String getNameOfMedicine() {
		return nameOfMedicine;
	}

	public void setNameOfMedicine(String nameOfMedicine) {
		this.nameOfMedicine = nameOfMedicine;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMedicineUsage() {
		return medicineUsage;
	}

	public void setMedicineUsage(String medicineUsage) {
		this.medicineUsage = medicineUsage;
	}
	
	
}
