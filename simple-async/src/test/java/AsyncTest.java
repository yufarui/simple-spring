import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yu.AsyncApp;
import yu.IBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AsyncApp.class})
public class AsyncTest {

    @Autowired
    private IBean beanA;

    @Test
    public void test() {
        System.out.println(beanA.test());
    }
}
