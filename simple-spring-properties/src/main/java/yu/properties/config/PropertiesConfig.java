package yu.properties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import yu.properties.bean.Author;

import javax.annotation.PostConstruct;

@Configuration
public class PropertiesConfig {

    @Autowired
    private Author author;

    @Value("${author.name}")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(author);
    }
}
