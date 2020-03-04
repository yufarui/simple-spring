package yu.beanFactoryPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
	public BeanB() {
		System.out.println("加载 beanB");
	}
}
