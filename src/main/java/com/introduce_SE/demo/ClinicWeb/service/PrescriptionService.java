package com.introduce_SE.demo.ClinicWeb.service;

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
	
	public Prescription save(Prescription p) {
		return prescriptionRepository.save(p);
	}
}
