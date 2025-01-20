package GUVI.Project.Mini2.Service;


import GUVI.Project.Mini2.Entity.Appointment;
import GUVI.Project.Mini2.Entity.Doctor;
import GUVI.Project.Mini2.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;


    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);  // Return null if doctor not found
    }

    // Register a new doctor
    public Doctor registerDoctor(Doctor doctor) {
//        String hashedPassword = passwordEncoder.encode(doctor.getPassword());
//        doctor.setPassword(hashedPassword);
        return doctorRepository.save(doctor);
    }

    // Update doctor details
    public Doctor updateDoctor(Long id, Doctor doctor) {
        if (doctorRepository.existsById(id)) {
            doctor.setId(id);
            return doctorRepository.save(doctor);
        }
        return null;  // Return null if doctor doesn't exist
    }

    // Find a doctor by email (for login)
    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    // Get all appointments for a specific doctor
    public List<Appointment> getDoctorAppointments(Long doctorId) {
        return doctorRepository.findById(doctorId).get().getAppointments();
    }

    // Get doctor profile details
    public Doctor getDoctorProfile(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    // Delete doctor
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    // Search by name
    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    // Search by specialization
    public List<Doctor> searchDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
    }

    // Search by location
    public List<Doctor> searchDoctorsByLocation(String location) {
        return doctorRepository.findByLocationContainingIgnoreCase(location);
    }

    // Search by name and specialization
    public List<Doctor> searchDoctorsByNameAndSpecialization(String name, String specialization) {
        return doctorRepository.findByNameContainingIgnoreCaseAndSpecializationContainingIgnoreCase(name, specialization);
    }

    public List<Doctor> searchDoctors(String name, String specialization) {
        return doctorRepository.searchDoctors(name, specialization);
    }
}
