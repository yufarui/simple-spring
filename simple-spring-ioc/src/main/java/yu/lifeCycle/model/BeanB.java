package yu.lifeCycle.model;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanB implements InitializingBean, DisposableBean {

	private String name;
	private boolean active;

	public BeanB() {
		System.out.println("加载 BeanB");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.name = "beanB";
		this.active = true;
		System.out.println(toString());
	}

	@Override
	public void destroy() throws Exception {
		this.name = null;
		this.active = false;
		System.out.println(toString());
	}
}
