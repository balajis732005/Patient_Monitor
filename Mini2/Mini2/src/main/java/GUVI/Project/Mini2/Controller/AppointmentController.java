package GUVI.Project.Mini2.Controller;

import GUVI.Project.Mini2.Entity.Appointment;
import GUVI.Project.Mini2.Service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patientId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Get appointments by doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Book an appointment
    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        Appointment bookedAppointment = appointmentService.bookAppointment(appointment);
        return new ResponseEntity<>(bookedAppointment, HttpStatus.CREATED);
    }

    // Cancel an appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

