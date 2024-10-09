package com.introduce_SE.demo.ClinicWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Medicine;
import com.introduce_SE.demo.ClinicWeb.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	public Optional<Medicine> findById(int id_medicine) {
		return medicineRepository.findById(id_medicine);
	}
}
