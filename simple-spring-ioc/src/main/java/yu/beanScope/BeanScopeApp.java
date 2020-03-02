package yu.beanScope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import yu.beanScope.config.Config;

@SpringBootApplication
public class BeanScopeApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Config.class, args);
		Object prototypeBean1 = context.getBean("prototypeBean");
		Object prototypeBean2 = context.getBean("prototypeBean");
		System.out.println(prototypeBean1 != prototypeBean2);
		Object singletonLazyBean1 = context.getBean("singletonLazyBean");
		Object singletonLazyBean2 = context.getBean("singletonLazyBean");
		System.out.println(singletonLazyBean1 == singletonLazyBean2);
	}
}
