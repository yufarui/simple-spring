package yu.problem3;

import org.springframework.stereotype.Component;

@Component
public class ABCBean implements IBean {
    @Override
    public String test() {
        return "ABCBean";
    }
}
