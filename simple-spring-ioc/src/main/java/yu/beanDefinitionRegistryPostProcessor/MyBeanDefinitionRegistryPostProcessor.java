package yu.beanDefinitionRegistryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	/**
	 * 执行时机:所有的bean定义信息将要被加载到容器中，Bean实例还没有被初始化。
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
		System.out.println("myPostProcessBeanDefinitionRegistry start");
		System.out.println("bean定义的数据量:" + beanDefinitionRegistry.getBeanDefinitionCount());
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(BeanA.class);
		beanDefinitionRegistry.registerBeanDefinition("beanA", rootBeanDefinition);
	}

	/**
	 * 执行时间:所有的Bean定义信息已经加载到容器中，但是Bean实例还没有被初始化.
	 *
	 * @param configurableListableBeanFactory
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		System.out.println("myPostProcessBeanFactory start");
		System.out.println(configurableListableBeanFactory.getBeanDefinitionCount());
	}
}
