package yu.problem3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Config {
    @Autowired
    private List<IBean> iBeans;

    @PostConstruct
    public void init() {
        System.out.println(iBeans.size());
    }
}
