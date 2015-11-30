/**
 * ×óÐý×ª×Ö·û´®
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p42_II {

	public static void main(String[] args) {

		System.out.println(leftSpin("abcde", 2));
	}

	public static String leftSpin(String str, int num) {
		if (str == null || num <= 0 || str.length() == 0)
			return null;
		if (num >= str.length())
			return str;
		char[] form = str.substring(0, num).toCharArray();
		char[] late = str.substring(num, str.length()).toCharArray();
		p42.exchange(form);
		p42.exchange(late);
		String all = new String(form).concat(new String(late));
		char[] result = all.toCharArray();
		p42.exchange(result);
		return new String(result);
	}

}
