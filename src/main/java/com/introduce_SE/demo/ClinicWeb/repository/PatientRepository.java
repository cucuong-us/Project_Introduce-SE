package com.introduce_SE.demo.ClinicWeb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.introduce_SE.demo.ClinicWeb.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	List<Patient> findByDate(LocalDate date);
}
