package yu.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class Config {

	@Bean
	public Calculate aopCalculate() {
		return new MyCalculate();
	}

	@Bean
	public MyLogAspect aopLogAspect() {
		return new MyLogAspect();
	}
}
