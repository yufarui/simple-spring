package yu.problem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Autowired
    private BeanB beanB;

    // 循环引用的产生,让我们来看源码吧
}
