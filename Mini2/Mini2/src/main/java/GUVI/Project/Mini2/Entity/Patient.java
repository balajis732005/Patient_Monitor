package GUVI.Project.Mini2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 2, max = 100) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 2, max = 100) String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 5, max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Size(min = 5, max = 100) String email) {
        this.email = email;
    }

    public @NotNull @Size(min = 10, max = 15) String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull @Size(min = 10, max = 15) String phone) {
        this.phone = phone;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Size(min = 5, max = 100)
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    @NotNull
    private String password;

    @Column(name = "medical_history", length = 1000)
    private String medicalHistory;

    // Relationships
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<Medication> medications;
}
