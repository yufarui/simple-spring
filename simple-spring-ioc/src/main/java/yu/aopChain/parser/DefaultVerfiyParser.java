package yu.aopChain.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yu.aopChain.verfiyProcessor.VerfiyProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class DefaultVerfiyParser implements VerfiyParser {

	@Autowired
	private Map<String, VerfiyProcessor> verfiyProcessorMap;
	private Object targetBean;


	private List<VerfiyProcessor> verfiyProcessorHandler = new ArrayList<>();

	@Override
	public <A extends Annotation> VerfiyProcessor findEligibleProcessor(Class<A> annotationType) {

		Collection<VerfiyProcessor> verfiyProcessors = verfiyProcessorMap.values();
		for (VerfiyProcessor processor : verfiyProcessors) {
			VerfiyProcessor applyPorcessor = processor.canApplyPorcessor(annotationType);
			if (applyPorcessor != null) {
				return applyPorcessor;
			}
		}
		return null;
	}

	@Override
	public Object handleBussinessVerfiy(Object target, Method method, Object... args) {
		Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
		for (int i = 0; i < declaredAnnotations.length; i++) {
			VerfiyProcessor eligibleProcessor = findEligibleProcessor(declaredAnnotations[i].annotationType());
			if (eligibleProcessor != null) {
				verfiyProcessorHandler.add(eligibleProcessor);
			}
		}

		sort(verfiyProcessorHandler);

		MethodInoker methodInoker = new MethodInoker(target, method, args, verfiyProcessorHandler);
		return methodInoker.proceed();
	}

	private void sort(List<VerfiyProcessor> verfiyProcessorHandler) {

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return handleBussinessVerfiy(targetBean, method, args);
	}

	@Override
	public void setTargetBean(Object targetBean) {
		this.targetBean = targetBean;
	}
}
