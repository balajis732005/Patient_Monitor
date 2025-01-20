package GUVI.Project.Mini2.Controller;

import GUVI.Project.Mini2.Entity.Medication;
import GUVI.Project.Mini2.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    // Get all medications for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Medication>> getMedicationsByPatient(@PathVariable Long patientId) {
        List<Medication> medications = medicationService.getMedicationsByPatient(patientId);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    // Add new medication for a patient
    @PostMapping("/add")
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {
        Medication newMedication = medicationService.addMedication(medication);
        return new ResponseEntity<>(newMedication, HttpStatus.CREATED);
    }

    // Update medication details
    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable Long id, @RequestBody Medication medication) {
        Medication updatedMedication = medicationService.updateMedication(id, medication);
        return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
    }

    // Delete medication
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

