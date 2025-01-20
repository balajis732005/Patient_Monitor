package GUVI.Project.Mini2.Repository;

import GUVI.Project.Mini2.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientId(Long patientId); // Find appointments by patient ID
    List<Appointment> findByDoctorId(Long doctorId); // Find appointments by doctor ID
}

