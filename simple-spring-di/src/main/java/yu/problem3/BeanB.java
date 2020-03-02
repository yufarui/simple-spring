package yu.problem3;

import org.springframework.stereotype.Component;

@Component
public class BeanB implements IBean {
    @Override
    public String test() {
        return "beanB";
    }
}
