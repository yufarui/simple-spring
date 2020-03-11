package yu.autowired.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanA {
	private String name;
	@Autowired
	private BeanC beanC;
}
