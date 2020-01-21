package ldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yu.ldap.LDAPApp;
import yu.ldap.PersonRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LDAPApp.class)
public class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;

    @Test
    public void findAll() throws Exception {
        personRepo.findAll().forEach(person -> {
            System.out.println(person);
        });
    }

}
