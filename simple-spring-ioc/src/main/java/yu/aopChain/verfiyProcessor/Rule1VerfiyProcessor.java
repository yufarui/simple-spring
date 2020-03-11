package yu.aopChain.verfiyProcessor;

import org.springframework.stereotype.Component;
import yu.aopChain.parser.MethodInoker;
import yu.aopChain.verfiyAnnotation.VerfiyRule1;

import java.lang.annotation.Annotation;

@Component
public class Rule1VerfiyProcessor implements VerfiyProcessor {

	@Override
	public void handleRule(MethodInoker methodInoker) {
		try {
			methodInoker.proceed();
		} finally {
			System.out.println("finally Rule1VerfiyProcessor");
		}

	}

	@Override
	public <A extends Annotation> VerfiyProcessor canApplyPorcessor(Class<A> annotationType) {
		if (annotationType == VerfiyRule1.class) {
			return this;
		}
		return null;
	}
}
