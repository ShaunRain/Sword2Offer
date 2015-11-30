/**
 * 输入一个整数数组，输出所有元素拼接数的最小值
 */
package P;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Shaun Rain 2014
 */
public class p33 {

	public static void main(String[] args) {

		minOfConnect(new String[] { "31", "32", "321", "11" });
		
	}

	public static void minOfConnect(String[] nums) {

		if (nums == null || nums.length == 0)
			return;

		Collections.sort(Arrays.asList(nums), new Comparator<String>() {
			public int compare(String n1, String n2) {

				char[] c12 = (n1 + n2).toCharArray();
				char[] c21 = (n2 + n1).toCharArray();

				int result = 0;
				int len = c12.length;
				for (int i = 0; i < len; i++) {
					if (c12[i] > c21[i]) {
						result = 1;
						break;
					} else if (c12[i] < c21[i]) {
						result = -1;
						break;
					}
				}

				return result;

			};
		});

		for (String s : nums)
			System.out.print(s);

	}

}
