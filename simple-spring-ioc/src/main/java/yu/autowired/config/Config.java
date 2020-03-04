package yu.autowired.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yu.autowired.model.BeanB;

@Configuration
public class Config {

	@Bean(autowire = Autowire.BY_TYPE)
	public BeanB beanB() {
		return new BeanB();
	}
}
