package yu.problem3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class Config {
    @Autowired
    private List<IBean> iBeans;
    // 试试这个
    // private Map<String, IBean> iBeans;

    @PostConstruct
    public void init() {
        System.out.println(iBeans.size());
    }
}
