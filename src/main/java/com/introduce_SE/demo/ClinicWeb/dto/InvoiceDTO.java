package com.introduce_SE.demo.ClinicWeb.dto;

public class InvoiceDTO {

	public InvoiceDTO() {
		
	}
	
	private int exPrice;
	private float medicinePrice;
	private float total;
	public int getExPrice() {
		return exPrice;
	}
	public void setExPrice(int exPrice) {
		this.exPrice = exPrice;
	}
	public float getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(float medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
