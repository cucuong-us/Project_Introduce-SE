package com.introduce_SE.demo.ClinicWeb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Prescription;
import com.introduce_SE.demo.ClinicWeb.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public List<Prescription>  findByPatientId(int idPatient) {
		return prescriptionRepository.findByPatientId(idPatient);
	}
	
	public Prescription addNewPrecription(Prescription p) {
		return prescriptionRepository.save(p);
	}
	
	public void deletePrescription(Prescription p) {
		prescriptionRepository.deleteById(p.getId());
	}	
	
	public float revenuePerDay(LocalDate date) {
		return prescriptionRepository.revenuePerDay(date);
	}
	
	public float  revenuePerMonth(LocalDate date) {
		return prescriptionRepository.revenuePerMonth(date.getMonthValue());
	}
	
	public float medicinePrice(int id) {
		return prescriptionRepository.medicinePrice(id);
	}
}
