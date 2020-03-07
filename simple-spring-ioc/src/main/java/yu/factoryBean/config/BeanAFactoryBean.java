package yu.factoryBean.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import yu.factoryBean.model.BeanA;

@Component
public class BeanAFactoryBean implements FactoryBean<BeanA> {

	@Override
	public BeanA getObject() throws Exception {
		// 填充BeanA 属性
		return new BeanA();
	}

	@Override
	public Class<BeanA> getObjectType() {
		return BeanA.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
