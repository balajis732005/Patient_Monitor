package GUVI.Project.Mini2.Controller;

import GUVI.Project.Mini2.Entity.Doctor;
import GUVI.Project.Mini2.Entity.Patient;
import GUVI.Project.Mini2.Service.DoctorService;
import GUVI.Project.Mini2.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    // Get all patients
    @GetMapping("get-all-patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    // Register new patient
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@Valid @RequestBody Patient patient) {
        Patient newPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    // Update patient details
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @Valid @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatientProfile(id, patient);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    // Delete patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization) {

        List<Doctor> doctors = doctorService.searchDoctors(name, specialization);
        return ResponseEntity.ok(doctors);
    }

}

