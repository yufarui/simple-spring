package yu.autowired.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructBeanA {
	@Autowired
	public ConstructBeanA() {
	}
}
