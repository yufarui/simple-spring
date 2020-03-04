package yu.factoryBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FactoryBeanApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FactoryBeanApp.class, args);
		Object beanAFactoryBean = context.getBean("beanAFactoryBean");
		System.out.println(beanAFactoryBean);
		Object factoryBean = context.getBean("&beanAFactoryBean");
		System.out.println(factoryBean);
	}
}
