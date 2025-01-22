package GUVI.Project.Mini2.Controller;

import GUVI.Project.Mini2.Entity.Doctor;
import GUVI.Project.Mini2.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors
    @GetMapping("/get-all-doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    // Register new doctor
    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.registerDoctor(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }

    // Update doctor details
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    // Delete doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Search doctors by name
    @GetMapping("/search/by-name")
    public List<Doctor> searchDoctorsByName(@RequestParam String name) {
        return doctorService.searchDoctorsByName(name);
    }

    // Search doctors by specialization
    @GetMapping("/search/by-specialization")
    public List<Doctor> searchDoctorsBySpecialization(@RequestParam String specialization) {
        return doctorService.searchDoctorsBySpecialization(specialization);
    }

    // Search doctors by location
    @GetMapping("/search/by-location")
    public List<Doctor> searchDoctorsByLocation(@RequestParam String location) {
        return doctorService.searchDoctorsByLocation(location);
    }

    // Search doctors by name and specialization
    @GetMapping("/search/by-name-and-specialization")
    public List<Doctor> searchDoctorsByNameAndSpecialization(
            @RequestParam String name,
            @RequestParam String specialization) {
        return doctorService.searchDoctorsByNameAndSpecialization(name, specialization);
    }
}
