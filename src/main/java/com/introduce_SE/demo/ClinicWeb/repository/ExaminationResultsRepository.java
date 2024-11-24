package com.introduce_SE.demo.ClinicWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;

@Repository
public interface ExaminationResultsRepository extends JpaRepository<ExaminationResults, Integer> {
	public Optional<ExaminationResults> findByPatientId(int idPatient);
}
