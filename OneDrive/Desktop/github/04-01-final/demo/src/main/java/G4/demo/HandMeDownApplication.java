package G4.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class HandMeDownApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandMeDownApplication.class, args);
	}

}
