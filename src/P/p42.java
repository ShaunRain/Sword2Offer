/**
 * 反转句子,单词不变
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p42 {

	public static void main(String[] args) {

		System.out.println(reversePhrase("i what i am."));
	}

	public static String reversePhrase(String phrase) {
		char[] c = phrase.toCharArray();
		exchange(c);
		return reverseWords(new String(c));

	}

	public static String reverseWords(String phrase) {
		String[] words = phrase.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String s : words) {
			char[] c = s.toCharArray();
			exchange(c);
			sb.append(new String(c) + " ");
		}
		return sb.toString();
	}

	/**
	 * @param c
	 * @param left
	 * @param right
	 */
	public static void exchange(char[] c) {
		int left = 0;
		int right = c.length - 1;
		while (left <= right) {
			char temp = c[left];
			c[left] = c[right];
			c[right] = temp;
			left++;
			right--;
		}

	}

}
