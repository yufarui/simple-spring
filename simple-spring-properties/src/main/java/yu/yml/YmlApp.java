package yu.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"yu.yml"})
public class YmlApp {
    public static void main(String[] args) {
        SpringApplication.run(YmlApp.class, args);
    }
}
