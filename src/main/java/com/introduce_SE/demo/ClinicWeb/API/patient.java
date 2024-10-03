package com.introduce_SE.demo.ClinicWeb.API;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.introduce_SE.demo.ClinicWeb.dto.ExaminationResultsDTO;
import com.introduce_SE.demo.ClinicWeb.dto.PrescriptionDTO;
import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;
import com.introduce_SE.demo.ClinicWeb.model.Patient;
import com.introduce_SE.demo.ClinicWeb.service.ExaminationResultsService;
import com.introduce_SE.demo.ClinicWeb.service.PatientService;
import com.introduce_SE.demo.ClinicWeb.service.PrescriptionService;

@RestController
public class patient {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ExaminationResultsService examinationResultsService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@PostMapping("/api/patient")
	public Patient addNewPatient(@RequestBody Patient patient){
		return patientService.addPatient(patient);
	}
	
	@GetMapping("/api/patients")
	public List<Patient> listPatient() {
		return patientService.findByDate(LocalDate.now());
	}
	
	@GetMapping("api/examinationResults/{id}")
	public ExaminationResultsDTO getExaminationResults(@PathVariable String id) {
		Optional<Patient> patient = patientService.findById(id);
		ExaminationResultsDTO erdto = new ExaminationResultsDTO();
		
		if(patient.isEmpty()) {
			return erdto;
		}
		erdto.setFullName(patient.get().getFullname());
		
		Optional<ExaminationResults> er = examinationResultsService.findByID(id);
		if(er.isEmpty()) return erdto;
		
		erdto.setSymptom(er.get().getSymptom());
		erdto.setDisease(er.get().getDisease());
		return erdto;
	}
}
