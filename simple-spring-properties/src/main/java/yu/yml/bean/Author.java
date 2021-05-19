package yu.yml.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import yu.yml.config.MixPropertySourceFactory;

import java.util.List;
import java.util.Map;

@PropertySource(value = "classpath:sources/author.yml", factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "yml.author")
@Component("ymlAuthor")
@Data
public class Author {
    private String name;
    private String sex;
    private String birth;
    private List<String> nickName;
    private Map<String, List<String>> test;
}
