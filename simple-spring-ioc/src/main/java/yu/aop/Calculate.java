package yu.aop;

public interface Calculate {

	int add(int numA, int numB);

	int addWithError(int numA, int numB);

	int reduce(int numA, int numB);

	int div(int numA, int numB);

	int multi(int numA, int numB);

	int mod(int numA, int numB);

	int modWithAOPContextProxy(int numA, int numB);
}
