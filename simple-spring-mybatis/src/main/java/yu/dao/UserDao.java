package yu.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import yu.model.TypeHandlerUser;
import yu.model.User;

import java.util.List;

@Mapper
@CacheNamespace
public interface UserDao {

	@Select("select * from user where id = #{id}")
	User findById(Integer id);

	@Select("select * from user where id = #{param1} and name = #{param2} and age = #{param3}")
	User findByMultiParam(Integer id, String name, Integer age);

	TypeHandlerUser findTypeUserById(Integer id);

	List<User> findUserList(@Param("ids") List<Integer> ids);
}
