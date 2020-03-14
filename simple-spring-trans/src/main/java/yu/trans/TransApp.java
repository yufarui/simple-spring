package yu.trans;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yu.trans.config.MainConfig;
import yu.trans.service.PayService;


public class TransApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		PayService payService = context.getBean(PayService.class);
		payService.query("123456789");
		try {
			payService.pay("123456789", 10);
		} catch (Exception e) {

		}
		payService.query("123456789");
	}
}
