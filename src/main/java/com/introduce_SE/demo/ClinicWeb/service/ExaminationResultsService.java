package com.introduce_SE.demo.ClinicWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;
import com.introduce_SE.demo.ClinicWeb.repository.ExaminationResultsRepository;

@Service
public class ExaminationResultsService {
	
	@Autowired
	private ExaminationResultsRepository examinationResultsRepository;
	
	public List<ExaminationResults> findByID(int idPatient) {
		return examinationResultsRepository.findByPatientId(idPatient);
	}
}
