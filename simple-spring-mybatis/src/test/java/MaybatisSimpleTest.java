import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yu.MybatisApp;
import yu.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisApp.class})
public class MaybatisSimpleTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testBase() {
		System.out.println(userDao.findById(1));
	}

	@Test
	public void testTypeHandler() {
		System.out.println(userDao.findTypeUserById(1));
	}

	@Test
	public void testMultiParam() {
		System.out.println(userDao.findByMultiParam(1, "zhangsan", 12));
	}
}
