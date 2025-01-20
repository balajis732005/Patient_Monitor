package GUVI.Project.Mini2.Repository;

import GUVI.Project.Mini2.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Custom queries can be added here if needed
    Doctor findByEmail(String email); // Example: Find doctor by email for login

    @Query("SELECT d FROM Doctor d WHERE " +
            "(:name IS NULL OR d.name LIKE %:name%) AND " +
            "(:specialization IS NULL OR d.specialization LIKE %:specialization%)")
    List<Doctor> searchDoctors(
            @Param("name") String name,
            @Param("specialization") String specialization
    );
    // Search by name
    List<Doctor> findByNameContainingIgnoreCase(String name);

    // Search by specialization
    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);

    // Search by location
    List<Doctor> findByLocationContainingIgnoreCase(String location);

    // Search by name and specialization
    List<Doctor> findByNameContainingIgnoreCaseAndSpecializationContainingIgnoreCase(String name, String specialization);

}
