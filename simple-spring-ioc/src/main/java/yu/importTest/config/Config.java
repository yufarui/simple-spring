package yu.importTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yu.importTest.model.BeanA;

@Configuration
@Import(value = {BeanA.class, MyImportSelector.class, MyBeanDefinitionRegistrar.class})
public class Config {
}
