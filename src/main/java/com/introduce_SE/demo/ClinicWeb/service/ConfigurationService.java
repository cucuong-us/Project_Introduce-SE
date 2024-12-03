package com.introduce_SE.demo.ClinicWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Configuration;
import com.introduce_SE.demo.ClinicWeb.repository.ConfigurationRepository;

@Service
public class ConfigurationService {
	
	@Autowired 
	private ConfigurationRepository configurationRepository;
	
	public Optional<Configuration> findById(int id){
		return configurationRepository.findById(id);
	}
	
	public Configuration update(Configuration configuration) {
		Optional<Configuration> c = configurationRepository.findById(1);
		if(c.isEmpty()) {
			return c.get();
		}
		
		if(configuration.getMaxPatient() != 0) 
			c.get().setMaxPatient(configuration.getMaxPatient());
		
		if(configuration.getExaminationPrice() != 0) 
			c.get().setExaminationPrice(configuration.getExaminationPrice());
		
		
		return configurationRepository.save(c.get());
	}
}
