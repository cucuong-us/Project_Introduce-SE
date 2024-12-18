package com.introduce_SE.demo.ClinicWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;
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
}
