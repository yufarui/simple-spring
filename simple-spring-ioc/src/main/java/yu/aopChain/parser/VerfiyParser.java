package yu.aopChain.parser;

import yu.aopChain.verfiyProcessor.VerfiyProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface VerfiyParser extends InvocationHandler {

	<A extends Annotation> VerfiyProcessor findEligibleProcessor(Class<A> annotationType);

	Object handleBussinessVerfiy(Object target, Method method, Object... args);

	void setTargetBean(Object targetBean);
}
