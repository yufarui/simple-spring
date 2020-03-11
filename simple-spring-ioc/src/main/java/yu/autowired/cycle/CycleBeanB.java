package yu.autowired.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CycleBeanB {
	@Autowired
	private CycleBeanA cycleBeanA;
}
