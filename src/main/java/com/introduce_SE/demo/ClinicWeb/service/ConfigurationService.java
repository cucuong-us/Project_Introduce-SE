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
}
