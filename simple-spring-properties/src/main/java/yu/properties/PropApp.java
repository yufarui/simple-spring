package yu.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"yu.properties"})
public class PropApp {
    public static void main(String[] args) {
        SpringApplication.run(PropApp.class, args);
    }
}
