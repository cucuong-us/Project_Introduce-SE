package com.introduce_SE.demo.ClinicWeb.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Patient;
import com.introduce_SE.demo.ClinicWeb.repository.PatientRepository;

@Service
public class PatientService {
	

	@Autowired
	private PatientRepository patientRepository;
	
	public int generatePatientId() {
		long count = patientRepository.count();
		return (int) (9999+count);
	}
	
	public Patient addPatient(Patient patient) {
		patient.setId(generatePatientId());
		patient.setDate(LocalDate.now());
		return patientRepository.save(patient);
	}
	
	public List<Patient> findByDate(LocalDate date) {
		return patientRepository.findByDate(date);
	}
	
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	public Optional<Patient> findById(int idPatient) {
		return patientRepository.findByIdPatient(idPatient);
	}
}
