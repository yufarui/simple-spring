package yu.step1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 想要启动自动执行,做如下修改 spring.profiles.active = switchon
@SpringBootApplication(scanBasePackages = {"yu.step1"})
public class AppStep1 {
    public static void main(String[] args) {
        SpringApplication.run(AppStep1.class, args);
    }
}
