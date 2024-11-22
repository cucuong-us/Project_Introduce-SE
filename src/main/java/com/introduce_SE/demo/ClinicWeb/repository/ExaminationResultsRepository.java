package com.introduce_SE.demo.ClinicWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;

@Repository
public interface ExaminationResultsRepository extends JpaRepository<ExaminationResults, Integer> {
	public List<ExaminationResults> findByPatientId(int idPatient);
}
