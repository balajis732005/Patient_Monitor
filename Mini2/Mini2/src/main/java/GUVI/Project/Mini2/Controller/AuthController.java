package GUVI.Project.Mini2.Controller;

import GUVI.Project.Mini2.Dto.AuthRequest;
import GUVI.Project.Mini2.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login/patient")
    public ResponseEntity<String> loginAsPatient(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = authService.loginAsPatient(authRequest.getEmail(), authRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Patient login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password for patient");
        }
    }

    @PostMapping("/login/doctor")
    public ResponseEntity<String> loginAsDoctor(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = authService.loginAsDoctor(authRequest.getEmail(), authRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Doctor login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password for doctor");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        String message = authService.logout();
        return ResponseEntity.ok(message);
    }
}

