package yu.step3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("step3")
@SpringBootApplication(scanBasePackages = {"yu.step3"})
public class AppStep3 {
    public static void main(String[] args) {
        SpringApplication.run(AppStep3.class, args);
    }
}
