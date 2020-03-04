package yu.properties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import yu.properties.bean.Author;
import yu.properties.bean.Book;
import yu.properties.bean.NoParsedAuthor;

import javax.annotation.PostConstruct;

@Configuration
public class PropertiesConfig {

    @Autowired
    private Author author;

    @Autowired(required = false)
    private Book book;

    @Value("${unknow:187}")
    private String unknow;

    @Value("${xxx:unknow}")
    private String xxx;

    @Autowired
    private NoParsedAuthor noParsedAuthor;

    @PostConstruct
    public void init() {
        System.out.println(unknow);
        System.out.println(author);
        System.out.println(book);
        System.out.println(xxx);
        System.out.println(noParsedAuthor);
    }
}
