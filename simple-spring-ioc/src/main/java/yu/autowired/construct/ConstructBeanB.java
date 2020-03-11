package yu.autowired.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructBeanB {
	private ConstructBeanA constructBeanA;

	@Autowired
	public ConstructBeanB(ConstructBeanA constructBeanA) {
		this.constructBeanA = constructBeanA;
	}
}
