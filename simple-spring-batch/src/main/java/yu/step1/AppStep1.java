package yu.step1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"yu.step1"})
public class AppStep1 {
    public static void main(String[] args) {
        SpringApplication.run(AppStep1.class, args);
    }
}
