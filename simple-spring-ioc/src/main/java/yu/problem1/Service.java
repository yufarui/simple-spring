package yu.problem1;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {

    // 当我们将两个字段顺序改变后将不会再引起循环依赖
    @Autowired
    private BeanA beanA;
    @Autowired
    private BeanB beanB;
}
