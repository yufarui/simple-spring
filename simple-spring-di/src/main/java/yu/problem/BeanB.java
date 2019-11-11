package yu.problem;

import org.springframework.beans.factory.annotation.Autowired;


public class BeanB {
    @Autowired
    private BeanA beanA;
}
