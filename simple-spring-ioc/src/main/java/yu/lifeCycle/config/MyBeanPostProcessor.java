
package yu.lifeCycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().getName().startsWith("yu.lifeCycle.model")) {
			System.out.println("后置处理器开始行动" + bean.getClass().getSimpleName());
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().getName().startsWith("yu.lifeCycle.model")) {
			System.out.println("后置处理器行动结束" + bean.getClass().getSimpleName());
		}
		return bean;
	}

}