package yu.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Config {

	@Bean
	public ModelA modelA() {
		return new ModelA();
	}

	@Bean
	@DependsOn({"modelA"})
	public ModelB modelB() {
		return new ModelB();
	}
}
