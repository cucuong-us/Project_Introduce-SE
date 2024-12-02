package com.introduce_SE.demo.ClinicWeb.dto;

import java.time.LocalDate;

public class RevenueDTO {

	public RevenueDTO() {
		
	}
	
	LocalDate date;
	int numberOfPatient;
	float revenue;
	float rate;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNumberOfPatient() {
		return numberOfPatient;
	}
	public void setNumberOfPatient(int numberOfPatient) {
		this.numberOfPatient = numberOfPatient;
	}
	public float getRevenue() {
		return revenue;
	}
	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
}
