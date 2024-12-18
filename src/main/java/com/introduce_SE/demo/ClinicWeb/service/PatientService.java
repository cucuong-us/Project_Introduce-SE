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
	
	public Patient addPatient(Patient patient) {
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
		return patientRepository.findById(idPatient);
	}
	 
	public void deleteById(int idPatient) {
		patientRepository.deleteById(idPatient);
	}
	
	public List<Patient> searchPatients(Integer idPatient, String fullname, LocalDate date) {
		return patientRepository.searchPatients(idPatient, fullname, date);
	}
	
	public int countByDate(LocalDate date) {
		return patientRepository.countByDate(date);
	}
	
	public int countByMonth(LocalDate date) {
		return patientRepository.countByMonth(date);
	}
}
