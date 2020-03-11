package yu.aop;

import org.springframework.aop.framework.AopContext;

public class MyCalculate implements Calculate {

	public int add(int numA, int numB) {
		System.out.println("执行目标方法:add");
		//System.out.println(1/0);
		return numA + numB;
	}

	@Override
	public int addWithError(int numA, int numB) {
		System.out.println("执行目标方法:addWithError");
		System.out.println(1 / 0);
		return numA + numB;
	}

	public int reduce(int numA, int numB) {
		System.out.println("执行目标方法:reduce");
		return numA - numB;
	}

	public int div(int numA, int numB) {
		System.out.println("执行目标方法:div");

		return numA / numB;
	}

	public int multi(int numA, int numB) {
		System.out.println("执行目标方法:multi");

		return numA * numB;
	}

	@Override
	public int mod(int numA, int numB) {
		System.out.println("执行目标方法:mod");

		int retVal = this.add(numA, numB);

		return retVal % numA;
	}

	public int modWithAOPContextProxy(int numA, int numB) {
		System.out.println("执行目标方法:modWithAOPContextProxy");

		// exposeProxy = true
		int retVal = ((Calculate) AopContext.currentProxy()).add(numA, numB);

		return retVal % numA;
	}
}
