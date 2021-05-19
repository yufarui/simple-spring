package yu.autowired.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yu.autowired.model.BeanB;
import yu.autowired.model.BeanC;

@Configuration
public class Config {

	@Bean(autowire = Autowire.BY_TYPE)
	public BeanB beanB() {
		return new BeanB();
	}

	@Bean
	public BeanC beanC() {
		return new BeanC();
	}

	@Bean
	public BeanC beanC1() {
		System.out.println(beanC());
		return new BeanC();
	}

	@Bean
	public BeanC beanC2() {
		System.out.println(beanC());
		return new BeanC();
	}
}
