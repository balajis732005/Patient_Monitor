package GUVI.Project.Mini2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "PATIENT MEDICINE & APPOINTMENT APPLICATION - GUVI MINI PROJECT 2 ",
				description = "Spring boot API doc to handle patient,Doctor operations",
				version = "1.0",
				contact = @Contact(
						name = "PRANAV VISHAL",
						email = "pranav13vishal@gmail.com"
				)
		)
)
@SpringBootApplication
public class Mini2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mini2Application.class, args);
	}

}
