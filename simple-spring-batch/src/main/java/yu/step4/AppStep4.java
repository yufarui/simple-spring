package yu.step4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * 主要介绍 step流程 控制
 */
@Profile("switchoff")
@SpringBootApplication(scanBasePackages = {"yu.step4"})
public class AppStep4 {
    public static void main(String[] args) {
        SpringApplication.run(AppStep4.class, args);
    }
}
