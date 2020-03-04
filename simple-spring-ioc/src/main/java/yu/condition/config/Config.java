package yu.condition.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yu.condition.model.Animal;
import yu.condition.model.Food;

@Configuration
public class Config {

	//	@Bean
	public Food food() {
		return new Food();
	}

	@Bean
	@ConditionalOnBean(name = {"food"})
	public Animal animal() {
		return new Animal();
	}
}
