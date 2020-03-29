package yu;

public class InnerSingleton {

	private static class InnerSinleHodler {
		private static InnerSingleton innerSingleton = new InnerSingleton();
	}

	private InnerSingleton() {
		System.out.println(123);
	}

	public static InnerSingleton getInstance() {
		return InnerSinleHodler.innerSingleton;
	}

	public static void main(String[] args) {
		getInstance();
	}
}

