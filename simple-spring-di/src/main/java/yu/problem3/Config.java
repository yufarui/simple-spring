package yu.problem3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@EnableAsync
@Component
public class Config {
    @Autowired
    private Map<String, IBean> iBeans;
    // 试试这个
    // private List<IBean> iBeans;

    @PostConstruct
    public void init() {
        // debug 时会发现 ABCBean 的beanName 就是 ABCBean
        // 而其他 则是 beanA,beanB
        System.out.println(iBeans.size());
    }
}
