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
public class Doctor {
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

    public @NotNull @Size(min = 2, max = 100) String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(@NotNull @Size(min = 2, max = 100) String specialization) {
        this.specialization = specialization;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Size(min = 2, max = 100)
    private String specialization;

    @NotNull
    @Size(min = 5, max = 100)
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    private String password;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;  // Add this relationship
}

