package yu.beanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	}
}
