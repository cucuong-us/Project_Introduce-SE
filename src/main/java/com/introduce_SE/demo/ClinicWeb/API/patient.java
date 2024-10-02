package com.introduce_SE.demo.ClinicWeb.API;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.introduce_SE.demo.ClinicWeb.model.Patient;
import com.introduce_SE.demo.ClinicWeb.service.PatientService;

@RestController
public class patient {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/api/add-patient")
	public Patient addNewPatient(@RequestBody Patient patient){
		return patientService.addPatient(patient);
	}
	
	
	@GetMapping("/api/list-patient")
	public List<Patient> listPatient(ModelMap model) {
		return patientService.findByDate(LocalDate.now());
	}
}
