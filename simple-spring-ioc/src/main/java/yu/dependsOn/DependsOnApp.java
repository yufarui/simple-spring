package yu.dependsOn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	}
}
