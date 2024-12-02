package com.introduce_SE.demo.ClinicWeb.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.dto.MedicineDTO;
import com.introduce_SE.demo.ClinicWeb.model.Prescription;
import com.introduce_SE.demo.ClinicWeb.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public List<Prescription>  findByPatientId(int idPatient) {
		return prescriptionRepository.findByPatientId(idPatient);
	}
	
	public Prescription addNewPrecription(Prescription p) {
		return prescriptionRepository.save(p);
	}
	
	public void deletePrescription(Prescription p) {
		prescriptionRepository.deleteById(p.getId());
	}	
	
	public float revenuePerDay(LocalDate date) {
		return prescriptionRepository.revenuePerDay(date);
	}
	
	public float revenuePerMonth(LocalDate date) {
		return prescriptionRepository.revenuePerMonth(date);
	}
	
	public float medicinePrice(int id) {
		return prescriptionRepository.medicinePrice(id);
	}
	
	public List<MedicineDTO> revenueMedicine(@Param("date") LocalDate date) {
		List<Object[]> results = prescriptionRepository.revenueMedicine(date);
		List<MedicineDTO> m = new ArrayList<>();
		
		for (Object[] result : results) {
	        String name = (String) result[0];
	        String unit = (String) result[1];
	        Long quantity = (Long) result[2];
	        Long numberOfUse = (Long) result[3];
	        
	        MedicineDTO dto = new MedicineDTO(name, unit, quantity, numberOfUse);
	        m.add(dto);
	    }
	    
	    return m;
	}
}
