package com.introduce_SE.demo.ClinicWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Integer>{
	
}
