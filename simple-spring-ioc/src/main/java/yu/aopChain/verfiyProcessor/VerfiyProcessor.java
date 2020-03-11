package yu.aopChain.verfiyProcessor;

import yu.aopChain.parser.MethodInoker;

import java.lang.annotation.Annotation;

public interface VerfiyProcessor {

	void handleRule(MethodInoker methodInoker);

	<A extends Annotation> VerfiyProcessor canApplyPorcessor(Class<A> annotationType);
}
