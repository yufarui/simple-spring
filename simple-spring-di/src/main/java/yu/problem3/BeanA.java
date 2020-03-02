package yu.problem3;

import org.springframework.stereotype.Component;

@Component
public class BeanA implements IBean {

    @Override
    public String test() throws Exception {
        Thread.sleep(2000);
        return "beanA";
    }
}
