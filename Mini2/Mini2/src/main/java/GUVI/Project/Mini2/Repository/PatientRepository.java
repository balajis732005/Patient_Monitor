package GUVI.Project.Mini2.Repository;



import GUVI.Project.Mini2.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Custom queries can be added here if needed
    Patient findByEmail(String email); // Example: Find patient by email for login
}
