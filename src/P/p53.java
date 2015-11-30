/**
 * 实现一个函数匹配包含'.'和'*'的正则表达式。
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p53 {
	static char[] str;
	static char[] pattern;

	public static void main(String[] args) {

		str = "aaa".toCharArray();
		pattern = "ab*ac*a".toCharArray();
		System.out.println(match());
	}

	public static boolean match() {
		if (str == null || pattern == null)
			return false;
		return matchCode(0, 0);
	}

	public static boolean matchCode(int i, int j) {
		if (i >= str.length && j >= pattern.length)
			return true;
		if (i < str.length && j >= pattern.length)
			return false;

		if (j < pattern.length - 1 && pattern[j + 1] == '*') {
			if (pattern[j] == str[i]
					|| (pattern[j] == '.' && i < str.length - 1)) {
				return matchCode(i + 1, j) || matchCode(i + 1, j + 2)
						|| matchCode(i, j + 2);
			} else
				return matchCode(i, j + 2);
		}

		if (pattern[j] == str[i] || (pattern[j] == '.' && i < str.length - 1))
			return matchCode(i + 1, j + 1);
		return false;
	}
}
