import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yu.MybatisApp;
import yu.dao.UserDao;
import yu.model.User;
import yu.service.UserService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisApp.class})
public class MybatisCacheTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@Test
	public void testLevelOneCahce() {
		userService.vaildLevelOneCahceWithTrans(1);
	}

	@Test
	public void testLevelOneCahceWithList() {
		userService.vaildLevelOneCahceWithTrans(Arrays.asList(1, 2));
	}

	@Test
	public void testLevelTwoCahce() {
		User user1 = userDao.findById(1);
		User user2 = userDao.findById(1);
	}
}
