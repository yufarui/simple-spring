package yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AsyncApp {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class);
    }
}
