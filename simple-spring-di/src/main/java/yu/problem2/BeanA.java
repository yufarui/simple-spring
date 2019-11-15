package yu.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    private BeanB beanB;

    public BeanA() {
    }

    // 可以 试试看将 @Autowired 放在参数上,是否会引起循环依赖
    public BeanA(@Autowired BeanB beanB) {
        this.beanB = beanB;
    }
}
