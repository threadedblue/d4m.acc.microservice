package d4m.acc.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"d4m.acc.microservice", "d4m.acc.access"})
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		log.debug("Start==>");
		SpringApplication.run(Application.class, args);
		log.debug("<==Stop");
	}	
}
