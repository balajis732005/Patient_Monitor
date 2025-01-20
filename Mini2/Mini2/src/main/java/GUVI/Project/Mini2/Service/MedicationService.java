package GUVI.Project.Mini2.Service;

import GUVI.Project.Mini2.Entity.Medication;
import GUVI.Project.Mini2.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    // Add a new medication
    public Medication addMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    // Get all medications by patient ID
    public List<Medication> getMedicationsByPatient(Long patientId) {
        return medicationRepository.findByPatientId(patientId);
    }

    // Get all medications for a specific patient
    public List<Medication> getMedicationsByPatientId(Long patientId) {
        return medicationRepository.findByPatientId(patientId);
    }

    // Update medication details
    public Medication updateMedication(Long id, Medication updatedMedication) {
        Medication medication = medicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Medication not found"));
        medication.setMedicineName(updatedMedication.getMedicineName());
        medication.setDosage(updatedMedication.getDosage());
        medication.setInstructions(updatedMedication.getInstructions());
        return medicationRepository.save(medication);
    }

    // Delete a medication
    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
