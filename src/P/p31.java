/**
 * 输入一个整形数组，数组里有证书也有负数。数组中一个或连续多个整数构成子数组，求子数组和的最大值。要求O(n)
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p31 {

	public static void main(String[] args) {

		maxSum(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 });

	}

	// method 1
	public static void maxSum(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		int currSum = 0;
		int maxSum = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (currSum <= 0) {
				currSum = nums[i];
				begin = i;
			} else
				currSum += nums[i];

			if (currSum >= maxSum) {
				maxSum = currSum;
				end = i;
			}
		}

		System.out.println("index:" + begin + "~" + end);
		System.out.println(maxSum);

	}

}
