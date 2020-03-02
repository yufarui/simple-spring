package yu.compentScanTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import yu.compentScanTest.config.MainConfig;

@SpringBootApplication
@Import({MainConfig.class})
@ComponentScan(useDefaultFilters = false)
public class CompentScanApp {
    public static void main(String[] args) {
        SpringApplication.run(CompentScanApp.class, args);
    }
}
