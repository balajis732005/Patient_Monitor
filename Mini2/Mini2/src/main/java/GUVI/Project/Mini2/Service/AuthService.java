package GUVI.Project.Mini2.Service;

import GUVI.Project.Mini2.Entity.Doctor;
import GUVI.Project.Mini2.Entity.Patient;
import GUVI.Project.Mini2.Repository.DoctorRepository;
import GUVI.Project.Mini2.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public boolean loginAsPatient(String email, String password) {
        Patient patient = patientRepository.findByEmail(email);
        return patient != null && patient.getPassword().equals(password);
    }

    public boolean loginAsDoctor(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        return doctor != null && doctor.getPassword().equals(password);
    }

    public String logout() {
        // Clear session or authentication token if implemented
        return "Logout successful";
    }
}
