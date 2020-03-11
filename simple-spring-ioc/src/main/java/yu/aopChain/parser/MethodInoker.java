package yu.aopChain.parser;

import yu.aopChain.verfiyProcessor.VerfiyProcessor;

import java.lang.reflect.Method;
import java.util.List;

public class MethodInoker {

	private Object target;
	private Method method;
	private Object[] args;

	private List<VerfiyProcessor> verfiyProcessorHandler;

	private int currentProcessorIndex = -1;

	public MethodInoker(Object target, Method method, Object[] args, List<VerfiyProcessor> verfiyProcessorHandler) {
		this.target = target;
		this.method = method;
		this.args = args;
		this.verfiyProcessorHandler = verfiyProcessorHandler;
	}

	public Object proceed() {
		if (verfiyProcessorHandler.size() == 0) {
			return invokeTarget();
		}
		if (currentProcessorIndex == verfiyProcessorHandler.size() - 1) {
			return invokeTarget();
		}
		VerfiyProcessor processor = verfiyProcessorHandler.get(++currentProcessorIndex);
		processor.handleRule(this);
		return null;
	}

	private Object invokeTarget() {
		try {
			return method.invoke(target, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
