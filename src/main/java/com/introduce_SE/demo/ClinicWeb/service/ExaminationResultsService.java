package com.introduce_SE.demo.ClinicWeb.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;
import com.introduce_SE.demo.ClinicWeb.model.Patient;
import com.introduce_SE.demo.ClinicWeb.repository.ExaminationResultsRepository;

@Service
public class ExaminationResultsService {
	
	@Autowired
	private ExaminationResultsRepository examinationResultsRepository;
	
	public Optional<ExaminationResults> findByID(int idPatient) {
		return examinationResultsRepository.findByPatientId(idPatient);
	}
	
	public ExaminationResults addNewExaminationResults(ExaminationResults er) {
		return examinationResultsRepository.save(er);
	}
	
	public List<Patient> getExaminedPatients(LocalDate date){
		List<Object[]> results = examinationResultsRepository.getExaminedPatients(date);
		List<Patient> p = new ArrayList<>();
		
		for (Object[] result : results) {
	        int id = (int) result[0];
	        Date d = (Date) result[1];
	        LocalDate localDate = d.toLocalDate();
	        String address = (String) result[2];
	        String fullname = (String) result[3];
	        String sex = (String) result[4];
	        int yearOfBirth = (int) result[5];
	        
	        Patient patient = new Patient(id, fullname, sex, address, yearOfBirth, localDate);
	        p.add(patient);
	    }
	    
	    return p;
	}
}
