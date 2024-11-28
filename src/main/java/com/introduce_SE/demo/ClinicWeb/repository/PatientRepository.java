package com.introduce_SE.demo.ClinicWeb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public List<Patient> findByDate(LocalDate date);

	@Query("SELECT p FROM Patient p WHERE " +
		       "(:id IS NOT NULL AND CAST(p.idPatient AS string) LIKE %:id% OR :id IS NULL) AND " +
		       "(:fullname IS NOT NULL AND p.fullname LIKE %:fullname% OR :fullname IS NULL) AND " +
		       "(:date IS NOT NULL AND p.date = :date OR :date IS NULL)")
	public List<Patient> searchPatients(@Param("id") Integer id,
            @Param("fullname") String fullname,
            @Param("date") LocalDate date);
	
	public int countByDate(LocalDate date);
}
