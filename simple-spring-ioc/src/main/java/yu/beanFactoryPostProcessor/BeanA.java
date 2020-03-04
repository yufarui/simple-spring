package yu.beanFactoryPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
	public BeanA() {
		System.out.println("加载 beanA");
	}
}
