package yu.importTest.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import yu.importTest.model.BeanC;

public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//创建一个bean定义对象
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(BeanC.class);
		// 把bean定义对象导入到容器中
		registry.registerBeanDefinition("beanC", rootBeanDefinition);
	}
}
