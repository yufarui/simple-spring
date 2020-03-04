package yu.lifeCycle.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过 JSR250 规范提供的注解@PostConstruct 和@ProDestory标注的方法
 */
@Data
@Component
public class BeanC {

	private String name;
	private boolean active;

	public BeanC() {
		System.out.println("加载 BeanC");
	}

	@PostConstruct
	public void init() {
		this.name = "beanC";
		this.active = true;
		System.out.println(toString());
	}

	@PreDestroy
	public void destroy() {
		this.name = null;
		this.active = false;
		System.out.println(toString());
	}
}
