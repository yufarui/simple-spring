package yu.lifeCycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifeCycleApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LifeCycleApp.class, args);
	}
}
