package yu.factoryBean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yu.factoryBean.model.BeanA;


@Configuration
public class Config {

	@Autowired
	private BeanA beanAFactoryBean;
}
