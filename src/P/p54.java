/**
 * 请实现一个函数用来判断字符串是否表示数值。
 */
package P;

public class p54 {

	static int count_e;
	static int count_dot;

	public static void main(String[] args) {

		System.out.println(isNumber("12e+5.4".toCharArray()));

	}

	public static boolean isNumber(char[] str) {
		if (str == null || str.length < 1)
			return false;
		count_e = 0;
		count_dot = 0;
		return is(str, 0, '@');
	}

	public static boolean is(char[] str, int index, char before) {

		if (index == str.length) {
			if (before == '+' || before == '-' || before == '.'
					|| before == 'e')
				return false;
			else
				return true;
		}

		if (((str[index] == '+' || str[index] == '-') && (before == '@' || before == 'e'))
				|| isDigits(str[index]))
			return is(str, index + 1, str[index]);

		if (str[index] == '.' && isDigits(before) && count_dot == 0) {
			count_dot++;
			return is(str, index + 1, str[index]);
		}
		if (str[index] == 'e' && isDigits(before) && count_e == 0) {
			count_e++;
			count_dot++;
			return is(str, index + 1, str[index]);
		}

		return false;
	}

	public static boolean isDigits(char c) {
		return (c >= '0' && c <= '9') ? true : false;
	}

}
