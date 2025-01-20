package GUVI.Project.Mini2.Service;

import GUVI.Project.Mini2.Entity.Appointment;
import GUVI.Project.Mini2.Entity.Medication;
import GUVI.Project.Mini2.Entity.Patient;
import GUVI.Project.Mini2.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    // Register a new patient
    public Patient registerPatient(Patient patient) {
//        String hashedPassword = passwordEncoder.encode(patient.getPassword());
//        patient.setPassword(hashedPassword);
        return patientRepository.save(patient);
    }

    // Find a patient by email (for login)
    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);  // Return null if patient not found
    }
    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Update patient profile
    public Patient updatePatientProfile(Long patientId, Patient updatedPatient) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setName(updatedPatient.getName());
        patient.setPhone(updatedPatient.getPhone());
        patient.setMedicalHistory(updatedPatient.getMedicalHistory());
        return patientRepository.save(patient);
    }

    // Get all appointments for a specific patient
    public List<Appointment> getPatientAppointments(Long patientId) {
        return patientRepository.findById(patientId).get().getAppointments();
    }

    // Get all medications for a specific patient
    public List<Medication> getPatientMedications(Long patientId) {
        return patientRepository.findById(patientId).get().getMedications();
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
