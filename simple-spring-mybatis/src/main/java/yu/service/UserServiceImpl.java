package yu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.dao.UserDao;
import yu.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void vaildLevelOneCahceWithTrans(Integer id) {
		User user0 = userDao.findById(1);
		User user1 = userDao.findById(1);
		if(user0 == user1) {
			System.out.println("事务中使用了同一个session, 且一级缓存生效");
		}
	}

	@Override
	@Transactional
	public void vaildLevelOneCahceWithTrans(List<Integer> ids) {
		List<User> userList0 = userDao.findUserList(ids);
		List<User> userList1 = userDao.findUserList(ids);
		for (int i = 0; i < userList0.size(); i++) {
			System.out.println(userList0.get(i) == userList1.get(i));
		}
	}
}
