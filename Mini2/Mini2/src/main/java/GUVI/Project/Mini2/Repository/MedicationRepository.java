package GUVI.Project.Mini2.Repository;

import GUVI.Project.Mini2.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByPatientId(Long patientId); // Find medications by patient ID
}
