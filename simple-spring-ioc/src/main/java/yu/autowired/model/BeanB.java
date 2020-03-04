package yu.autowired.model;

public class BeanB {

	private BeanA beanA;

	public BeanB() {
	}

	public BeanB(BeanA beanA) {
		this.beanA = beanA;
		System.out.println("构造器注入");
	}

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
		System.out.println("set 方法注入");
	}

	@Override
	public String toString() {
		return "BeanB{" +
			"beanA=" + beanA +
			'}';
	}
}
