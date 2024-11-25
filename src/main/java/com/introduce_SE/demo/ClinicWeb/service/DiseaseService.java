package com.introduce_SE.demo.ClinicWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Disease;
import com.introduce_SE.demo.ClinicWeb.repository.DiseaseRepository;

@Service
public class DiseaseService {
	
	@Autowired
	private DiseaseRepository diseaseRepository;
	
	public Optional<Disease> findById(int id) {
		return diseaseRepository.findById(id);
	}
}
