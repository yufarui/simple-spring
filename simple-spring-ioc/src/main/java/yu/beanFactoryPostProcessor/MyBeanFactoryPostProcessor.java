package yu.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/**
	 * 执行时间:所有的Bean定义信息已经加载到容器中，但是Bean实例还没有被初始化.
	 * @param configurableListableBeanFactory
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		System.out.println("IOC 容器调用了 myPostProcessBeanFactory方法");
		for (String name : configurableListableBeanFactory.getBeanDefinitionNames()) {
			if ("beanA".equals(name)) {
				BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
				beanDefinition.setLazyInit(true);
			}
		}
	}
}
