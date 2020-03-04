package yu.factoryBean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public BeanAFactoryBean beanAFactoryBean() {
		return new BeanAFactoryBean();
	}
}
