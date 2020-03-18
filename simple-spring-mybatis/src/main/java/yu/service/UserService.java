package yu.service;

import java.util.List;

public interface UserService {

	void vaildLevelOneCahceWithTrans(Integer id);

	void vaildLevelOneCahceWithTrans(List<Integer> ids);
}
