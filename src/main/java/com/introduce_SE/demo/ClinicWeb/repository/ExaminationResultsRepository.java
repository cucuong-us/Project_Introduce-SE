package com.introduce_SE.demo.ClinicWeb.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;

@Repository
public interface ExaminationResultsRepository extends JpaRepository<ExaminationResults, Integer> {
	public Optional<ExaminationResults> findByPatientId(int idPatient);
	
	@Query(value="select p.id_patient, p.date, p.address, p.fullname, p.sex, p.year_of_birth "
			+ "from examination_results er "
			+ "join patient p on er.patient = p.id_patient "
			+ "join prescription pr on pr.id_patient = er.patient "
			+ "where p.date = :date",
			nativeQuery=true)
	public List<Object[]> getExaminedPatients(@Param("date") LocalDate date);
}
