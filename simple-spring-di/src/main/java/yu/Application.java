package yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import yu.problem.BeanB;
import yu.problem.Config;
import yu.problem.Service;

@SpringBootApplication
@Import({Service.class, Config.class, BeanB.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
