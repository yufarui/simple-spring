package yu.aopChain.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import yu.aopChain.bussiness.IBussiness;
import yu.aopChain.parser.VerfiyParser;

import java.lang.reflect.Proxy;

@Component
public class AOPChainBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private VerfiyParser defaultVerfiyParser;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("bussiness")) {
			defaultVerfiyParser.setTargetBean(bean);
			return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IBussiness.class}, defaultVerfiyParser);
		}
		return bean;
	}
}
