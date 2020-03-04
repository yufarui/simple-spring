package yu.beanDefinitionRegistryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionRegistryPostProcessorApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	}
}
