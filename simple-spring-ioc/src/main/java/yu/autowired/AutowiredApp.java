package yu.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutowiredApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AutowiredApp.class, args);
		Object beanB = context.getBean("beanC");
		Object beanC1 = context.getBean("beanC1");
		Object beanC2 = context.getBean("beanC2");
	}
}
