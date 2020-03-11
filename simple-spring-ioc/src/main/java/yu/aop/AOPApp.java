package yu.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		Calculate calculate = ctx.getBean("aopCalculate", Calculate.class);
		System.out.println("==== add ====");
		calculate.add(2, 4);

		System.out.println("==== addWithError ====");
		try {
			calculate.addWithError(2, 4);
		} catch (Exception e) {

		}

		System.out.println("==== modWithAOPContextProxy ====");
		calculate.modWithAOPContextProxy(2, 4);

		System.out.println("==== mod ====");
		calculate.mod(2, 4);
	}
}
