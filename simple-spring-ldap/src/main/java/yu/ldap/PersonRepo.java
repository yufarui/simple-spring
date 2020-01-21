package yu.ldap;

import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;

public interface PersonRepo extends CrudRepository<Person, Name> {

}
