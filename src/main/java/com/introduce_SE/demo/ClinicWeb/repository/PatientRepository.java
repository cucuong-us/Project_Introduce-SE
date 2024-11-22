package com.introduce_SE.demo.ClinicWeb.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	public List<Patient> findByDate(LocalDate date);
	public Optional<Patient> findByIdPatient(int id);
}
