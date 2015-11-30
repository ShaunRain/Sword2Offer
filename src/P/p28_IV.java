/**
 * N»Êºó
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p28_IV {

	public static void main(String[] args) {
		nQueue(new int[] { 0, 1, 2, 3, 4, 5 }, 0, 5);
	}

	public static void nQueue(int[] nums, int begin, int end) {

		if (begin == end) {

			boolean flag = true;

			for (int i = 0; i < end; i++) {
				for (int j = i + 1; j <= end; j++) {
					if (Math.abs(j - i) == Math.abs(nums[j] - nums[i])) {
						flag = false;
					}
				}
			}

			if (flag)
				System.out.println(Arrays.toString(nums));
		}

		else {
			for (int n = begin; n <= end; n++) {

				int temp = nums[n];
				nums[n] = nums[begin];
				nums[begin] = temp;

				nQueue(nums, begin + 1, end);

				temp = nums[n];
				nums[n] = nums[begin];
				nums[begin] = temp;
			}
		}
	}
}
