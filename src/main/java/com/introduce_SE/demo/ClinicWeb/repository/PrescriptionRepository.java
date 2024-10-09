package com.introduce_SE.demo.ClinicWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, String>{
	
	public List<Prescription> findById_Id(String id);
}
