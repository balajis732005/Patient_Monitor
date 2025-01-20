package GUVI.Project.Mini2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medication {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public @NotNull String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(@NotNull String medicineName) {
        this.medicineName = medicineName;
    }

    public @NotNull String getDosage() {
        return dosage;
    }

    public void setDosage(@NotNull String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull
    private String medicineName;

    @NotNull
    private String dosage;

    private String instructions;
}
