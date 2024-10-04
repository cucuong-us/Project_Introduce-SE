package com.introduce_SE.demo.ClinicWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.introduce_SE.demo.ClinicWeb.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String>{
	
}
