package yu.aopChain.verfiyProcessor;

import org.springframework.stereotype.Component;
import yu.aopChain.parser.MethodInoker;
import yu.aopChain.verfiyAnnotation.VerfiyRule3;

import java.lang.annotation.Annotation;

@Component
public class Rule3VerfiyProcessor implements VerfiyProcessor {

	@Override
	public void handleRule(MethodInoker methodInoker) {
		methodInoker.proceed();
		System.out.println("After Rule3VerfiyProcessor");
	}

	@Override
	public <A extends Annotation> VerfiyProcessor canApplyPorcessor(Class<A> annotationType) {
		if(annotationType == VerfiyRule3.class) {
			return this;
		}
		return null;
	}
}
