package com.introduce_SE.demo.ClinicWeb.service;

import java.util.List;
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
	
	public List<Disease> findAll() {
		return diseaseRepository.findAll();
	}
	
	public Disease save(Disease disease) {
		return diseaseRepository.save(disease);
	}
	
	public void deleteById(int id) {
		diseaseRepository.deleteById(id);
	}
	
	public Disease updateById(int id, Disease disease) {
		Optional<Disease> d = diseaseRepository.findById(id);
		if(d.isEmpty()) {
			return d.get();
		}
		
		if(disease.getName() != null) 
			d.get().setName(disease.getName());
		
		return diseaseRepository.save(d.get());
	}
}
