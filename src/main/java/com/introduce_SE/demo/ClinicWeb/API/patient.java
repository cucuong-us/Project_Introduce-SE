package com.introduce_SE.demo.ClinicWeb.API;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.introduce_SE.demo.ClinicWeb.dto.ExaminationResultsDTO;
import com.introduce_SE.demo.ClinicWeb.dto.InvoiceDTO;
import com.introduce_SE.demo.ClinicWeb.dto.PrescriptionDTO;
import com.introduce_SE.demo.ClinicWeb.dto.revenueDTO;
import com.introduce_SE.demo.ClinicWeb.model.Configuration;
import com.introduce_SE.demo.ClinicWeb.model.ExaminationResults;
import com.introduce_SE.demo.ClinicWeb.model.Medicine;
import com.introduce_SE.demo.ClinicWeb.model.Patient;
import com.introduce_SE.demo.ClinicWeb.model.Prescription;
import com.introduce_SE.demo.ClinicWeb.service.ConfigurationService;
import com.introduce_SE.demo.ClinicWeb.service.DiseaseService;
import com.introduce_SE.demo.ClinicWeb.service.ExaminationResultsService;
import com.introduce_SE.demo.ClinicWeb.service.MedicineService;
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
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private DiseaseService diseaseService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	//----------------------------------------------LAP DANH SACH BENH NHAN---------------------------------------------------------

	@PostMapping("/api/patients")
	public Patient addNewPatient(@RequestBody Patient patient){
		return patientService.addPatient(patient);
	}
	
	@GetMapping("/api/patients")
	public List<Patient> listPatients(@RequestParam LocalDate date) {
		return patientService.findByDate(date);
	}
	
	@DeleteMapping("/api/patients/{id}")
	public void deletePatient(@PathVariable int id) {
		patientService.deleteById(id);
	}
	
	
	
	
	//------------------------------------------------LAP PHIEU KHAM BENH---------------------------------------------------------
	
	
	@GetMapping("api/examinationResults/{id}")
	public ExaminationResultsDTO getExaminationResults(@PathVariable int id) {
		Optional<Patient> patient = patientService.findById(id);
		ExaminationResultsDTO erdto = new ExaminationResultsDTO();
		
		if(patient.isEmpty()) {
			return erdto;
		}
		erdto.setFullName(patient.get().getFullname());
		erdto.setDate(patient.get().getDate());
		
		Optional<ExaminationResults> er = examinationResultsService.findByID(id);
		if(er.isEmpty()) return erdto;
		
		erdto.setSymptom(er.get().getSymptom());
		erdto.setDisease(er.get().getDisease().getName());
		return erdto;
	}
	
	@PostMapping("api/examinationResults")
	public ExaminationResults addExaminationResults(@RequestBody ExaminationResults er) {
//		
// 		@RequestBody Map<String, Object> request
//		ExaminationResults er = new ExaminationResults();
		
//		int idPatient = request.getPatient().getId();
//		Optional<Patient> patient = patientService.findById(idPatient);
//		
//		if(patient.isEmpty()) {
//			return er;
//		}
//		er.setPatient(patient.get());
//		int idDisease = (int) request.get("disease");
//		System.out.println("Hello 2023");
//		System.out.println(idDisease);
//		Optional<Disease> disease = diseaseService.findById(idDisease);
//		System.out.println("Hello 2024");
//		
//		if(disease.isEmpty()) {
//			return er;
//		}
//		er.setDisease(disease.get());
//		String symptom = (String) request.get("symptom");
//		System.out.println(symptom);
//		
//		er.setSymptom(symptom);
		return examinationResultsService.addNewExaminationResults(er);
	}
	
	@GetMapping("api/prescriptions/{id}")
	public List<PrescriptionDTO> listMedicine(@PathVariable int id) {
		List<Prescription> ps = prescriptionService.findByPatientId(id);
		List<PrescriptionDTO> psdtos = new ArrayList<>(ps.size());
		for(int i = 0; i < ps.size(); i++) {
			PrescriptionDTO psdto = new PrescriptionDTO();
			
			psdto.setQuantity(ps.get(i).getQuantity());
			Optional<Medicine> medicine = medicineService.findById(ps.get(i).getMedicine().getIdMedicine());
			psdto.setNameOfMedicine(medicine.get().getNameOfMedicine());
			psdto.setUnit(medicine.get().getUnit());
			psdto.setMedicineUsage(medicine.get().getMedicineUsage());
			psdto.setPrice(medicine.get().getPrice());
			psdtos.add(psdto);
		}
		
		return psdtos;
	}
	
	@PostMapping("api/prescriptions")
	public Prescription addNewPrescription(@RequestBody Prescription prescription) {
		return prescriptionService.addNewPrecription(prescription);
	}
	
	@DeleteMapping("api/prescriptions")
	public void deletePrescription(@RequestBody Prescription prescription) {
		prescriptionService.deletePrescription(prescription);
	}
	
	
	//------------------------------------------------TRA CUU BENH NHAN---------------------------------------------------------
	
	
	
	@GetMapping("api/patients/search")
	public List<Patient> getPatient(@RequestParam(required=false) Integer id, 
	@RequestParam(required=false) String fullname, 
	@RequestParam(required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return patientService.searchPatients(id, fullname, date);
	}
	
	
	
	//------------------------------------------------LAP HOA DON THANH TOAN---------------------------------------------------------
	
	@GetMapping("api/invoice/{id}")
	public InvoiceDTO getInvoice(@PathVariable int id) {
		InvoiceDTO i = new InvoiceDTO();
		i.setExPrice(configurationService.findById(1).get().getExaminationPrice());
		i.setMedicinePrice(prescriptionService.medicinePrice(id));
		i.setTotal(i.getMedicinePrice()+i.getExPrice());
		return i;
	}
	
	//------------------------------------------------LAP BAO CAO THANG---------------------------------------------------------
	
	
	@GetMapping("api/report/revenue")
	public revenueDTO revenuePerDay(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate  date) {
		revenueDTO r = new revenueDTO();
		r.setDate(date);
		r.setNumberOfPatient(patientService.countByDate(date));
		Optional<Configuration> c = configurationService.findById(1);
		int exPrice = c.get().getExaminationPrice();
		float revenueDay = 0;
		if(r.getNumberOfPatient() != 0) {
			revenueDay = prescriptionService.revenuePerDay(date);
		}
		float revenueMonth = prescriptionService.revenuePerMonth(date);
		r.setRate(revenueDay/revenueMonth);
		revenueDay = revenueDay + exPrice*r.getNumberOfPatient();
		r.setRevenue(revenueDay);
		return r;
	}
}
