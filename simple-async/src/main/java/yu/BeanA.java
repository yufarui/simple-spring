package yu;

import org.springframework.stereotype.Component;

@Component("beanA")
public class BeanA implements IBean {

    @Override
    public String test() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        return "beanA";
    }
}
