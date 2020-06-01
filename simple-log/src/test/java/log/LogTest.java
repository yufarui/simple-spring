package log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yu.LogApp;
import yu.logfactory.LoggerFactoryBean;
import yu.lombok.LogBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LogApp.class})
public class LogTest {

    @Autowired
    private LogBean logBean;

    @Autowired
    private LoggerFactoryBean logFactoryBean;

    @Test
    public void testLombok() {
        logBean.logAllLevel();
    }

    @Test
    public void testLogFactory() {
        logFactoryBean.logAlllevel();
    }
}
