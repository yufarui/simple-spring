package yu.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    private BeanB beanB;

    public BeanA() {
    }

    @Autowired
    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}
