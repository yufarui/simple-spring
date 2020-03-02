package yu.beanScope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import yu.beanScope.bean.PrototypeBean;
import yu.beanScope.bean.SingletonBean;
import yu.beanScope.bean.SingletonLazyBean;

@Configuration
public class Config {

	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}

	@Bean
	@Scope(value = "prototype")
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}

	@Bean
	@Lazy
	public SingletonLazyBean singletonLazyBean() {
		return new SingletonLazyBean();
	}
}
