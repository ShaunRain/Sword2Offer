/**
 * 找出字符流中第一个只出现一次的字符
 */
package P;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Shaun Rain 2014
 */
public class p55 {

	static class Node {
		String value;
		Node next;

		public Node(String v) {
			this.value = v;
		}
	}

	public static void main(String[] args) {

		System.out.println(firstSingle("googleeatapple".toCharArray()));
		System.out.println("Coder".replaceAll("coder", "#"));
		System.out.println(Arrays.toString(findCoder(new String[] {
				"coder coder ", "cccc", "codeR" ,"fasdads"}, 3)));

	}

	public static String[] findCoder(String[] A, int n) {
		if (n == 0)
			return null;
		Node[] results = new Node[A.length];
		for (int i = 0; i < results.length; i++) {
			int result = count(A[i]);
			System.out.println(result);
			if (result > 0) {
				if (results[result] == null)
					results[result] = new Node(A[i]);
				else {
					Node curr = results[result];
					while (curr.next != null)
						curr = curr.next;
					curr.next = new Node(A[i]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = results.length - 1; i > 0; i--) {
			if (results[i] != null) {
				Node curr = results[i];
				while (curr != null) {
					sb.append(curr.value + "@");
					curr = curr.next;
				}
			}
		}

		return sb.toString().split("@");

	}

	public static int count(String str) {
		if (str.length() < 5)
			return 0;
		int count = 0;
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++)
			array[i] = Character.toLowerCase(array[i]);
		str = new String(array);
		str = str.replaceAll("coder", "@");
		System.out.println(str);
		for (char c : str.toCharArray()) {
			if (c == '@')
				count++;
		}
		return count;
	}

	public static char firstSingle(char[] str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int index = 0;
		for (char c : str) {
			if (map.containsKey(c)) {
				map.replace(c, -1);
			} else
				map.put(c, index);
			++index;
		}
		int min = str.length;
		for (int i : map.values()) {
			if (i > 0 && i < min)
				min = i;
		}
		return str[min];
	}
}
