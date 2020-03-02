package yu.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private BeanA beanA;

    public BeanB() {
    }

    @Autowired
    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }
}
