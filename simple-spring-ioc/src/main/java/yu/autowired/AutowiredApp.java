package yu.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutowiredApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AutowiredApp.class, args);
		Object beanB = context.getBean("beanB");
		System.out.println(beanB);
	}
}
