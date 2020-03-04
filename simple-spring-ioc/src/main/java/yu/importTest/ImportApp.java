package yu.importTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ImportApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ImportApp.class, args);
	}
}
