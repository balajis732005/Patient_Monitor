package GUVI.Project.Mini2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This will resolve to src/main/resources/templates/login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // This will resolve to src/main/resources/templates/register.html
    }
}

