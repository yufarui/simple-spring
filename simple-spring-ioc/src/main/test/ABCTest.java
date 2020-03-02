import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yu.problem3.Application;
import yu.problem3.IBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ABCTest {

    @Autowired
    private IBean beanA;

    @Test
    public void hello() throws Exception {
        System.out.println("start test");
        System.out.println(beanA.test());
        System.out.println("test end");
        Thread.sleep(3000);
        System.out.println("all end");
    }
}
