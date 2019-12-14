package yu.step2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@SpringBootApplication(scanBasePackages = {"yu.step2"})
public class AppStep2 {
    public static void main(String[] args) {
        SpringApplication.run(AppStep2.class, args);
    }
}
