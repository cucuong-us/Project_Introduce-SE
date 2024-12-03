package com.introduce_SE.demo.ClinicWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.model.Medicine;
import com.introduce_SE.demo.ClinicWeb.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	public Optional<Medicine> findById(int id_medicine) {
		return medicineRepository.findById(id_medicine);
	}
	
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}
	
	public Medicine save(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	public void deleteById(int id) {
		medicineRepository.deleteById(id);
	}
	
	public Medicine updateById(int id, Medicine medicine) {
		Optional<Medicine> m = medicineRepository.findById(id);
		if(m.isEmpty()) {
			return m.get();
		}
		
		if(medicine.getNameOfMedicine() != null) 
			m.get().setNameOfMedicine(medicine.getNameOfMedicine());
		
		if(medicine.getMedicineUsage() != null)
			m.get().setMedicineUsage(medicine.getMedicineUsage());
		
		if(medicine.getPrice() != 0) 
			m.get().setPrice(medicine.getPrice());
		
		if(medicine.getUnit() != null)
			m.get().setUnit(medicine.getUnit());
		
		return medicineRepository.save(m.get());
	}
}
