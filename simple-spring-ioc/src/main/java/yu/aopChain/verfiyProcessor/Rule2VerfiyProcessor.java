package yu.aopChain.verfiyProcessor;

import org.springframework.stereotype.Component;
import yu.aopChain.parser.MethodInoker;
import yu.aopChain.verfiyAnnotation.VerfiyRule2;

import java.lang.annotation.Annotation;

@Component
public class Rule2VerfiyProcessor implements VerfiyProcessor {

	@Override
	public void handleRule(MethodInoker methodInoker) {
		System.out.println("Before Rule2VerfiyProcessor");
		methodInoker.proceed();

	}

	@Override
	public <A extends Annotation> VerfiyProcessor canApplyPorcessor(Class<A> annotationType) {
		if (annotationType == VerfiyRule2.class) {
			return this;
		}
		return null;
	}
}
