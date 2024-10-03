package com.introduce_SE.demo.ClinicWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.introduce_SE.demo.ClinicWeb.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, String>{
	
	public List<Prescription> findByprescriptionId_Id(String id);
}
