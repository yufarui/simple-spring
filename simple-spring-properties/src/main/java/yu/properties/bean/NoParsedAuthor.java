package yu.properties.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sources/author.properties")
public class NoParsedAuthor {
	@Value("author.name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SmallAuthor{" +
			"name='" + name + '\'' +
			'}';
	}
}
