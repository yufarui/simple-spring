package yu.lifeCycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yu.lifeCycle.model.BeanA;

@Configuration
public class Config {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public BeanA beanA() {
		return new BeanA();
	}

}
