package yu.lifeCycle.model;

import lombok.Data;

@Data
public class BeanA {

	private String name;
	private boolean active;

	public BeanA() {
		System.out.println("加载 BeanA");
	}

	public void init() {
		this.name = "beanA";
		this.active = true;
		System.out.println(toString());
	}

	public void destroy() {
		this.name = null;
		this.active = false;
		System.out.println(toString());
	}
}
