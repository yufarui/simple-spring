package yu.yml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import yu.yml.bean.Author;

import javax.annotation.PostConstruct;

@Configuration
public class YmlConfig {

    @Autowired
    private Author ymlAuthor;

    @Value("${yml.author.name}")
    private String authorName;

    @Value("${app.name}")
    private String appName;

    @PostConstruct
    public void init() {

        System.out.println(authorName);
        System.out.println(ymlAuthor);
        System.out.println(appName);
    }
}
