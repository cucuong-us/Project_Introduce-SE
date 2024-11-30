package com.introduce_SE.demo.ClinicWeb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.introduce_SE.demo.ClinicWeb.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{
	public List<Prescription> findByPatientId(int id);

	@Query(value="select sum(m.price*p.quantity) "
			+ "from clinicweb.prescription p "
			+ "join clinicweb.patient pa on pa.id_patient = p.id_patient "
			+ "join clinicweb.medicine m on p.id_medicine = m.id_medicine "
			+ "where pa.id_patient = :id "
			+ "group by pa.id_patient",
			nativeQuery = true)
	public float medicinePrice(@Param("id") int id);
	
	@Query(value="select ifnull(sum(m.price*p.quantity),0.0) "
			+ "from prescription p "
			+ "join patient pa on pa.id_patient = p.id_patient "
			+ "join medicine m on p.id_medicine = m.id_medicine "
			+ "where pa.date = :date "
			+ "group by pa.date",
			nativeQuery = true)
	public float revenuePerDay(@Param("date") LocalDate date);
	
	@Query(value="select sum(m.price*p.quantity) "
			+ "from prescription p "
			+ "join patient pa on pa.id_patient = p.id_patient "
			+ "join medicine m on p.id_medicine = m.id_medicine "
			+ "where month(pa.date) = month(:date) and year(pa.date) = year(:date) "
			+ "group by month(date), year(date)",
			nativeQuery = true)
	public float revenuePerMonth(@Param("date") LocalDate date);
	
}
