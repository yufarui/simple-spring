package yu.config;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(new Test().lengthOfLongestSubstring("anviaj"));
	}

	public boolean oneEditAway(String first, String second) {
		if (first == null && second == null || first.equals(second)) {
			return true;
		}

		if (first == null && second.length() == 1 || (second == null && first.length() == 1)) {
			return true;
		}
		String cb = first.length() >= second.length() ? first : second;
		String cs = first.length() < second.length() ? first : second;

		if (cb.length() - cs.length() > 1) {
			return false;
		}

		for (int i = 0; i < cb.length(); i++) {
			char tmp = cb.charAt(i);
			if (cb.length() > cs.length() && i == cb.length() - 1) {
				return cb.equals(cs + tmp);
			}
			if (tmp != cs.charAt(i)) {
				return cb.equals(cs.substring(0, i) + tmp + cs.substring(i + 1)) ||
					cb.equals(cs.substring(0, i) + tmp + cs.substring(i));
			}
		}

		return false;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() < 2) {
			return s.length();
		}

		int max = 1;
		int i, j;
		retry:
		for (i = 0; i < s.length(); i++) {
			int sum = 1;
			for (j = i + 1; j < s.length(); j++) {
				if (s.length() - i + 1 < max) {
					break retry;
				}
				if (s.substring(i, j).contains(s.charAt(j) + "")) {
					continue retry;
				}
				max = Math.max(max, ++sum);
			}
		}

		return max;
	}
}
