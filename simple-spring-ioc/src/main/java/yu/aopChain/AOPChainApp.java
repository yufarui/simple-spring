package yu.aopChain;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yu.aopChain.bussiness.IBussiness;

@SpringBootApplication
public class AOPChainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPChainApp.class);
		IBussiness bean = context.getBean("bussiness", IBussiness.class);
		bean.verfiy();
	}
}
